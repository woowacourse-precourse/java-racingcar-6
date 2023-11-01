package task1;

public class ErrorChecker {
    String errorMsg = "[ERROR] ";

    public boolean checkTokens (String[] tokens) {
        for (int i=0; i<tokens.length; i++) {
            String token = tokens[i];
            if(!checkToken(i, token)) {
                System.out.println(errorMsg);
                return false;
            }
        }
        return true;
    }

    public boolean checkToken (int i, String token) {
        boolean result = false;
        if (i % 2 == 0) {
            result = isPositiveInt(token);
        }
        if (i % 2 != 0) {
            result = isOperator(token);
        }
        return result;
    }

    public boolean isOperator (String token) {
        boolean result = (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) ? true : false;
        if (!result) {
            errorMsg += "잘못된 연산자를 사용하셨습니다";
        }
        return result;
    }

    public boolean isPositiveInt (String token) {
        boolean result = false;
        int num = 0;
        try {
            num = Integer.parseInt(token);
        } catch(NumberFormatException e) {
            result = false;
        }
        if (num > 0) {
            result = true;
        }
        if (!result) {
            errorMsg += "잘못된 피연산자를 사용하셨습니다";
        }
        return result;
    }
}