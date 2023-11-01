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
    private final static String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ASK_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String DELIMITER = ",";

    public static void main(String[] args) {
        List<String> carNames = askCarNames();
        Integer round = askRound();

        List<Car> cars = CarFactory.makeCar(carNames);
        Race race = new Race(cars, round);
        race.run();
    }

    public static List<String> askCarNames() {
        System.out.println(ASK_CAR_NAME_MESSAGE);
        return Arrays.stream(readLine().split(DELIMITER))
                .map(Validate::isValidCarName)
                .toList();
    }

    public static Integer askRound() {
        System.out.println(ASK_ROUND_MESSAGE);
        return Integer.parseInt(isValidAttemptNumber(readLine()));
    }
}
