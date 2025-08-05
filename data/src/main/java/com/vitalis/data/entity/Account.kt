package com.vitalis.data.entity

import com.vitalis.common.dto.AccountRegistrationDto
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.stream.Collectors


//Agregate
@Entity
@Table(name = "accounts",)

class Account : UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "id")
    var id: UUID? = null

    @Column(unique = true, length = 100, nullable = false, name = "email")
    var email: String = ""

    @Column(nullable = false, name = "password")
    var _password: String = ""

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    var createdAt: Date? = null

    @UpdateTimestamp
    @Column(name = "updated_at")
    var updatedAt: Date? = null

    @ManyToMany(fetch = FetchType.EAGER,cascade = [(CascadeType.ALL)])
    @JoinTable(
        name = "account_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")],
    )
    @Column(name = "roles", nullable = false)
    var _roles: MutableSet<Role> = mutableSetOf()

    @Column(nullable = false, name = "isAccountNonExpired")
    var _isAccountNonExpired: Boolean = true

    @Column(nullable = false, name = "isAccountNonLocked")
    var _isAccountNonLocked: Boolean = true

    @Column(nullable = false, name = "isCredentialsNonExpired")
    var _isCredentialsNonExpired: Boolean = true

    @Column(nullable = false, name = "isEnabled")
    var _isEnabled: Boolean = true


    fun setRoles(roles: Set<Role>?) {
        this._roles = roles?.toMutableSet() ?: mutableSetOf() // Set to empty set if null
    }

    fun addRole(role: Role?) {
        role?.let { this._roles.add(it) }
    }

    // Override the method explicitly to avoid conflict with Kotlin's property accessor
    override fun getPassword(): String {
        return _password
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return _isAccountNonExpired
    }

    override fun isAccountNonLocked(): Boolean {
        return _isAccountNonLocked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return _isCredentialsNonExpired
    }

    override fun isEnabled(): Boolean {
        return _isEnabled
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return _roles.stream()
            .map { role -> role as GrantedAuthority }
            .collect(Collectors.toSet())
    }

    fun setDefaultRole(role: com.vitalis.common.enums.Role):Account{
        _roles = mutableSetOf(Role(name = role))
        return this



    }


}

fun AccountRegistrationDto.convertEntity(): Account {
    val email = this.email
    val password = this.password
    val roles: MutableSet<Role> = mutableSetOf()

    val account = Account()
    account.email = email
    account._password = password
    account._roles = roles

    return account

}
