package dev.hx2

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import org.koin.ktor.plugin.koin

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    koin {

    }
    install(CallLogging)
    routing {
        get("/a") {
            call.respondText { "Hello, world!" }
        }
        get("/") {
            call.respondHtml {
                index()
            }
        }
    }
}

fun HTML.index() {
    classes = setOf("bg-gray-100", "h-full")
    head {
        title { +"Ktor: HTML DSL" }
        script(src = "https://cdn.tailwindcss.com") {}
        script(src = "https://unpkg.com/htmx.org@1.9.10") {}
        script(src = "https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js") {
            defer = true
        }
    }
    body {
        classes = setOf("h-full")
        div {
            classes = setOf("min-h-full")
        }
    }
}