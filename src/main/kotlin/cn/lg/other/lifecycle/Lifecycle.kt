package cn.lg.other.lifecycle

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component


/*
 * Auth: taolu
 * Date: 2025/3/13 14:26
 */
class Lifecycle : InitializingBean, DisposableBean {

    /* create -> DI -> init(call back, and call before after) -> use -> destroy(call back)
     *
     * Container started
     * Bean created
     * Dependencies injected
     * (A: Call Before init)
     * Bean initialized(call init 1 @PostConstruct, 2 InitializingBean.afterPropertiesSet, 3 @Bean.initMethod)
     * (B: Call After init)
     * Bean is read for use
     * Bean is used by the app
     * (call 4 @PreDestroy, 5 DisposableBean.destroy, 6 @Bean.destroyMethod)
     * Bean destroyed
     */
    @PostConstruct
    fun init() {
        println("1--------@PostConstruct method")
    }

    @PreDestroy
    fun preDestroy() {
        println("4--------@PreDestroy method")
    }

    override fun afterPropertiesSet() {
        println("2--------InitializingBean.afterPropertiesSet")
    }

    override fun destroy() {
        println("5--------DisposableBean.destroy")
    }

    private fun start() {
        println("3--------start")
    }

    private fun stop() {
        println("6--------stop")
    }

}

@Component
class Config {

    @Bean(initMethod = "start", destroyMethod = "stop")
    fun lifecycle2(): Lifecycle = Lifecycle()

    @Bean
    fun printBeans(): BeanPostProcessor = object : BeanPostProcessor {
        override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
            if (bean is Lifecycle) println("A--------beanName: $beanName Before init")
            return super.postProcessBeforeInitialization(bean, beanName)
        }

        override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
            if (bean is Lifecycle) println("B--------beanName: $beanName After init")
            return super.postProcessAfterInitialization(bean, beanName)
        }
    }

}