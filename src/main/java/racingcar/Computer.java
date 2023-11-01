package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final String PROMPT_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)";
    public static final String ATTEMPT_COUNT_PROMPT = "시도할 회수는 몇회인가요?";

    Validator validator = new Validator();

    public String getInputCarNames() {
        System.out.println(PROMPT_FOR_CAR_NAMES);
        String cars = Console.readLine();
        validator.isValidCarNames(cars);
        validator.isValidLength(cars);
        return cars;
    }

    public int getInputRaceCount() {
        System.out.println(ATTEMPT_COUNT_PROMPT);
        String raceCount = Console.readLine();
        validator.isValidNumber(raceCount);
        return Integer.parseInt(raceCount);
    }

    public List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> carsList = new ArrayList<>();
        for (String name : names) {
            carsList.add(new Car(name));
        }
        return carsList;
    }
}
