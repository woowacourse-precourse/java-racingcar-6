package racingcar;

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
        System.out.print("시도할 회수는 몇회인가요?\n");
        String attemptsNumber = Console.readLine().trim();

        validateFormat(attemptsNumber);

        this.attemptsNumber = Integer.parseInt(attemptsNumber);
    }

    private void validateFormat(String attemptsNumber) {
        if (!attemptsNumber.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException();
        }
    }
}
