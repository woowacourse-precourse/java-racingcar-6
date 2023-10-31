package racingcar;

import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = parseCarNames();
        List<RacingCar> cars = createCars(carNames);
    }

    private static List<String> parseCarNames() {
        return Arrays.stream(readLine().split(",")).toList();
    }

    private static List<RacingCar> createCars(List<String> carNames) {
        return carNames.stream().map(RacingCar::new).toList();
    }
}
