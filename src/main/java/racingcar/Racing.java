package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racing {
    private Script script;
    private MoveController moveController;
    private List<String> cars;
    private List<StringBuilder> moves;

    public Racing() {
        script = new Script();
        moveController = new MoveController();

        moves = new ArrayList<>();
    }

    private void initializeMoves() {
        for (int i = 0; i < cars.size(); i++) {
            moves.add(new StringBuilder());
        }
    }

    private void inputCarName() {
        script.start();
        cars = Arrays.asList(readLine().split(","));
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

    private void race(int tryNumber) {
        for (int race = 0; race < tryNumber; race++) {
            moveController.tryMove(moves);
            script.showResult(cars, moves);
        }
    }

    public void start() {
        int tryNumber;

        inputCarName();
        tryNumber = inputTryNumber();

        initializeMoves();

        script.guideResult();

        race(tryNumber);
        script.showWinner(moveController.findWinner(cars, moves));
    }
}
