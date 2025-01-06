package com.example.appcicd

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class UiTests {

    // Regra que inicia a MainActivity antes dos testes
    @Rule
    @JvmField
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testEditTextAndButtonClick() {
        // Digita "nome" no campo de texto com ID et_nome
        onView(withId(R.id.et_nome)).perform(typeText("nome"))

        // Verifica se o botão com ID btn_apply_name está habilitado e visível
        onView(withId(R.id.btn_apply_name))
            .check(matches(isDisplayed()))
            .check(matches(isEnabled()))

        // Clica no botão
        onView(withId(R.id.btn_apply_name)).perform(click())
    }
}