/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

import kotlinx.cinterop.*
import platform.Foundation.*
import platform.objc.*
import platform.posix.*
import kotlin.system.exitProcess
import kotlin.test.*

fun exc_handler(x: Any?) {
    println("Uncaught exception handler")
    println(x.toString())
    exitProcess(0)
}

fun main() {
    objc_setUncaughtExceptionHandler(staticCFunction(::exc_handler))

    println(NSJSONSerialization())
}
