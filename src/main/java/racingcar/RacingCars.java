package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCarList;

    public RacingCars() {
        this.racingCarList = new ArrayList<>();
    }

    public void addRacingCar(String name) {
        RacingCar car = new RacingCar(name);
        racingCarList.add(car);
    }

    public List<RacingCar> getRacingCars() {
        return racingCarList;
    }

    public void moveRacingCars() {
        for (RacingCar car : racingCarList) {
            if(Randoms.pickNumberInRange(0,9) >= 4){
                car.incrementDistance();
            }
        }
    }

}
