package com.nastech.android

import android.app.Application
import com.nastech.android.auth.PairingManager
import com.nastech.android.client.RelayClient
import com.nastech.android.model.DeviceCapabilities
import com.nastech.android.power.WakeLockManager
import com.nastech.android.server.NasTechServer

class NasTechApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        PairingManager.init(applicationContext)
        DeviceCapabilities.init(applicationContext)
        WakeLockManager.init(applicationContext)
        NasTechServer.start(port = 8765)

        // Initialize relay client and auto-connect if previously configured
        RelayClient.init(applicationContext)
        RelayClient.autoConnect()
    }
}
