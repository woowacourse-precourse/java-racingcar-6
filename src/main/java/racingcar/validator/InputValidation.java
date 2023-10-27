package racingcar.validator;

public class InputValidation {
    public boolean checkPlayerInput(String playerInput){
        String pattern = "^(\s*[^,]+,)*\s*[^,]+$";
        return playerInput.matches(pattern);
    }
}
