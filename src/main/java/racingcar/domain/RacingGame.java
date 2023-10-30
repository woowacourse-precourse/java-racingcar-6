package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.MessagePrinter;
import racingcar.utils.Validator;

public class RacingGame {
    private final List<Car> cars;
    private final Validator validator;
    private final MessagePrinter messagePrinter;

    public RacingGame() {
        this.validator = Validator.getInstance();
        this.messagePrinter = MessagePrinter.getInstance();
        this.cars = init();
    }

    public void play() {
        System.out.println("시도할 회수는 몇회인가요?");
        final int playTimes = validator.playTimes(Console.readLine());
        playRound(cars, playTimes);

        Console.close();
    }

    private List<Car> init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNames = Console.readLine();
        validator.carNames(carNames);
        return createCarMembers(carNames);
    }

    private List<Car> createCarMembers(final String carNames) {
        final List<String> members = Arrays.asList(carNames.split(","));
        validator.singleComma(members);
        return members.stream()
                .map(Car::new)
                .toList();
    }

    private void playRound(final List<Car> cars, final int playTimes) {
        System.out.println("실행 결과");
        for (int i=0; i<playTimes; i++) {
            cars.forEach(car -> car
                    .move(generateRandomNumber()));
            messagePrinter.roundResult(cars);
            System.out.println();
        }
        final List<Car> winners = judgeWinners(cars);
        messagePrinter.winners(winners);
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