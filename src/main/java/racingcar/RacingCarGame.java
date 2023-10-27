package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<RacingCar> racingCars;
    private RandomNumGenerator randomNumGenerator;

    public RacingCarGame(){
        racingCars = new ArrayList<>();
        randomNumGenerator = new RandomNumGenerator();
    }
}
