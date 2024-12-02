package com.example.appcicd

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testEditText_ValidateTextNome(){
        onView(withId(R.id.et_nome))
            .perform(typeText("Teste"))


        // Verificar se o texto foi digitado corretamente
        onView(withId(R.id.et_nome))
            .check(matches(withText("Teste")))
    }

}

// Nome: Se o nome é igual ou se o nome é diferente
// Altura: Se altura tem mais de 3 caracteres, se é correta, se é igual a zero, se ele converte corretamente
// Peso: se peso tem mais de 3 caracteres, oposto, se recebe letras e se é igual a zero
// Botão: deve ser ativado somente se todos os campos estiverem preenchidos, tentativa de clicar quando um campo não está preenchido.