package com.nastech.bridge

import android.app.Application
import com.nastech.bridge.auth.PairingManager
import com.nastech.bridge.client.RelayClient
import com.nastech.bridge.model.DeviceCapabilities
import com.nastech.bridge.power.WakeLockManager
import com.nastech.bridge.server.NasTechServer

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
