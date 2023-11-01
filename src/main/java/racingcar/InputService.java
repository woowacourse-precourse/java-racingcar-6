package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    private static final String POSSIBLE_TRY_COUNT_REGEX = "^[1-9][0-9]*$";
    
    private String carNames;
    private String tryCount;
    
    public String getCarNames() {
        inputCarNames();
        return carNames;
    }
    
    public int getTryCount() {
        inputTryCount();
        return Integer.parseInt(tryCount);
    }
    
    private void inputCarNames() {
        carNames = getUserInput();
    }
    
    private String getUserInput() {
        return Console.readLine();
    }
    
    private void inputTryCount() {
        String userInput = getUserInput();
        if (!isValidTryCount(userInput)) {
            throw new IllegalArgumentException("TryCount is not valid.");
        }
        tryCount = userInput;
    }
    
    private boolean isValidTryCount(String userInput) {
        return userInput != null && isNumber(userInput);
    }
    
    private boolean isNumber(String userInput) {
        return userInput.matches(POSSIBLE_TRY_COUNT_REGEX);
    }
}
