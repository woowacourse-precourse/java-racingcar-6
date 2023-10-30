package racingcar.domain;

import static racingcar.utils.MessagePrinter.printWinners;
import static racingcar.utils.MessagePrinter.roundResult;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private List<Car> cars;

    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNames = Console.readLine();
        validCarNames(carNames);
        createCars(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        final int playTimes = Integer.parseInt(Console.readLine());
        playRound(cars, playTimes);

        Console.close();
    }

    private void validCarNames(final String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상이어야 합니다.");
        }
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("두 개 이상의 자동차 이름을 쉼표로 구분하여 입력해주세요.");
        }
    }

    private void createCars(final String carNames) {
        final List<String> members = Arrays.asList(carNames.split(","));
        validSingleComma(members);
        this.cars = members.stream()
                .map(Car::new)
                .toList();
    }

    private void validSingleComma(final List<String> members) {
        boolean isMemberEmpty = members.stream()
                .anyMatch(String::isBlank);
        if (isMemberEmpty) {
            throw new IllegalArgumentException("쉼표를 연속으로 입력할 수 없습니다.");
        }
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
        printWinners(winners);
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
