/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

package org.jetbrains.kotlin.backend.konan

import org.jetbrains.kotlin.konan.exec.*
import org.jetbrains.kotlin.konan.file.*
import org.jetbrains.kotlin.konan.target.*

fun produceCAdapterBitcode(clang: ClangArgs, cppFileName: String, bitcodeFileName: String) {
    val clangCommand = clang.clangCXX("-std=c++14", cppFileName, "-emit-llvm", "-c", "-o", bitcodeFileName)
    Command(clangCommand).execute()
}
