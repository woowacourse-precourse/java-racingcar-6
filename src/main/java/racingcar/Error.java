package racingcar;

public class Error {
    static void isEmptyError(String userInput) {
        if (userInput.isEmpty())
            throw new IllegalArgumentException("Empty Error is occurred");
    }
    static void isLengthError(String userInput){
        if (userInput.length() > 5)
            throw new IllegalArgumentException("Invalid Length: " + userInput.length());
        isEmptyError(userInput);
    }
    static void isDigitError(String userInput){
        int userNumber;

        if (userInput.isEmpty())
            throw new IllegalArgumentException("Empty Error is occurred");
        for (int i = 0; i < userInput.length(); i++){
            char digit = userInput.charAt(i);
            if (!Character.isDigit(digit))
                throw new IllegalArgumentException("Invalid digit: " + digit);
        }
        userNumber = Integer.parseInt(userInput);
        if (userNumber < 0)
            throw new IllegalArgumentException("Invalid Digit Range: " + userInput);
    }
}
