package racingcar.model;

import java.util.Comparator;
import java.util.List;

public class RacingModel {

    private final List<Car> racingCars;

    public RacingModel(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    private void moveCar(){
        racingCars.forEach(Car::move);
    }

    public List<String> getWinner(){
        int max = racingCars.stream().max(Comparator.comparingInt(Car::getPosition)).get().getPosition();
        return racingCars.stream().filter(car -> car.getPosition() == max).map(Car::getName).toList();
    }

    public List<Car> playRound() {
        moveCar();
        return racingCars;
    }
}
