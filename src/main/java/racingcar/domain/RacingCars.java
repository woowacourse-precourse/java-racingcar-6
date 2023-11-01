package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<Car> racingCars;

    public RacingCars(String carNames) {
       initRacingCars(carNames);
    }
    public void initRacingCars(String carNames){
        String[] carNameIndexs = carNames.split(",");
        racingCars = new ArrayList<>();

        for(String car : carNameIndexs){
            racingCars.add(new Car(car));
        }
    }
    public void movingRacingCars(){
        for (Car car : racingCars) {
            int moveNum = Randoms.pickNumberInRange(0, 9);
            car.moveCar(moveNum);
        }
    }
    public Car[] getCars() {
        return racingCars.toArray(new Car[0]);
    }
}
