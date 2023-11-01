package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRace {

    private final int round;
    private final List<String> carNames;
    private final List<StringBuilder> results;

    public CarRace(String[] carNames, int round) {
        if (round < 1) {
            throw new IllegalArgumentException("CarRace : round < 1");
        }

        this.round = round;
        this.carNames = Arrays.stream(carNames).toList();
        nameCheck();

        this.results = new ArrayList<>(carNames.length);

        for (int i = 0; i < carNames.length; i++) {
            results.add(new StringBuilder());
        }
    }

    private void nameCheck() {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("CarRace : name invalid");
            }
        }
    }

    public List<String> run() {
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            playRound();
            printRound();
            System.out.println();
        }
        return winners();
    }

    private void playRound() {
        for (StringBuilder result : results) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                result.append("-");
            }
        }
    }

    private void printRound() {
        for (int i = 0; i < results.size(); i++) {
            System.out.println(carNames.get(i) + " : " + results.get(i));
        }
    }

    private List<String> winners() {
        List<String> winners = new ArrayList<>();
        int max = -1;
        for (int i = 0; i < results.size(); i++) {
            int result = results.get(i).length();
            if (result < max) {
                continue;
            }
            if (result > max) {
                max = result;
                winners = new ArrayList<>();
            }
            winners.add(carNames.get(i));
        }
        return winners;
    }
}
