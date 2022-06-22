package com.teste.excoroutinesdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {

    private var repository = MyRepository()

    private var _string = MutableLiveData<String>()
    val string: LiveData<String> = _string


    fun getDataRepository(){
        viewModelScope.launch(Dispatchers.IO){
            repository.getData().collect {
                _string.postValue(it)
            }
        }
    }

}