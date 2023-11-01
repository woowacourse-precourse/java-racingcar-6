package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static List<String> readCarNameList() {
        List<String> carNames;

        System.out.println("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = Arrays.stream(Console.readLine().replaceAll(" ", "").split(",")).toList();

        return carNames;
    }

    public static int readTryCount() {
        System.out.println("시도할 회수");

        return validateTryCount(Console.readLine().trim());
    }

    public static List<RacingCar> registerRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>(Collections.emptyList());

        for (String name : carNames) {
            validateCarName(name);
            racingCars.add(new RacingCar(name, 0));
        }

        return racingCars;
    }

    public static void validateCarName(String name) {
        String pattern = "[a-zA-Z0-9]*";

        if (name.length() > 5 || name.isEmpty() || !name.matches(pattern)) {
            throw new IllegalArgumentException();
        }
    }

    public static int validateTryCount(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        List<String> carNames = readCarNameList();
        List<RacingCar> racingCars = registerRacingCars(carNames);
        int tryCount = readTryCount();
    }
}
