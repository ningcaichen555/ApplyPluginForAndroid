package com.caichen.router_processor

import com.caichen.router_annotations.Router
import com.google.auto.service.AutoService
import java.io.FileWriter
import java.lang.Exception
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement
import javax.tools.JavaFileObject

@AutoService(Processor::class)
class RouterProcessor : AbstractProcessor() {
    override fun process(
        annotations: MutableSet<out TypeElement>?,
        roundEnv: RoundEnvironment?
    ): Boolean {
        if (roundEnv?.processingOver() == true) {
            return false
        }



        println("RouterProcessor >> start")
        val time = System.currentTimeMillis()
        val className = "com.caichen.applyplugin.router.RouterMapping_${time}"
        val elements = roundEnv?.getElementsAnnotatedWith(Router::class.java)


        // 当未收集到 @Destination 注解的时候，跳过后续流程
        if (elements?.size!! < 1) {
            return false;
        }

        val strBuilder = StringBuilder()
        strBuilder.append("package com.caichen.applyplugin.router;")
        strBuilder.append("\n\n")
        strBuilder.append("import java.util.HashMap;\n")
        strBuilder.append("import java.util.Map;\n")
        strBuilder.append(
            "/**\n" +
                    " *@FileName：RouterMapping_${time}\n" +
                    " *@Description: 路由mapping文件\n" +
                    " *@Author: zoux\n" +
                    " *@Date: ${time}\n" +
                    " */\n"
        )
        strBuilder.append("public class RouterMapping_${time}{\n")
        strBuilder.append("     private Map<String,String> mapping = new HashMap<>();\n")
        strBuilder.append("     public Map<String, String> getMappings(){\n")
        elements?.let {
            for (element in elements) {
                if (element is TypeElement) {
                    println("elements$element")
                    val annotation = element.getAnnotation(Router::class.java)
                    println("url ${annotation.url}")
                    println("description ${annotation.description}")
                    strBuilder.append("             mapping.put(\"${annotation.url}\",\"${element.qualifiedName}\");\n")
                }
            }
        }
        strBuilder.append("             return mapping;\n")
        strBuilder.append("     }\n")
        strBuilder.append("}")
        println(strBuilder)

        try {
            val sourceFile: JavaFileObject =
                processingEnv.filer.createSourceFile(className)
            val openWriter = sourceFile.openWriter()
            openWriter.write(strBuilder.toString())
            openWriter.flush()
            openWriter.close()
        } catch (e: Exception) {
            println("throw exception${e}")
        }

        return false
    }

    /**
     * 支持的注解的类型
     */
    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(Router::class.java.canonicalName)
    }
}