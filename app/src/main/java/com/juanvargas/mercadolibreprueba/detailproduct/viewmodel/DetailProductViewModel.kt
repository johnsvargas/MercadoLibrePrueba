package com.juanvargas.mercadolibreprueba.detailproduct.viewmodel

import androidx.lifecycle.*
import com.juanvargas.mercadolibreprueba.detailproduct.data.repository.DetailProductRepositoryImpl
import com.juanvargas.mercadolibreprueba.search.data.model.Product
import com.juanvargas.mercadolibreprueba.util.LiveDataState
import com.juanvargas.mercadolibreprueba.util.MutableLiveDataState
import com.juanvargas.mercadolibreprueba.util.StateApp
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailProductViewModel:ViewModel() {
    private val repository by lazy { DetailProductRepositoryImpl() }

    private val _product: MutableLiveDataState<Product> by lazy { MutableLiveDataState() }
    var product:LiveDataState<Product> = _product

    private val _description: MutableLiveDataState<String> by lazy { MutableLiveDataState() }
    var description:LiveDataState<String> = _description

    private val _isLanding : MutableLiveData<Boolean> by lazy{ MutableLiveData() }
    val isLanding: LiveData<Boolean> = _isLanding.distinctUntilChanged()

    fun getProductDetail(productId:String){
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler{ _, throwable ->
            _product.postValue(StateApp.Error(throwable))
            _isLanding.postValue( false)
        }){
            _isLanding.postValue(true)
            val response = repository.getItem(productId)
            if(response.isNotEmpty()){
                _product.postValue(StateApp.Success(response[0].body))
            }else{
                _product.postValue(StateApp.Error(Throwable("Error al cargar la información")))
            }
            _isLanding.postValue(false)
        }
    }

    fun getDescription(productId:String){
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler{ _, throwable ->
            _description.postValue(StateApp.Error(throwable))
            _isLanding.postValue( false)
        }){
            _isLanding.postValue(true)
            val response = repository.getItemDescription(productId)

            _description.postValue(StateApp.Success(response.plainText))

            _isLanding.postValue(false)
        }
    }
}