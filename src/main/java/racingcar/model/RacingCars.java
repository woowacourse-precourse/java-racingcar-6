package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> racingCars;

    public RacingCars() {
        this.racingCars = new ArrayList<>();
    }


    public void addCars(String[] carNames) {
        for(String name: carNames){
            racingCars.add(new Car(name));
        }
    }


    public void move() {

        for (Car car : racingCars) {
            car.move(createRandomNumber());
        }

    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


    public List<String> getCarNames(){

        List<String> carNames = new ArrayList<>();

        for(Car car: racingCars){
            carNames.add(car.getName());
        }
        return carNames;
    }

    public List<Integer> getCarLocations(){
        List<Integer> carLocations = new ArrayList<>();

        for(Car car: racingCars){
            carLocations.add(car.getLocation());
        }
        return carLocations;
    }


    public List<String> getWinners(){
        Integer maxLocationValue = getLocationMaxValue();

        List<String> winners = racingCars.stream()
                .filter(car->car.getLocation()==maxLocationValue)
                .map(car -> car.getName()).collect(Collectors.toList());

        return winners;
    }

    private Integer getLocationMaxValue(){
        return Collections.max(getCarLocations());
    }

}
