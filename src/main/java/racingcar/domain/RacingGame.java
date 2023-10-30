package racingcar.domain;

import static racingcar.utils.MessagePrinter.roundResult;
import static racingcar.utils.MessagePrinter.winners;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.Validator;

public class RacingGame {
    private List<Car> cars;
    private final Validator validator = Validator.getInstance();

    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNames = Console.readLine();
        validator.carNames(carNames);
        createCars(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        final int playTimes = validator.playTimes(Console.readLine());
        playRound(cars, playTimes);

        Console.close();
    }

    private void createCars(final String carNames) {
        final List<String> members = Arrays.asList(carNames.split(","));
        validator.singleComma(members);
        this.cars = members.stream()
                .map(Car::new)
                .toList();
    }

    private void playRound(final List<Car> cars, final int playTimes) {
        System.out.println("실행 결과");
        for (int i=0; i<playTimes; i++) {
            cars.forEach(car -> car
                    .move(generateRandomNumber()));
            roundResult(cars);
            System.out.println();
        }
        final List<Car> winners = judgeWinners(cars);
        winners(winners);
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private List<Car> judgeWinners(final List<Car> cars) {
        final int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public static int getMaxPosition(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}