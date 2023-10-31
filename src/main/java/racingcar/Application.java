package racingcar;

import Car.CarGenerator;
import Car.Car;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        List<Car> carList = CarGenerator.generateCar(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String userInputRepeatCount = Console.readLine();
        Validator.validateRepeatCount(userInputRepeatCount);
        int repeatCount = Integer.parseInt(userInputRepeatCount);

        for (int i = 0; i < repeatCount; i++) {
            for (Car car : carList) {
                car.moveForward();
                car.printCurrentLocation();
            }
            System.out.println();
        }

        RacingGame.printWinner(carList);
    }
}
