package cn.lg.other.event.annotation

import cn.lg.other.event.HelloEventImpl
import cn.lg.other.event.PojoEvent
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component


/*
 * Auth: taolu
 * Date: 2025/3/13 10:55
 */
@Component
class AnnotationListener {

    @EventListener
    fun handleEvent(event: HelloEventImpl) {
        println("The event occurred with the message: ${event.source}, msg: ${event.msg}")
    }

    @EventListener
    fun handleEventPojo(event: PojoEvent) {
        println("POJO event is being handled...: $event")
    }

    @Bean
    fun runner(publisher: ApplicationEventPublisher): CommandLineRunner = CommandLineRunner {
        publisher.publishEvent(HelloEventImpl(this, "Hello World!"))
        publisher.publishEvent(PojoEvent())
    }

}