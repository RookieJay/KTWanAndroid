package pers.jay.common.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel<T> : ViewModel() {

    val mLiveData: MutableLiveData<T> = MutableLiveData()
    val mErrorData: MutableLiveData<String> = MutableLiveData()

    open class UiState<T>(
        val isLoading: Boolean = false,
        val isRefresh: Boolean = false,
        val isSuccess: T? = null,
        val isError: String?= null
    )

    open class BaseUiModel<T>(
        var showLoading: Boolean = false,
        var showError: String? = null,
        var showSuccess: T? = null,
        var showEnd: Boolean = false, // 加载更多
        var isRefresh: Boolean = false // 刷新

    )

    fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {

        viewModelScope.launch { block() }

    }

    suspend fun <T> launchOnIO(block: suspend CoroutineScope.() -> T) {
        withContext(Dispatchers.IO) {
            block
        }
    }
}