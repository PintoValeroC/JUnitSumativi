/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorsmp;
import java.util.Stack;
/**
 *
 * @author Djurado
 */
public class Operations {

    private static String[] op = { "+", "-", "*", "/" };// Operation set

    public static String MakeFormula(){
        System.out.println("git modify");
        StringBuilder build = new StringBuilder();
        int count = (int) (Math.random() * 2) + 1; // generate random count
        int start = 0;
        int number1 = (int) (Math.random() * 99) + 1;
        build.append(number1);
        while (start <= count){
            int operation = (int) (Math.random() * 3); // generate operator
            int number2 = (int) (Math.random() * 99) + 1;
            build.append(op[operation]).append(number2);
            start ++;
        }
        return build.toString();
    }

    public static String Solve(String formula) {
    if (formula == null || formula.isBlank()) {
        return "Error: fórmula vacía";
    }

    // Eliminar espacios para evitar errores
    formula = formula.replaceAll("\\s+", "");

    // Buscar el operador (+, -, *, /)
    int operatorPos = -1;
    char operator = 0;

    // Empieza en 1 para permitir número negativo al inicio
    for (int i = 1; i < formula.length(); i++) {
        char c = formula.charAt(i);
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            operator = c;
            operatorPos = i;
            break;
        }
    }

    if (operatorPos == -1) {
        // No hay operador, se asume número solo
        try {
            Integer.parseInt(formula);
            return formula;
        } catch (NumberFormatException e) {
            return "Error: formato numérico incorrecto";
        }
    }

    try {
        String left = formula.substring(0, operatorPos);
        String right = formula.substring(operatorPos + 1);

        int num1 = Integer.parseInt(left);
        int num2 = Integer.parseInt(right);

        switch (operator) {
            case '+':
                return String.valueOf(num1 + num2);
            case '-':
                return String.valueOf(num1 - num2);
            case '*':
                return String.valueOf(num1 * num2);
            case '/':
                if (num2 == 0) return "Error: división por cero";
                return String.valueOf(num1 / num2);
            default:
                return "Error: operador desconocido";
        }
    } catch (NumberFormatException e) {
        return "Error: formato numérico incorrecto";
    }
}

}

