package racingcar.validation;
import java.util.regex.Matcher;
public class InputValidation {
    public boolean checkPlayerInput(String playerInput){
        String pattern = "^(\s*[^,]+,)*\s*[^,]+$";
        return playerInput.matches(pattern);
    }
}
