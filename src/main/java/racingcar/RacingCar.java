package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    String name;
    List<String> block = new ArrayList<>();

    public RacingCar(String name) {
        this.name = name;
    }

    public void move(int number){
        if (number >= 4) {
            block.add("-");
        }
    }
}
