package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    String name;
    List<String> block = new ArrayList<>();

    public RacingCar(String name) {
        if(name.length()>5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public void move(int number){
        if (number >= 4) {
            block.add("-");
        }
    }
}
