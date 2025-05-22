package cn.lg.freemarker

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


/*
 * Auth: taolu
 * Date: 2025/5/8 10:23
 */
@Controller
class PizzeriaController {
    private val pizzaList: List<Pizza> = listOf(
        Pizza("Margherita", 5.0),
        Pizza("Napoletana", 6.0),
        Pizza("Calzone", 7.5)
    )

    @GetMapping("/home")
    fun home(model: Model) = model.addAttribute("pizzas", pizzaList).let { "menu" }


}
