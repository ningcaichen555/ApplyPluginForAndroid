package com.caichen.router_processor

import com.caichen.router_annotations.Router
import com.google.auto.service.AutoService
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement

@AutoService(Processor::class)
class RouterProcessor : AbstractProcessor() {
    override fun process(
        annotations: MutableSet<out TypeElement>?,
        roundEnv: RoundEnvironment?
    ): Boolean {
        println("RouterProcessor >> start")
        val elements = roundEnv?.getElementsAnnotatedWith(Router::class.java)
        println("elements$elements")
        return false
    }

    /**
     * 支持的注解的类型
     */
    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(Router::class.java.canonicalName)
    }
}