package racingcar.domain;

import static racingcar.Application.playRound;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private List<Car> cars;

    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNames = Console.readLine();
        createCars(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        final int playTimes = Integer.parseInt(Console.readLine());
        playRound(cars, playTimes);

        Console.close();
    }

    private void createCars(final String carNames) {
        final List<String> members = Arrays.asList(carNames.split(","));
        this.cars = members.stream()
                .map(Car::new)
                .toList();
    }
}
