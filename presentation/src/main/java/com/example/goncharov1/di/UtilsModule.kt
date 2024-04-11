package com.example.goncharov1.di

import com.example.goncharov1.utils.ResourcesManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class UtilsModule {

    @Binds
    abstract fun bindResourcesManager(
        resourcesManagerImpl: ResourcesManager.ResourcesManagerImpl,
    ): ResourcesManager
}