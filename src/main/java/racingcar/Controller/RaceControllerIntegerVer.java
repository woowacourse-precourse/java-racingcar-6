package racingcar.Controller;

import racingcar.Model.Car.Car;
import racingcar.Model.CarRepository;
import racingcar.View.RaceView;

public class RaceControllerIntegerRange implements RaceController {

    RaceView raceView;

    @Override
    public void process(String round, CarRepository carRepository){
        validateRoundNumber(round);
        Car car = carRepository.getCar(123);
        int randomNumber = pickRandomNumber();
        randomNumberIsOverCriteria(randomNumber);

        car.move(randomNumber);
        raceView.print(car, randomNumber);

    }

    private boolean randomNumberIsOverCriteria(int randomNumber) {
    }

    private int pickRandomNumber() {
    }

    private void validateRoundNumber(String input){

    }
}
