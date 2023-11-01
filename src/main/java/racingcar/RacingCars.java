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

    public List<RacingCar> findCarsWithMaxDistance() {
        if (racingCarList.isEmpty()) {
            return new ArrayList<>();
        }

        RacingCar maxDistanceCar = racingCarList.get(0);
        List<RacingCar> carsWithMaxDistance = new ArrayList<>();

        for (RacingCar car : racingCarList) {
            if (car.getDistance() > maxDistanceCar.getDistance()) {
                maxDistanceCar = car;
                carsWithMaxDistance.clear();
                carsWithMaxDistance.add(car);
            } else if (car.getDistance() == maxDistanceCar.getDistance()) {
                carsWithMaxDistance.add(car);
            }
        }

        return carsWithMaxDistance;
    }
}
