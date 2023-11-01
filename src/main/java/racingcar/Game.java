package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Domain.Car;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.util.stream.Collectors.toList;
import static racingcar.Logic.findMaxPosition;

public class Game {
    public static void doGame() {
        Output.printGuideCarName(); //4번 기능

        String input = readLine();
        List<String> carNames = Input.getCarNames(input); //1번 기능

        Output.printGuideTryCount(); //5번 기능

        input = readLine();
        Long tryCount = Input.getTryCount(input); //2번 기능

        Output.printResultMessage();

        List<Car> cars = createCars(carNames);
        for(Long i = 0L; i < tryCount; i++) {
            moveCars(cars); //3번 기능
            Output.printResult(cars); //6번 기능
        }

        List<Car> carsWithMaxPosition = findMaxPosition(cars); //7번 기능
        Output.printWinner(carsWithMaxPosition); //7번 기능
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(toList());
    }

    private static void moveCars(List<Car> cars) {
        for(Car car : cars) {
            car.move(Randoms.pickNumberInRange(0,9));
        }
    }


}
