package racingcar.view;

import java.util.ArrayList;
import racingcar.model.CarData;

public class OutputView {
    public void printRoundScore(ArrayList<CarData> scoreBoard) {
        for (CarData carScore : scoreBoard) {
            printCarScore(carScore.getName(), carScore.getMoveDistance());
        }
        System.out.println();
    }

    public void printWinnerOfGame(ArrayList<String> carNames) {
        System.out.println("최종 우승자 : " + String.join(", ", carNames));
    }


    public void printGameStart() {
        System.out.println("\n실행결과");
    }

    private void printCarScore(String carName, Integer carScore) {

        StringBuilder builder = new StringBuilder();
        String dashScore = generateDashScore(carScore);

        builder.append(carName);
        builder.append(" : ");
        builder.append(dashScore);

        System.out.println(builder);
    }

    private String generateDashScore(Integer score) {
        StringBuilder dashString = new StringBuilder();
        for (int i = 0; i < score; i++) {
            dashString.append("-");
        }
        return dashString.toString();
    }

}
