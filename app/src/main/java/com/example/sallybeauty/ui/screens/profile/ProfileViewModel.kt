package com.example.sallybeauty.ui.screens.profile

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sallybeauty.common.ScreenState
import com.example.sallybeauty.domain.entity.user.UserInformationEntity
import com.example.sallybeauty.domain.mapper.ProductBaseMapper
import com.example.sallybeauty.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCase
import com.sallyBeauty.ecommerce_compose.ui.uiData.UserInformationUiData
import com.example.sallybeauty.utils.getUserIdFromSharedPref
//import com.sallyBeauty.ecommerce_compose.ui.uiData.UserInformationUiData
//import com.example.sallybeauty.utils.getUserIdFromSharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val readFirebaseUserInfosUseCase: ReadFirebaseUserInfosUseCase,
    private val sharedPreferences: SharedPreferences,
    private val firebaseUserInfoToUiData: ProductBaseMapper<UserInformationEntity, UserInformationUiData>,
) : ViewModel() {
    private val _userInfos = MutableLiveData<ScreenState<UserInformationUiData>>()
    val userInfos: LiveData<ScreenState<UserInformationUiData>> get() = _userInfos

    init {
        getUserInfosFromFirebase()
    }

    private fun getUserInfosFromFirebase() {
        _userInfos.value = ScreenState.Loading
        viewModelScope.launch {
            readFirebaseUserInfosUseCase.invoke(
                getUserIdFromSharedPref(sharedPreferences),
                onSuccess = {
                    _userInfos.postValue(ScreenState.Success(firebaseUserInfoToUiData.map(it)))
                },
            ) {
                _userInfos.postValue(ScreenState.Error(it))
            }
        }
    }
}
