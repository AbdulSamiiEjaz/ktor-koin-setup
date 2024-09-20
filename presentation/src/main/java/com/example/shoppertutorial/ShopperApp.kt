package com.example.shoppertutorial

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.shoppertutorial.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// Add this class reference in AndroidManifest.xml
class ShopperApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ShopperApp)
            modules(listOf(
                presentationModule,
                dataModule,
                domainModule
            ))
        }
    }
}