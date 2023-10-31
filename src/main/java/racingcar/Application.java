package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            List<Car> cars = UserInput.initializeCars();
            int numberOfAttempts = UserInput.getNumberOfAttempts();

            System.out.println("\n실행 결과");
            for (int i = 0; i < numberOfAttempts; i++) {
                Play.playRound(cars);
            }

            List<String> winners = Winners.getWinners(cars);
            Winners.printWinners(winners);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
