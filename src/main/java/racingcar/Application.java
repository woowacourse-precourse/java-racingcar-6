package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
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
        final List<String> members = Arrays.asList(carNames.split(","));
        final List<Car> cars = members.stream()
                .map(Car::new)
                .toList();

        System.out.println("시도할 회수는 몇회인가요?");
        final int playTimes = Integer.parseInt(Console.readLine());
        playRound(cars, playTimes);
    }

    private static void playRound(final List<Car> cars, final int playTimes) {
        for (int i=0; i<playTimes; i++) {
            cars.forEach(car -> car
                    .move(generateRandomNumber()));
        }
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
