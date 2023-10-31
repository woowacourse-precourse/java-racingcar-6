package racingcar.domain;

import static racingcar.constants.ErrorMsg.INITIALIZED_ERROR;
import static racingcar.constants.ErrorMsg.NO_REFEREE_ERROR;

import java.util.ArrayList;
import java.util.StringJoiner;

public class RacingGame {
    private Cars cars;
    private Referee referee;

    public void prepareGame(Cars carList) {
        this.cars = carList;
        this.referee = new Referee(cars);
    }

    public void startGame(int rounds) {
        if (cars == null || referee == null) {
            throw new IllegalStateException(INITIALIZED_ERROR);
        }

        for (int i = 0; i < rounds; i++) {
            this.cars = referee.playRound(cars);
            printRoundResults();
        }
        System.out.println("\n실행 결과");
        printGameWinner();
    }

    private void printRoundResults() {
        if (referee == null) {
            throw new IllegalStateException();
        }
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.getIndex(i).getName() + " : " + "-".repeat(cars.getIndex(i).getPosition()));
        }
    }

    private void printGameWinner() {
        if (referee == null) {
            throw new IllegalStateException(NO_REFEREE_ERROR);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        Cars winners = referee.determineWinners(cars);

        StringJoiner joiner = new StringJoiner(", ");

        for (int i = 0; i < winners.size(); i++) {
            joiner.add(winners.getIndex(i).getName());
        }
        String winnersString = joiner.toString();
        stringBuilder.append(winnersString);

        System.out.println(stringBuilder);
    }
}
