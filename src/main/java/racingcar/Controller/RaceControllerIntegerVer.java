package racingcar.Controller;

import racingcar.Model.Car.Car;
import racingcar.Model.CarRepository;
import racingcar.View.RaceView;

public class RaceControllerIntegerVer implements RaceController {

    RaceView raceView;

    @Override
    public void processRace(String round, CarRepository carRepository){
        validateRoundNumber(round);
        Car car = carRepository.getCar(123);
        int randomNumber = pickRandomNumber();
        randomNumberIsOverCriteria(randomNumber);

        car.move(randomNumber);
        raceView.print(car, randomNumber);
    }

    private boolean randomNumberIsOverCriteria(int randomNumber) {
        return false;
    }

    private int pickRandomNumber() {
        return 0;
    }

    private void validateRoundNumber(String input){

    }
}
