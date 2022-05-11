package com.dotslashlabs.demo.module

import android.content.Context
import com.dotslashlabs.demo.data.DemoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideBookDao(database: DemoDatabase) = database.bookDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = DemoDatabase.instance(context)
}
