package cn.lg.mvc

import org.springframework.boot.CommandLineRunner
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody


/*
 * Auth: taolu
 * Date: 2025/5/7 15:28
 */
@Controller
class GreetingController: CommandLineRunner {
    override fun run(vararg args: String?) {
        println("xxxxxxxxxxxxxxxxxxx")
    }

    @GetMapping(value = ["/greeting"], produces = [MediaType.TEXT_HTML_VALUE])
    @ResponseBody
    fun greeting(): String {
        println("yyyyyyyyyyyyy")
        return "<html><p>Hello and welcome!</p></html>"
    }

}