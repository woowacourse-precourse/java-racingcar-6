package racingcar.validator;

public class TriesCountValidator {
    public int validateAndGetTriesCount(String userInput) {
        userInput = removeWhiteSpace(userInput);
        validateNotEmpty(userInput);
        int triesCount = parseValidInteger(userInput);
        validatePositive(triesCount);
        return triesCount;
    }

    private void validateNotEmpty(String userInput){
        if(userInput.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private int parseValidInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositive(int number){
        if(number<=0){
            throw new IllegalArgumentException();
        }
    }

    private String removeWhiteSpace(String userInput) {
        userInput = userInput.replace(" ","");
        return userInput;
    }
}
