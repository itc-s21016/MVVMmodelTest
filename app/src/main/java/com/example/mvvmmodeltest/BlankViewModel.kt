package com.example.mvvmmodeltest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {
    //livedataの定義
    val hogeLiveData: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    //ボタンをタップしたときに走るメソッド
    fun buttonTapped() {
        hogeLiveData.value = "Tapped!!"
    }
}