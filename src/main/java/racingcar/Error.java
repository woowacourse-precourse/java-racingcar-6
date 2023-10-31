package racingcar;

public class Error {
    static void isNameError(String userInput){
        if (userInput.isEmpty())
            throw new IllegalArgumentException("Empty Error is occurred" + userInput);
        if (userInput.length() > 5)
            throw new IllegalArgumentException("Invalid Length: " + userInput.length());
    }
    static void isDigitError(String userInput){
        for (int i = 0; i < userInput.length(); i++){
            char word = userInput.charAt(i);
            if (!Character.isDigit(word))
                throw new IllegalArgumentException("Invalid word: " + userInput);
        }
        int userNumber = Integer.parseInt(userInput);
        if (userNumber < 0)
            throw new IllegalArgumentException("Invalid Digit Range: " + userInput);
    }
}
