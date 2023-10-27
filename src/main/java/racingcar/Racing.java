package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racing {
    private Script script;
    private List<String> cars;
    private List<StringBuilder> moves;

    public Racing() {
        script = new Script();
        moves = new ArrayList<>();
    }

    private void initializeMoves() {
        for (int i = 0; i < cars.size(); i++) {
            moves.add(new StringBuilder());
        }
    }

    private void checkNameLengthWithinFive() {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void inputCarName() {
        script.start();

        String input = readLine();

        if (input.indexOf(',') == -1) {
            throw new IllegalArgumentException();
        }

        cars = Arrays.asList(input.split(","));
    }

    private boolean isNumber(String number) {
        for (int index = 0; index < number.length(); index++) {
            if (number.charAt(index) < '0' || number.charAt(index) > '9') {
                return false;
            }
        }

        return true;
    }

    private int inputTryNumber() {
        script.askTry();

        String input = readLine();
        int tryNumber;

        if (!isNumber(input)) {
            throw new IllegalArgumentException();
        }

        tryNumber = Integer.parseInt(input);

        return tryNumber;
    }

    private void race(MoveController moveController, int tryNumber) {
        for (int race = 0; race < tryNumber; race++) {
            moveController.tryMove(moves);
            script.showResult(cars, moves);
        }
    }

    public void start() {
        MoveController moveController = new MoveController();
        int tryNumber;

        inputCarName();
        checkNameLengthWithinFive();
        initializeMoves();

        tryNumber = inputTryNumber();

        script.guideResult();
        race(moveController, tryNumber);
        script.showWinner(moveController.findWinner(cars, moves));
    }
}
