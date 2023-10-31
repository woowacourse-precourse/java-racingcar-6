package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class InputCarName {
    public static List<Car> getInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();

        String[] carNamesArray = carNames.split(",");
        validateCarNamesArray(carNamesArray);

        return Car.createCars(carNamesArray);
    }

    private static void validateCarNamesArray(String[] carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException("잘못된 자동차 이름 입력입니다.");
            }
        }
    }

}
