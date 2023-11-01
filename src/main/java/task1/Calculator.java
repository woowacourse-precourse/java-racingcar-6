package task1;

public class Calculator {
    double temp = 0;
    int operand = 0;
    String operator = "";

    public double getResult(String[] tokens) {
        for (int i=0; i<tokens.length; i++) {
            String token = tokens[i];
            decideNextOperation(i, token);
        }
        return temp;
    }

    public void decideNextOperation(int i, String token) {
        if (i == 0) {
            temp = Integer.parseInt(token);
            return;
        }
        if (i % 2 == 0) {
            operand = Integer.parseInt(token);
            temp = calculate(temp, operator, operand);
        }
        if (i % 2 != 0) {
            operator = token;
        }
    }

    public double calculate(double temp, String operator, int operand) {
        double result = 0;
        if (operator.equals("+")) result = temp + operand;
        if (operator.equals("-")) result = temp - operand;
        if (operator.equals("*")) result = temp * operand;
        if (operator.equals("/")) result = temp / operand;
        return result;
    }
}