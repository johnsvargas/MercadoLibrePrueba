package com.juanvargas.mercadolibreprueba.search.viewmodel

import androidx.lifecycle.*
import com.juanvargas.mercadolibreprueba.search.data.model.Product
import com.juanvargas.mercadolibreprueba.search.data.repository.SearchRepositoryImpl
import com.juanvargas.mercadolibreprueba.util.LiveDataState
import com.juanvargas.mercadolibreprueba.util.MutableLiveDataState
import com.juanvargas.mercadolibreprueba.util.StateApp
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel:ViewModel() {
    private val repository by lazy { SearchRepositoryImpl() }

    private val _listProducts: MutableLiveDataState<ArrayList<Product>> by lazy { MutableLiveDataState() }
    val listProducts:LiveDataState<ArrayList<Product>> = _listProducts

    private val _isLanding : MutableLiveData<Boolean> by lazy{ MutableLiveData() }
    val isLanding: LiveData<Boolean> = _isLanding.distinctUntilChanged()

    fun getProductList(query:String){
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler{ _, throwable ->
            _listProducts.postValue(StateApp.Error(throwable))
            _isLanding.postValue( false)
        }){
            _isLanding.postValue(true)
            val response = repository.searchItem(query)
            _listProducts.postValue(StateApp.Success(response.results))
            _isLanding.postValue(false)
        }
    }

}