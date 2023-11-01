package racingcar.view;

import racingcar.domain.Judgment;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String RESULT_OF_THE_GAME = "실행 결과";

    public static void printResultOfTheGame() {
        System.out.println(RESULT_OF_THE_GAME);
    }

    public static StringBuilder showRacingResult(int k) {
        StringBuilder showRacingResult = new StringBuilder();
        for(int i = 0; i < k; i ++) {
            showRacingResult.append("-");
        }
        return showRacingResult;
    }

    public static void gameResult() {
        for(int i = 0; i < InputView.getNumberOfCars(); i++) {
            System.out.println(InputView.getNameOfCars().get(i) + " : " + showRacingResult(Judgment.getUserForwardMovement()[i]));
        }
        System.out.println();
    }

    public static List<Integer> findWinnerOfGame() {
        int[] findWinner = Judgment.getUserForwardMovement();
        int max = 0;
        List<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < findWinner.length; i++) {
            if (findWinner[i] > max) {
                max = findWinner[i];
                maxIndices.clear();
                maxIndices.add(i);
            } else if (findWinner[i] == max) {
                maxIndices.add(i);
            }
        }
        return maxIndices;
    }

    public static void winnerOfGame() {
        List<Integer> winnerIndex = findWinnerOfGame();
        StringBuilder winner = new StringBuilder(" ");
        for(int i = 0; i < winnerIndex.size(); i++) {
            winner.append(InputView.getNameOfCars().get(winnerIndex.get(i)));
            if (i < winnerIndex.size() - 1) {
                winner.append(", ");
            }
        }
        System.out.println("최종 우승자 :" + winner);
    }
}
