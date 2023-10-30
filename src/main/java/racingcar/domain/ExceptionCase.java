package racingcar.domain;

import java.util.List;

public class ExceptionCase {

    public void carNameLength(List<String> racers) {
        racers.forEach((a)-> {
            if(a.length()> 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        });
    }

    public void nullStringInput(String input) {
        if (input == null || input == "") {
            throw new IllegalArgumentException();
        }
    }
}
