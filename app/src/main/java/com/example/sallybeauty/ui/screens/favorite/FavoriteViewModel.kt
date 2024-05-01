package com.sallyBeautyecommerce_compose.ui.screens.favorite

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.common.ScreenState
import com.example.sallybeauty.domain.entity.product.FavoriteProductEntity
import com.example.sallybeauty.domain.mapper.ProductBaseMapper
import com.example.sallybeauty.domain.mapper.ProductListMapper
import com.example.sallybeauty.domain.usecase.favorite.DeleteFavoriteUseCase
import com.example.sallybeauty.domain.usecase.favorite.FavoriteUseCase
import com.sallyBeauty.ecommerce_compose.ui.uiData.FavoriteUiData
import com.example.sallybeauty.utils.getUserIdFromSharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteUseCase: FavoriteUseCase,
    private val mapper: ProductListMapper<FavoriteProductEntity, FavoriteUiData>,
    private val singleMapper: ProductBaseMapper<FavoriteUiData, FavoriteProductEntity>,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    private val _favoriteCarts = MutableLiveData<ScreenState<List<FavoriteUiData>>>()
    val favoriteCarts: LiveData<ScreenState<List<FavoriteUiData>>> get() = _favoriteCarts

    init {
        getFavoriteProducts()
    }

    private fun getFavoriteProducts() {
        viewModelScope.launch {
            favoriteUseCase.invoke(getUserIdFromSharedPref(sharedPreferences)).collect {
                when (it) {
                    is NetworkResponseState.Error -> _favoriteCarts.postValue(
                        ScreenState.Error(
                            it.exception.message!!,
                        ),
                    )

                    is NetworkResponseState.Loading -> _favoriteCarts.postValue(ScreenState.Loading)
                    is NetworkResponseState.Success -> _favoriteCarts.postValue(
                        ScreenState.Success(
                            mapper.map(it.result),
                        ),
                    )
                }
            }
        }
    }

    fun deleteFavoriteItem(favoriteUiData: FavoriteUiData) {
        viewModelScope.launch {
            deleteFavoriteUseCase(singleMapper.map(favoriteUiData))
            getFavoriteProducts()
        }
    }
}
