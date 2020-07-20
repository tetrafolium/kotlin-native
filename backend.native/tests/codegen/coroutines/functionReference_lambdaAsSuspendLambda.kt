/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

package codegen.coroutines.functionReference_lambdaAsSuspendLambda

import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.*
import kotlin.test.*

fun foo(block: (Continuation<Unit>) -> Any?) {
    block as (suspend () -> Unit)
}

@Test fun runTest() {
    foo {}
}
