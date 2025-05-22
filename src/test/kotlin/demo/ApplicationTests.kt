package demo

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


/*
 * Auth: taolu
 * Date: 2025/3/13 16:33
 */
// 在JUnit5中包含Spring测试工具。SpringExtension提供的应用程序上下文已经包含了几个用于内部工作的bean
//@ExtendWith(SpringExtension::class)
//@ContextConfiguration(classes = [Config::class])
// SpringJUnitConfig 代替 ExtendWith， ContextConfiguration 且包含了SpringExtension
// 注入bean， 必须加 @Autowired
//@SpringJUnitConfig(Config::class)


// SpringBoot专门为SpringBoot应用程序引入了一个方便的@SpringBootTest注释。它包括我们上面讨论的所有注解的特性，如果没有嵌入配置和没有指定显式类，它还会自动搜索@SpringBootConfiguration类。
@SpringBootTest
internal class ApplicationTests(private val context: ApplicationContext, @Qualifier("customBean") private val customBean: String) {
    @Test
    fun contextLoads() {
        assertThat(context).isNotNull
        assertThat(context.beanDefinitionNames)
            .contains("customBean", "config")
        assertThat(customBean).isEqualTo("custom bean")
        assertThat(context.beanDefinitionCount).isGreaterThan(10)
    }
}
@Configuration
class Config {
    @Bean
    fun customBean(): String {
        return "custom bean"
    }
}
@Component
class PizzaMenu {
    private val pizzas = listOf("margherita", "mushrooms and vegetables")
    fun isOnMenu(name: String): Boolean {
        return pizzas.contains(name)
    }
}
@Component
class DessertMenu {
    private val desserts = listOf("apple pie", "almond cake")
    fun isOnMenu(name: String): Boolean {
        return desserts.contains(name)
    }
}
@Component
class PizzeriaService (@Autowired private val pizzaMenu: PizzaMenu) {
    fun orderPizza(name: String?): String? {
        return if (pizzaMenu.isOnMenu(name!!)) {
            println("Thanks for the order! Your pizza will be ready in 15 minutes")
            name
        } else {
            println("We don't have such pizza on our menu")
            null
        }
    }
}
@Component
class CafeService(@Autowired private val pizzaMenu: PizzaMenu, @Autowired private val dessertMenu: DessertMenu) {
    fun orderFood(name: String): String? {
        return if (pizzaMenu.isOnMenu(name) || dessertMenu.isOnMenu(name)) {
            println("Thanks for the order. Your $name will be ready soon")
            name
        } else {
            println("We don't have such food on our menu")
            null
        }
    }
}

@SpringBootTest
class PizzeriaServiceTest(
    @Autowired private val pizzeriaService: PizzeriaService,
    @Autowired private val applicationContext: ApplicationContext
) {
    @Test
    fun orderPizza() {
        println(
            "PizzeriaService context hash code: " +
                    System.identityHashCode(applicationContext)
        )
        assertThat(pizzeriaService.orderPizza("pepperoni")).isNull()
    }
}
@SpringBootTest
class CafeServiceTest(
    @Autowired private val cafeService: CafeService,
    @Autowired private val applicationContext: ApplicationContext
) {
    @Test
    fun orderFood() {
        println(
            "CafeService context hash code: " +
                    System.identityHashCode(applicationContext)
        )
        assertThat(cafeService.orderFood("apple pie")).isNotNull
    }
}