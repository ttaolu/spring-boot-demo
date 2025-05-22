package cn.lg.other.event.impl

import cn.lg.other.event.HelloEventImpl
import cn.lg.other.event.PojoEvent
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component


/*
 * Auth: taolu
 * Date: 2025/3/13 10:31
 */
@Component
class HelloListenerOneImpl: ApplicationListener<HelloEventImpl> {
    override fun onApplicationEvent(event: HelloEventImpl) {
        println("First listener handled the event, source: ${event.source}, msg: ${event.msg}")
    }
}

@Component
class HelloListenerTwoImpl: ApplicationListener<HelloEventImpl> {
    override fun onApplicationEvent(event: HelloEventImpl) {
        println("Second listener handled the event, source: ${event.source}, msg: ${event.msg}")
    }
}

@Component
class GenerateEventRunner(val publisher: ApplicationEventPublisher): CommandLineRunner {
    override fun run(vararg args: String?) {
        // 两个监听器仅处理HelloWorld 事件
        publisher.publishEvent(HelloEventImpl(this, "Hello World!"))
        publisher.publishEvent(PojoEvent()) // 不会处理非 HelloEventImpl 事件
    }

}