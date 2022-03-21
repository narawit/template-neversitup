package com.kaguu.core.utils.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NetworkMonitor(private val context: Context) {
    fun startNetworkCallback() {
        val cm: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val builder: NetworkRequest.Builder = NetworkRequest.Builder()

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            cm.registerDefaultNetworkCallback(networkCallback)
        } else {
            cm.registerNetworkCallback(builder.build(), networkCallback)
        }
    }

    fun stopNetworkCallback() {
        val cm: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        cm.unregisterNetworkCallback(ConnectivityManager.NetworkCallback())
    }

    private val isNetworkConnected: MutableLiveData<Boolean> = MutableLiveData()

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network) {
            isNetworkConnected.postValue(true)
        }

        override fun onLost(network: Network) {
            isNetworkConnected.postValue(false)
        }
    }

    fun isNetworkConnected() = isNetworkConnected.value ?: false

    fun getNetworkMonitor(): LiveData<Boolean> = isNetworkConnected
}