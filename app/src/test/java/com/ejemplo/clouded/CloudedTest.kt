package com.ejemplo.clouded

import org.junit.Assert.assertEquals
import org.junit.Test

class CloudedTest {

    @Test
    fun calcularTotalProducto_esCorrecto() {
        // Arrange: datos de prueba
        val precio = 15000
        val cantidad = 3

        // Act: lógica a evaluar
        val total = precio * cantidad

        // Assert: validación
        assertEquals(45000, total)
    }
}
