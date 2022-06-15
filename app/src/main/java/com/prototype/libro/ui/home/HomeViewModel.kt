package com.prototype.libro.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prototype.libro.util.RetrofitInstance
import com.prototype.model.QuotesData
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class HomeViewModel : ViewModel() {
    private val _data = MutableLiveData<QuotesData>()
    val data: LiveData<QuotesData> = _data

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error
    fun getData() {
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.api.getData()
            } catch (e: IOException) {
                _error.value = "IOException, you might not have internet connection"
                return@launch
            } catch (e: HttpException) {
               _error.value = "HttpException, unexpected response"
                return@launch
            }
            if (response.isSuccessful && response.body() != null) {
                _data.postValue(response.body()!!)
            } else {
                _error.value = "Response not successful"
            }
        }

    }
}