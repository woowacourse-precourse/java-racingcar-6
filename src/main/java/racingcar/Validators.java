package racingcar;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Validators {
    public boolean isCarNameOverFive (ArrayList<String> cars) {
        return false;
    }

    public boolean isInteger(String inputString) {
        Pattern pattern = Pattern.compile("^\\d+$");

        return pattern.matcher(inputString).matches();
    }
}



