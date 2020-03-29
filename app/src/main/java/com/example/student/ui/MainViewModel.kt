package com.example.student.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.student.Repo
import com.example.student.services.dto.ApiDto

class MainViewModel: ViewModel() {

    private val repo = Repo()
    private val mLiveData = MutableLiveData<ApiDto>()

    fun coinData(): MutableLiveData<ApiDto> {

        repo.getBitCoinFromApi().observeForever {
           mLiveData.value = it
        }
        return mLiveData
    }

}