package com.atilsamancioglu.cryptocrazycompose.repository

import com.atilsamancioglu.cryptocrazycompose.model.Crypto
import com.atilsamancioglu.cryptocrazycompose.model.CryptoList
import com.atilsamancioglu.cryptocrazycompose.service.CryptoAPI
import com.atilsamancioglu.cryptocrazycompose.util.Constants.API_KEY
import com.atilsamancioglu.cryptocrazycompose.util.Constants.CALL_ATTRIBUTES
import com.atilsamancioglu.cryptocrazycompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository@Inject constructor(
    private val api: CryptoAPI
) {

    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList(API_KEY)
        } catch(e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto(API_KEY,id,CALL_ATTRIBUTES)
        } catch(e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }
}