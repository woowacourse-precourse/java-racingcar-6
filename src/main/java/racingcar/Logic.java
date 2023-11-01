package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Domain.Car;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Logic {
    private static final Input input = new Input();
    private static final Output output = new Output();

    public static void doGame() {
        Output.printGuideCarName(); //4번 기능

        List<String> carNames = Input.getCarNames(); //1번 기능

        Output.printGuideTryCount(); //5번 기능

        Long tryCount = Input.getTryCount(); //2번 기능

        Output.printResultMessage();

        for(Long i = 0L; i < tryCount; i++) {
            List<Car> cars = createCars(carNames);
            moveCars(cars); //3번 기능
            Output.printResult(cars); //6번 기능
        }
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
