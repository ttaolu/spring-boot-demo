package demo

import org.junit.jupiter.api.Test

//@SpringBootTest
class MyApplicationTests {
    /**
     *
     * Mockito是一个模拟Java或Kotlin对象的框架。它通过用模仿对象代替依赖项，简化了具有外部依赖项的对象和类的单元测试开发。
     * AssertJ支持在测试中使用丰富的人类可读API编写流畅的断言。
     * Hamcrest通过添加声明式匹配器来帮助编写测试。
     *
     *
     * SpringExtension class, which is used to integrate TestContext Framework into JUnit5.
     * JUnit5 uses @ExtendWith annotation to add any extensions to tests
     * (for example @ExtendWith(MockitoExtension.class) in Java or@ExtendWith(MockitoExtension::class) in Kotlin).
     * So, for Spring it works the same way: we need to use the annotation construction to extend
     * tests with Spring features.
     *
     * @ContextConfiguration, which specifies how to load and configure an application context for tests.
     *
     * @SpringJUnitConfig, a combination of @ExtendWith(SpringExtension.class)
     * ( or @ExtendWith(SpringExtension::class) in Kotlin) and @ContextConfiguration.
     */

    @Test
    fun contextLoads() {
    }



}
