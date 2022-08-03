package com.prototype.quotes.ui.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prototype.shared.domain.FavouriteQuoteDeleteUseCase
import com.prototype.shared.domain.GetFavouriteQuotesUseCase
import com.prototype.shared.room.FavouriteQuoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val favouriteQuoteDeleteUseCase: FavouriteQuoteDeleteUseCase,
    private val getFavouriteQuotesUseCase: GetFavouriteQuotesUseCase
) : ViewModel() {

    private val _data = MutableLiveData<List<FavouriteQuoteEntity>>()
    val data: LiveData<List<FavouriteQuoteEntity>> = _data

    fun getFavouriteQuotes() {
        viewModelScope.launch {
            _data.value = getFavouriteQuotesUseCase.getFavQuotes()
        }
    }

    fun deleteFormFavourite(content: String, author: String) {
        viewModelScope.launch {
            favouriteQuoteDeleteUseCase.delete(FavouriteQuoteEntity(content, author))
        }
    }
}