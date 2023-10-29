package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Race {
    private int moveNum;

    public void play() {
        inputCarNames();
        inputMovingNumber();

        for (int num = 0; num < moveNum; num++) {
            updateCarsPosition();
            displayCarMoving();
        }

        decideWinner();
        displayWinner();
    }

    private String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        return input.split(",");
    }

    }

    private void inputMovingNumber() {

    }

    private void updateCarsPosition() {

    }

    private void displayCarMoving() {

    }

    private void decideWinner() {

    }

    private void displayWinner() {

    }
}