package com.beardness.taggallery.di

import android.content.Context
import com.beardness.taggallery.domain.core.ImageLabelerCore
import com.beardness.taggallery.domain.core.ImageLoaderCore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideImageLabelerCore(
        @ApplicationContext context: Context,
    ): ImageLabelerCore =
        ImageLabelerCore(
            context = context,
        )

    @Provides
    @Singleton
    fun provideImageLoaderCore(
        @ApplicationContext context: Context,
    ): ImageLoaderCore =
        ImageLoaderCore(
            context = context,
        )

}