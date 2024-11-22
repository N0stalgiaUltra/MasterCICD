package com.example.appcicd

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private fun imcCalc(altura: Float, peso: Float) : String{
//        altura = 1.75f
//        peso = 70f
        val imc = peso / (altura * altura)

        return when{
            imc < 18.5f -> "Abaixo do peso"
            imc in 18.5f..24.9f -> "Peso normal"
            imc in 25.0f..29.9f -> "Sobrepeso"
            imc >= 30.0 -> "Obesidade"
            else -> "Valor de IMC invalido"
        }
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `deve retornar abaixo do peso quando o IMC for menor que 18,5`(){
        assertEquals("Abaixo do peso", imcCalc(1.80f, 20f))
    }
    @Test
    fun `deve retornar peso normal`(){
        assertEquals("Peso normal", imcCalc(1.80f, 80f))
    }@Test
    fun `deve retornar sobrepeso`(){
        assertEquals("Sobrepeso", imcCalc(1.80f, 90f))
    }@Test
    fun `deve retornar obesidade`(){
        assertEquals("Obesidade", imcCalc(1.80f, 100f))

    }@Test
    fun `deve retornar valor invalido`(){
        assertEquals("Valor de IMC invalido", imcCalc(0f, 0f))

    }
}