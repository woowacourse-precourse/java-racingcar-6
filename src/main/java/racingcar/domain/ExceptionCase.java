package racingcar.domain;

import java.util.List;

public class ExceptionCase {

    public void carNameLength(List<String> racers) {
        racers.forEach((a)-> {
            if(a.length()> 5) {
                throw new IllegalArgumentException();
            }
        });
    }

    public void nullInput(String input) {
        if (input == null || input == "") {
            throw new IllegalArgumentException();
        }
    }
}
