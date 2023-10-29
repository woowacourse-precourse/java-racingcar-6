package racingcar.view;

import java.util.ArrayList;

public class OutputView {
    public void printRoundScore(ArrayList<String> scoreBoard) {
        for (String score : scoreBoard) {
            String[] carNameScore = score.split(",");
            printCarScore(carNameScore[0], carNameScore[1]);
        }
        System.out.println();
    }

    public void printWinnerOfGame(ArrayList<String> carNames) {
        System.out.println("최종 우승자: " + String.join(", ", carNames));
    }


    public void printGameStart() {
        System.out.println("\n실행결과");
    }

    private void printCarScore(String carName, String carScore) {

        StringBuilder builder = new StringBuilder();
        String dashScore = generateDashScore(carScore);

        builder.append(carName);
        builder.append(" : ");
        builder.append(dashScore);

        System.out.println(builder);
    }

    private String generateDashScore(String source) {
        StringBuilder dashString = new StringBuilder();
        int score = Integer.parseInt(source);
        for (int i = 0; i < score; i++) {
            dashString.append("-");
        }
        return dashString.toString();
    }

}
