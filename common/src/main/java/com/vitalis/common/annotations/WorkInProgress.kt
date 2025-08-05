package com.vitalis.common.annotations







@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkInProgress(val value: String = "")