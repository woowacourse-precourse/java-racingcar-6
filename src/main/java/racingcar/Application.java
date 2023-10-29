package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Car car = new Car();
        Validator validator = new Validator();

        String inputCarNames = input.carName();
        validator.hasSpace(inputCarNames);

        List<String> carNames = car.splitByComma(inputCarNames);
        /*System.out.println(inputCarNames);
        System.out.println(carNames);*/

        String inputNumber = input.tryNumber();
        validator.isNumber(inputNumber);

        int tryNumber = Integer.parseInt(inputNumber);

        List<Integer> carMoveDistance = car.nowRacing(carNames, tryNumber);

        String winner = car.printWinner(carNames, carMoveDistance);
        System.out.println(winner);
    }
}
