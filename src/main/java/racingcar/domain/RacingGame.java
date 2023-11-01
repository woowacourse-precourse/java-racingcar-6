package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.MessagePrinter;
import racingcar.utils.Validator;

public class RacingGame {
    private static final int MIN_GENERATE_VALUE = 0;
    private static final int MAX_GENERATE_VALUE = 9;

    private final List<Car> cars;
    private final Validator validator;
    private final MessagePrinter messagePrinter;
    private final Referee referee;

    public RacingGame(Referee referee) {
        this.validator = Validator.getInstance();
        this.messagePrinter = MessagePrinter.getInstance();
        this.referee = referee;
        this.cars = init();
    }

    private List<Car> init() {
        messagePrinter.initMessage();

        final String carNames = Console.readLine();
        validator.carNames(carNames);
        return createCarMembers(carNames);
    }

    public void play() {
        messagePrinter.requestPlayTimesMessage();

        final int playTimes = validator.playTimes(Console.readLine());
        playRound(cars, playTimes);
        Console.close();

        final List<Car> winners = referee.judgeWinners(cars);
        messagePrinter.winners(winners);
    }

    private List<Car> createCarMembers(final String carNames) {
        validator.correctCommaLocation(carNames);

        final List<String> members = Arrays.asList(carNames.split(","));
        validator.duplicateCarName(members, carNames);
        return members.stream()
                .map(Car::new)
                .toList();
    }

    private void playRound(final List<Car> cars, final int playTimes) {
        messagePrinter.roundResultMessage();

        for (int i = 0; i < playTimes; i++) {
            cars.forEach(car -> car
                    .move(generateRandomNumber()));
            messagePrinter.roundResult(cars);
            messagePrinter.enterLine();
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_GENERATE_VALUE, MAX_GENERATE_VALUE);
    }
}