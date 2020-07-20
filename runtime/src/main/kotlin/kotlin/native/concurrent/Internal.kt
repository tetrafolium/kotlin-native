/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

package kotlin.native.concurrent

import kotlinx.cinterop.*
import kotlin.native.identityHashCode
import kotlin.native.internal.DescribeObjectForDebugging
import kotlin.native.internal.ExportForCppRuntime
import kotlin.native.internal.debugDescription

// Implementation details.

@SymbolName("Kotlin_Worker_stateOfFuture")
internal external fun stateOfFuture(id: Int): Int

@SymbolName("Kotlin_Worker_consumeFuture")
@PublishedApi
internal external fun consumeFuture(id: Int): Any?

@SymbolName("Kotlin_Worker_waitForAnyFuture")
internal external fun waitForAnyFuture(versionToken: Int, millis: Int): Boolean

@SymbolName("Kotlin_Worker_versionToken")
internal external fun versionToken(): Int

@kotlin.native.internal.ExportForCompiler
internal fun executeImpl(
    worker: Worker,
    mode: TransferMode,
    producer: () -> Any?,
    job: CPointer<CFunction<*>>
): Future<Any?> =
    Future<Any?>(executeInternal(worker.id, mode.value, producer, job))

@SymbolName("Kotlin_Worker_startInternal")
internal external fun startInternal(errorReporting: Boolean, name: String?): Int

@SymbolName("Kotlin_Worker_currentInternal")
internal external fun currentInternal(): Int

@SymbolName("Kotlin_Worker_requestTerminationWorkerInternal")
internal external fun requestTerminationInternal(id: Int, processScheduledJobs: Boolean): Int

@SymbolName("Kotlin_Worker_executeInternal")
internal external fun executeInternal(
    id: Int,
    mode: Int,
    producer: () -> Any?,
    job: CPointer<CFunction<*>>
): Int

@SymbolName("Kotlin_Worker_executeAfterInternal")
internal external fun executeAfterInternal(id: Int, operation: () -> Unit, afterMicroseconds: Long): Unit

@SymbolName("Kotlin_Worker_processQueueInternal")
internal external fun processQueueInternal(id: Int): Boolean

@SymbolName("Kotlin_Worker_parkInternal")
internal external fun parkInternal(id: Int, timeoutMicroseconds: Long, process: Boolean): Boolean

@SymbolName("Kotlin_Worker_getNameInternal")
internal external fun getWorkerNameInternal(id: Int): String?

@ExportForCppRuntime
internal fun ThrowWorkerUnsupported(): Unit =
    throw UnsupportedOperationException("Workers are not supported")

@ExportForCppRuntime
internal fun ThrowWorkerInvalidState(): Unit =
    throw IllegalStateException("Illegal transfer state")

@ExportForCppRuntime
internal fun WorkerLaunchpad(function: () -> Any?) = function()

@PublishedApi
@SymbolName("Kotlin_Worker_detachObjectGraphInternal")
internal external fun detachObjectGraphInternal(mode: Int, producer: () -> Any?): NativePtr

@PublishedApi
@SymbolName("Kotlin_Worker_attachObjectGraphInternal")
internal external fun attachObjectGraphInternal(stable: NativePtr): Any?

@SymbolName("Kotlin_Worker_freezeInternal")
internal external fun freezeInternal(it: Any?)

@SymbolName("Kotlin_Worker_isFrozenInternal")
internal external fun isFrozenInternal(it: Any?): Boolean

@ExportForCppRuntime
internal fun ThrowFreezingException(toFreeze: Any, blocker: Any): Nothing =
    throw FreezingException(toFreeze, blocker)

@ExportForCppRuntime
internal fun ThrowInvalidMutabilityException(where: Any): Nothing {
    val description = debugDescription(where::class, where.identityHashCode())
    throw InvalidMutabilityException("mutation attempt of frozen $description")
}

@ExportForCppRuntime
internal fun ThrowIllegalObjectSharingException(typeInfo: NativePtr, address: NativePtr) {
    val description = DescribeObjectForDebugging(typeInfo, address)
    throw IncorrectDereferenceException("illegal attempt to access non-shared $description from other thread")
}

@SymbolName("Kotlin_AtomicReference_checkIfFrozen")
internal external fun checkIfFrozen(ref: Any?)
