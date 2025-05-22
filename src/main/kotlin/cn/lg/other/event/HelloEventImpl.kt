package cn.lg.other.event

import org.springframework.context.ApplicationEvent


/*
 * Auth: taolu
 * Date: 2025/3/13 10:17
 */
class HelloEventImpl(source: Any, val msg: String): ApplicationEvent(source)