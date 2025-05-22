package cn.lg


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


//@SpringBootApplication(scanBasePackages = ["cn.lg.demo", "cn.lg.other.lifecycle"])
//@SpringBootApplication(scanBasePackages = ["cn.lg.demo", "cn.lg.other.scope"])
//@SpringBootApplication(scanBasePackages = ["cn.lg.demo", "cn.lg.other.event.impl"])
//@SpringBootApplication(scanBasePackages = ["cn.lg.demo", "cn.lg.other.event.annotation"])
@SpringBootApplication(scanBasePackages = ["cn.lg.freemarker"])
class MyApplication

fun main(vararg args: String) {
    runApplication<MyApplication>(*args)
}

