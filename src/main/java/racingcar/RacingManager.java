package racingcar;

import static racingcar.common.GameMessage.ATTEMPTS_NUMBER_MESSAGE;
import static racingcar.regex.RegularExpression.ATTEMPTS_NUMBER_PATTERN;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Domain.CarList;
import racingcar.Domain.Race;
import racingcar.Domain.Winner;

public class RacingManager {

    private int attemptsNumber;

    public void execute() {
        CarList carList = new CarList();
        carList.namesInput();
        attemptsNumberInput();
        Race race = new Race(carList.getCars());
        race.result(this.attemptsNumber);
        Winner winner = new Winner(carList.getCars());
        winner.printWinners();
    }

    public void attemptsNumberInput() {
        System.out.print(ATTEMPTS_NUMBER_MESSAGE);
        String attemptsNumber = Console.readLine().trim();

        validateFormat(attemptsNumber);

        this.attemptsNumber = Integer.parseInt(attemptsNumber);
    }

    private void validateFormat(String attemptsNumber) {
        if (!attemptsNumber.matches(ATTEMPTS_NUMBER_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }
}
