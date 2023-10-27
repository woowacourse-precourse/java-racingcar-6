package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car.Car;
import racingcar.Model.CarRepository;
import racingcar.View.RaceView;

public class RaceControllerIntegerVer implements RaceController {

    private static final int MOVE_CRITERIA = 4;
    private static final int MOVE_START_RANGE = 0;
    private static final int MOVE_END_RANGE = 9;
    private static RaceView raceView;


    @Override
    public void processRace(String input, CarRepository carRepository){
        int round = Integer.parseInt(input);
        Car car = carRepository.getCar(123);

        int randomNumber = pickRandomNumber();
        boolean canMove = randomNumber > MOVE_CRITERIA;
        car.move(randomNumber, canMove);

        raceView.print(car, randomNumber);
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(MOVE_START_RANGE, MOVE_END_RANGE);
    }

    private void validateRoundNumber(String input){
        Integer.parseInt(input);
    }

    @Override
    public void validateRoundInput(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
