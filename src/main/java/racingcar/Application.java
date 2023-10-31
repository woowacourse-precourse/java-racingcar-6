package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Race;
import racingcar.util.Validate;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.Validate.isValidAttemptNumber;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = askCarNames();
        Integer attemptNumber = askAttemptNumber();

        List<Car> cars = CarFactory.makeCar(carNames);
        Race race = new Race(cars, attemptNumber);
        race.run();
    }

    public static List<String> askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(readLine().split(","))
                .map(Validate::isValidCarName)
                .toList();
    }

    public static Integer askAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(isValidAttemptNumber(readLine()));
    }
}
