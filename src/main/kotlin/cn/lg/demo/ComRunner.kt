package cn.lg.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component


/*
 * Auth: taolu
 * Date: 2025/3/13 10:22
 */
@Component
class MyRunner(val context: ApplicationContext): CommandLineRunner {
    override fun run(vararg args: String) {
        println(" ComRunner.kt -----run... $context" )
    }
}