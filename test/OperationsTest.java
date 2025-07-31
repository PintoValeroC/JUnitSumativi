package com.mycompany.junitsumativo;

import calculatorsmp.Operations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {

    @Test
    @DisplayName("MakeFormula debe devolver una fórmula no vacía")
    public void testMakeFormula() {
        String result = Operations.MakeFormula();
        assertNotNull(result);
        assertFalse(result.isBlank(), "La fórmula generada no debe estar vacía.");
    }

    @Test
    @DisplayName("Solve debe resolver fórmulas correctamente (ej: 2+3=5)")
    public void testSolveSimpleSum() {
        String formula = "2+3";
        String result = Operations.Solve(formula);
        assertEquals("5", result);
    }

    @Test
    @DisplayName("Solve con división por cero debe lanzar excepción o mensaje de error")
    public void testSolveDivideByZero() {
        String formula = "5/0";
        String result = Operations.Solve(formula);
        assertTrue(result.toLowerCase().contains("error") || result.contains("∞") || result.contains("undefined"));
    }
    @Test
    @DisplayName("Solve con números negativos: -2+5=3")
    public void testSolveWithNegativeNumbers() {
        String formula = "-2+5";
        String result = Operations.Solve(formula);
        assertEquals("3", result);
    }
    @Test
    @DisplayName("Solve con multiplicación: 4*5=20")
    public void testSolveMultiplication() {
        String formula = "4*5";
        String result = Operations.Solve(formula);
        assertEquals("20", result);
    }
    @Test
    @DisplayName("Solve ignora espacios: ' 2 + 3 ' = 5")
    public void testSolveWithSpaces() {
        String formula = " 2 + 3 ";
        String result = Operations.Solve(formula);
        assertEquals("5", result);
    }
    @Test
    @DisplayName("Solve con entrada vacía devuelve error o vacío")
    public void testSolveEmptyInput() {
        String formula = "";
        String result = Operations.Solve(formula);
        assertTrue(result.isBlank() || result.toLowerCase().contains("error"));
}

}