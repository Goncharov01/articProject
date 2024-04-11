package com.example.goncharov1.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

fun <T> Fragment.collectInViewScope(flow: Flow<T>, block: (T) -> Unit) {
    flow
        .onEach(block)
        .launchIn(this.viewLifecycleOwner.lifecycleScope)
}

fun <T> Flow<T>.observe(
    lifecycleOwner: LifecycleOwner,
    action: suspend (value: T) -> Unit,
) {
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            collect(FlowCollector(action))
        }
    }
}