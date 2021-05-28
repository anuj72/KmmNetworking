package com.example.mytestkmm.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mytestkmm.SampleApiClient
import com.example.mytestkmm.dto.RootResponse

class MainViewModel : ViewModel() {

    private val sampleApiClient: SampleApiClient = lazy { SampleApiClient() }.value

    val users: LiveData<RootResponse> = liveData {
        emit(sampleApiClient.getUsers())
    }
}