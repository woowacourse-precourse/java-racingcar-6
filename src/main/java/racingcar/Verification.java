package racingcar;

import java.util.List;

public class Verification {
    public void verifyArg(List<String> strings){
        for (String string : strings) {
            if (string.length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }

    public void verifyNumberOfTry(String number){
        if (Integer.valueOf(number) < 0) {
            throw new IllegalArgumentException();
        } else if (!number.matches(number)) {
            throw new IllegalArgumentException();
        }
    }
}
