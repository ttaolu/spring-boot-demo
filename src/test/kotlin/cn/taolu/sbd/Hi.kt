package cn.taolu.sbd

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.Collections
import kotlin.jvm.javaClass

class Outer {

    fun hi() {
//        Nested.age1
//        Nested.abs1()
    }

    // Nested object 嵌套类： 同java static class
    class Nested {

    }

    // 内部类： 定义实例内部类
    inner class Inner

    // Object declaration (nested object)定义单例， 同java 单例，懒加载， 实现同java静态内部类实现
    object Singleton {

    }

    // 伴生对象， 名称可选(省略后可使用Companion) 同java static 成员
//    companion object Properties
    companion object {

    }
}
