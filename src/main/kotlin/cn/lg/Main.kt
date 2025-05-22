package cn.lg

/*
 * Auth: taolu
 * Date: 2024/12/31 17:17
 */

fun demo() {
//    fun fun1(a: Long, b: Long): Long = a.times(b)
//    val fun2 = fun(a: Long, b: Long): Long = a.times(b)
//    val fun3: (Long, Long) -> Long = Long::times

//    val lambdaA: (Long, Long) -> Long = { a, b -> (a..b).reduce(::fun1) }



    // 普通函数
    fun fun1(a: Int, b: Int): Int {
        return a.times(b)
    }
    // 普通单行函数， 可根据单行表达式推断返回类型
    fun fun2(a: Int, b: Int) = a.times(b)

    // 匿名函数
    val fun3 = fun(a: Int, b: Int): Int {
        return a * b
    }
    // 匿名单行函数
    val fun4 = fun(a: Int, b: Int) = a.times(b)

    // lambda
    val fun7 = { a: Int, b: Int -> a.times(b) } // lambda 最后一行作为函数返回值，不支持return关键字
    val fun8: (Int, Int) -> Int = Int::times // 方法引用不能根据上下文推断时需要指定类型
//    val fun9 = Int::times //ERROR: Overload resolution ambiguity. All these functions match. 第二个参数重载多个类型

    // return 中止单次调用, 相当于 continue
    listOf(1, 2, 3, 4).forEach {
        if (it == 3) return@forEach  // Skipping number 3
        println(it) // 1、2、4
    }
    println("End")

    // try 返回值是try或某个catch的最后一行，而不会是finally里的

}
