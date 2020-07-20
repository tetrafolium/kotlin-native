/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

import kotlinx.cli.*
import org.jetbrains.benchmarksLauncher.*

class SwiftLauncher : Launcher() {
    override val benchmarks = BenchmarksCollection(
        mutableMapOf()
    )
}
