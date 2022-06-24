package com.prototype.quotes.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prototype.model.QuotesData
import com.prototype.shared.room.FavouriteQuoteEntity
import com.prototype.shared.domain.FavouriteQuoteAddUseCase
import com.prototype.shared.domain.GetQuotesUseCase
import com.prototype.shared.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getQuotesUseCase: GetQuotesUseCase,
private val favouriteQuoteAddUseCase: FavouriteQuoteAddUseCase
) : ViewModel() {
    private val _data = MutableLiveData<QuotesData>()
    val data: LiveData<QuotesData> = _data

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception> = _error

    fun getData() {
        viewModelScope.launch {
            when(val response = getQuotesUseCase.getQuotesData()){
                is Result.Success ->{
                    _data.postValue(response.data)
                }
                is Result.Error ->{
                    _error.postValue(response.exception)
                }
                else -> {}
            }
        }
    }

    fun addToFavourite(content:String,author:String){
        viewModelScope.launch {
            favouriteQuoteAddUseCase.insert(FavouriteQuoteEntity(content,author) )
        }
    }
}