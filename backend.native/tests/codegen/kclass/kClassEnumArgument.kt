/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

package codegen.kclass.kClassEnumArgument

import kotlin.reflect.KClass
import kotlin.test.*

enum class E(val arg: KClass<*>?) {
    A(null as KClass<*>?),
    B(String::class);
}

@Test fun runTest() {
    println(E.B.arg?.simpleName)
}
