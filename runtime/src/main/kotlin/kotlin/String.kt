/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

package kotlin

import kotlin.native.internal.ExportTypeInfo
import kotlin.native.internal.Frozen

@ExportTypeInfo("theStringTypeInfo")
@Frozen
public final class String : Comparable<String>, CharSequence {
    public companion object {
    }

    @SymbolName("Kotlin_String_hashCode")
    public external override fun hashCode(): Int

    public operator fun plus(other: Any?): String {
        return plusImpl(other.toString())
    }

    public override fun toString(): String {
        return this
    }

    public override val length: Int
        get() = getStringLength()

    /**
     * Returns the character of this string at the specified [index].
     *
     * If the [index] is out of bounds of this string, throws an [IndexOutOfBoundsException].
     */
    @SymbolName("Kotlin_String_get")
    public external override fun get(index: Int): Char

    @SymbolName("Kotlin_String_subSequence")
    public external override fun subSequence(startIndex: Int, endIndex: Int): CharSequence

    @SymbolName("Kotlin_String_compareTo")
    public external override fun compareTo(other: String): Int

    @SymbolName("Kotlin_String_getStringLength")
    private external fun getStringLength(): Int

    @SymbolName("Kotlin_String_plusImpl")
    private external fun plusImpl(other: String): String

    @SymbolName("Kotlin_String_equals")
    public external override fun equals(other: Any?): Boolean
}

public inline operator fun kotlin.String?.plus(other: kotlin.Any?): kotlin.String =
    (this?.toString() ?: "null").plus(other?.toString() ?: "null")

public inline fun Any?.toString() = this?.toString() ?: "null"
