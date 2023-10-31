package racingcar;

import java.util.List;

public class Game {
    public void run() {
        Input input = new Input();
        Car car = new Car();
        Validator validator = new Validator();

        String inputCarNames = input.carName();
        validator.isEmpty(inputCarNames);
        validator.hasSpace(inputCarNames);

        List<String> carNames = car.splitByComma(inputCarNames);
        validator.isLengthZeroOrOverFive(carNames);
        validator.hasSameCarName(carNames);

        String inputNumber = input.tryNumber();
        int tryNumber = validator.toNumber(inputNumber);
        validator.isNumberOneToThousand(tryNumber);

        List<String> carMove = car.racingResult(carNames, tryNumber);
        List<Integer> carMoveDistance = car.countCarMove(carMove);

        car.printWinner(carNames, carMoveDistance);
    }
}
