package racingcar;

import java.util.List;

public class Game {
    public void run() {
        Input input = new Input();
        Car car = new Car();
        Validator validator = new Validator();

        String inputCarNames = input.carName();
        validator.hasSpace(inputCarNames);

        List<String> carNames = car.splitByComma(inputCarNames);
        validator.isLengthOverFive(carNames);

        String inputNumber = input.tryNumber();
        validator.isNumber(inputNumber);

        int tryNumber = Integer.parseInt(inputNumber);

        List<String> carMove = car.racingResult(carNames, tryNumber);
        List<Integer> carMoveDistance = car.countCarMove(carMove);

        car.printWinner(carNames, carMoveDistance);
    }
}
