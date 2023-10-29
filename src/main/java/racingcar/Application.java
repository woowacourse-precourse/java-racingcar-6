package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        play();
    }

    private static void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNames = Console.readLine();
        List<String> members = Arrays.asList(carNames.split(","));
        List<Car> cars = members.stream()
                .map(Car::new)
                .toList();
    }
}
