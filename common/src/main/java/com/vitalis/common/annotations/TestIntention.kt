package com.vitalis.common.annotations

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class TestIntention(val value: String = "")
