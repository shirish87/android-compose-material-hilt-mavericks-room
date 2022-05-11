package com.dotslashlabs.demo

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.dotslashlabs.demo.data.DemoDatabase
import com.dotslashlabs.demo.module.DatabaseModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class],
)
@Module
object FakeDatabaseModule {
    @Provides
    fun provideBookDao(database: DemoDatabase) = database.bookDao()

    @Provides
    @Singleton
    fun provideDatabase(): DemoDatabase {
        val context: Context = ApplicationProvider.getApplicationContext()
        return Room.inMemoryDatabaseBuilder(context, DemoDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }
}
