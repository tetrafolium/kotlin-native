/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

package codegen.controlflow.for_loops_types

import kotlin.test.*

@Test fun runTest() {
    for (i in 0.toByte()..4.toByte()) print(i); println()
    for (i in 0.toByte()..4.toShort()) print(i); println()
    for (i in 0.toByte()..4.toInt()) print(i); println()
    for (i in 0.toByte()..4.toLong()) print(i); println()
    for (i in 0.toShort()..4.toByte()) print(i); println()
    for (i in 0.toShort()..4.toShort()) print(i); println()
    for (i in 0.toShort()..4.toInt()) print(i); println()
    for (i in 0.toShort()..4.toLong()) print(i); println()
    for (i in 0.toInt()..4.toByte()) print(i); println()
    for (i in 0.toInt()..4.toShort()) print(i); println()
    for (i in 0.toInt()..4.toInt()) print(i); println()
    for (i in 0.toInt()..4.toLong()) print(i); println()
    for (i in 0.toLong()..4.toByte()) print(i); println()
    for (i in 0.toLong()..4.toShort()) print(i); println()
    for (i in 0.toLong()..4.toInt()) print(i); println()
    for (i in 0.toLong()..4.toLong()) print(i); println()
    for (i in 0.toByte() until 4.toByte()) print(i); println()
    for (i in 0.toByte() until 4.toShort()) print(i); println()
    for (i in 0.toByte() until 4.toInt()) print(i); println()
    for (i in 0.toByte() until 4.toLong()) print(i); println()
    for (i in 0.toShort() until 4.toByte()) print(i); println()
    for (i in 0.toShort() until 4.toShort()) print(i); println()
    for (i in 0.toShort() until 4.toInt()) print(i); println()
    for (i in 0.toShort() until 4.toLong()) print(i); println()
    for (i in 0.toInt() until 4.toByte()) print(i); println()
    for (i in 0.toInt() until 4.toShort()) print(i); println()
    for (i in 0.toInt() until 4.toInt()) print(i); println()
    for (i in 0.toInt() until 4.toLong()) print(i); println()
    for (i in 0.toLong() until 4.toByte()) print(i); println()
    for (i in 0.toLong() until 4.toShort()) print(i); println()
    for (i in 0.toLong() until 4.toInt()) print(i); println()
    for (i in 0.toLong() until 4.toLong()) print(i); println()
    for (i in 4.toByte() downTo 0.toByte()) print(i); println()
    for (i in 4.toByte() downTo 0.toShort()) print(i); println()
    for (i in 4.toByte() downTo 0.toInt()) print(i); println()
    for (i in 4.toByte() downTo 0.toLong()) print(i); println()
    for (i in 4.toShort() downTo 0.toByte()) print(i); println()
    for (i in 4.toShort() downTo 0.toShort()) print(i); println()
    for (i in 4.toShort() downTo 0.toInt()) print(i); println()
    for (i in 4.toShort() downTo 0.toLong()) print(i); println()
    for (i in 4.toInt() downTo 0.toByte()) print(i); println()
    for (i in 4.toInt() downTo 0.toShort()) print(i); println()
    for (i in 4.toInt() downTo 0.toInt()) print(i); println()
    for (i in 4.toInt() downTo 0.toLong()) print(i); println()
    for (i in 4.toLong() downTo 0.toByte()) print(i); println()
    for (i in 4.toLong() downTo 0.toShort()) print(i); println()
    for (i in 4.toLong() downTo 0.toInt()) print(i); println()
    for (i in 4.toLong() downTo 0.toLong()) print(i); println()
    for (i in 'a'..'d') print(i); println()
    for (i in 'a' until 'd') print(i); println()
    for (i in 'd' downTo 'a') print(i); println()

    for (i in 0.toByte()..4.toByte() step 2) print(i); println()
    for (i in 0.toByte()..4.toShort() step 2) print(i); println()
    for (i in 0.toByte()..4.toInt() step 2) print(i); println()
    for (i in 0.toByte()..4.toLong() step 2L) print(i); println()
    for (i in 0.toShort()..4.toByte() step 2) print(i); println()
    for (i in 0.toShort()..4.toShort() step 2) print(i); println()
    for (i in 0.toShort()..4.toInt() step 2) print(i); println()
    for (i in 0.toShort()..4.toLong() step 2L) print(i); println()
    for (i in 0.toInt()..4.toByte() step 2) print(i); println()
    for (i in 0.toInt()..4.toShort() step 2) print(i); println()
    for (i in 0.toInt()..4.toInt() step 2) print(i); println()
    for (i in 0.toInt()..4.toLong() step 2L) print(i); println()
    for (i in 0.toLong()..4.toByte() step 2L) print(i); println()
    for (i in 0.toLong()..4.toShort() step 2L) print(i); println()
    for (i in 0.toLong()..4.toInt() step 2L) print(i); println()
    for (i in 0.toLong()..4.toLong() step 2L) print(i); println()
    for (i in 0.toByte() until 4.toByte() step 2) print(i); println()
    for (i in 0.toByte() until 4.toShort() step 2) print(i); println()
    for (i in 0.toByte() until 4.toInt() step 2) print(i); println()
    for (i in 0.toByte() until 4.toLong() step 2L) print(i); println()
    for (i in 0.toShort() until 4.toByte() step 2) print(i); println()
    for (i in 0.toShort() until 4.toShort() step 2) print(i); println()
    for (i in 0.toShort() until 4.toInt() step 2) print(i); println()
    for (i in 0.toShort() until 4.toLong() step 2L) print(i); println()
    for (i in 0.toInt() until 4.toByte() step 2) print(i); println()
    for (i in 0.toInt() until 4.toShort() step 2) print(i); println()
    for (i in 0.toInt() until 4.toInt() step 2) print(i); println()
    for (i in 0.toInt() until 4.toLong() step 2L) print(i); println()
    for (i in 0.toLong() until 4.toByte() step 2L) print(i); println()
    for (i in 0.toLong() until 4.toShort() step 2L) print(i); println()
    for (i in 0.toLong() until 4.toInt() step 2L) print(i); println()
    for (i in 0.toLong() until 4.toLong() step 2L) print(i); println()
    for (i in 4.toByte() downTo 0.toByte() step 2) print(i); println()
    for (i in 4.toByte() downTo 0.toShort() step 2) print(i); println()
    for (i in 4.toByte() downTo 0.toInt() step 2) print(i); println()
    for (i in 4.toByte() downTo 0.toLong() step 2L) print(i); println()
    for (i in 4.toShort() downTo 0.toByte() step 2) print(i); println()
    for (i in 4.toShort() downTo 0.toShort() step 2) print(i); println()
    for (i in 4.toShort() downTo 0.toInt() step 2) print(i); println()
    for (i in 4.toShort() downTo 0.toLong() step 2L) print(i); println()
    for (i in 4.toInt() downTo 0.toByte() step 2) print(i); println()
    for (i in 4.toInt() downTo 0.toShort() step 2) print(i); println()
    for (i in 4.toInt() downTo 0.toInt() step 2) print(i); println()
    for (i in 4.toInt() downTo 0.toLong() step 2L) print(i); println()
    for (i in 4.toLong() downTo 0.toByte() step 2L) print(i); println()
    for (i in 4.toLong() downTo 0.toShort() step 2L) print(i); println()
    for (i in 4.toLong() downTo 0.toInt() step 2L) print(i); println()
    for (i in 4.toLong() downTo 0.toLong() step 2L) print(i); println()
    for (i in 'a'..'d' step 2) print(i); println()
    for (i in 'a' until 'd' step 2) print(i); println()
    for (i in 'd' downTo 'a' step 2) print(i); println()
}
