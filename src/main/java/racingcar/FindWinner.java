package racingcar;

import java.util.ArrayList;
import java.util.List;

public class FindWinner {

    String[] carNames;
    int[] statusCarMovement;

    public void findWinner(String[] carNames, int[] statusCarMovement) {
        this.carNames = carNames;
        this.statusCarMovement = statusCarMovement;

        List<String> winner = findWinnerName(findMaxCarMovement());
        printWinner(winner);
    }

    private int findMaxCarMovement() {
        int maxMovement = 0;
        for (int status : statusCarMovement) {
            if (maxMovement < status) {
                maxMovement = status;
            }
        }
        return maxMovement;
    }

    private List<String> findWinnerName(int maxMovement) {
        List<String> winner = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            if (statusCarMovement[i] == maxMovement) {
                winner.add(carNames[i]);
            }
        }
        return winner;
    }

    private void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : " + String.join(", ", winner));
    }
}
