package racingcar.view;

import racingcar.dto.Players;

public class OutputView {

    private static final String OUTPUT_FIRST_MESSAGE = "실행 결과";
    private static final String RESULT_MESSAGE = "최종 우승자 :";

    public void printFirstText() {

        System.out.println(OUTPUT_FIRST_MESSAGE);
    }

    public void printMiddleProcess(Players players) {

        System.out.println(players.toString());

    }

    public void printResult(Players players) {

        int max = players.getMaxStep();
        System.out.print(RESULT_MESSAGE);

        String result = "";

        for (int index = 0; index < players.getPlayersList().size(); index++) {

            if (determineWinner(players.getForwardStepList().get(index), max)) {
                result = addWinnerResult(players, index, result);
            }

        }

        System.out.println(result);
    }

    private boolean determineWinner(int value, int max) {

        if (value == max) {
            return true;
        } else {
            return false;
        }

    }

    private String addWinnerResult(Players players, int index, String result) {

        if (result.isEmpty()) {
            result += " " + players.getPlayersList().get(index);
        } else {
            result += ", " + players.getPlayersList().get(index);
        }

        return result;
    }
}
