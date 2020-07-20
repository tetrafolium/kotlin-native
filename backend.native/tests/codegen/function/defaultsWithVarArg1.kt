/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

package codegen.function.defaultsWithVarArg1

import kotlin.test.*

fun foo(s: String = "", vararg args: Any) {
    if (args == null) {
        println("Failed!")
    } else {
        print("$s ")
        args.forEach {
            print("$it")
        }
        println(", Correct!")
    }
}

@Test fun runTest() {
    foo("Hello")
    foo("Hello", "World")
    foo()
}
