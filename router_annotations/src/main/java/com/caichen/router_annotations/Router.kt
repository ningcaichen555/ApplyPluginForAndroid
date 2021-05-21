package com.caichen.router_annotations

/**
 * 路由注解
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Router(val url: String, val description: String)
