package cn.lg.other.scope

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.concurrent.ThreadLocalRandom


/*
 * Auth: taolu
 * Date: 2025/3/13 14:19
 *
 */
@Component
class DemoScope {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    fun person() = Person("a man", ThreadLocalRandom.current().nextInt())

    @Bean
    @Primary
    fun hello1() = "hello A"

    @Bean
    fun hello2() = "hello B"

    @Bean
    fun needHello1(h: String) = "hello $h" // use @Primary

    @Bean
    fun needHello2(@Qualifier("hello2") h: String) = "hello $h" // if not Primary use Qualifier

    @Bean
    fun runner(vararg args: String, context: ApplicationContext, p1: Person, p2: Person): CommandLineRunner = CommandLineRunner {
        context.beanDefinitionNames.forEach(::println)
        println(p1 === p2) // false
    }
}

class Person(val name: String, val age: Int)