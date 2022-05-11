package com.dotslashlabs.demo

import com.airbnb.mvrx.test.MvRxTestRule
import dagger.hilt.android.testing.HiltAndroidRule
import org.junit.Before
import org.junit.Rule

abstract class BaseTest {

    @get:Rule(order = 0)
    val hiltRule by lazy { HiltAndroidRule(this) }

    @get:Rule(order = 1)
    val mvrxRule = MvRxTestRule()

    @Before
    fun init() {
        hiltRule.inject()
    }
}
