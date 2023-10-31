package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;

public class ResultOutput {
    private Cars cars = new Cars();

    public void printExecutionResult(ArrayList<String> carNames, ArrayList<List<String>> carProgress) {

        for (int a = 0; a < carNames.size(); a++) {
            System.out.println(carNames.get(a) + " : " + carProgress.get(a).get(0));
        }
        System.out.println();

    }

    public void printFinalWinner(ArrayList<String> finalWinnerList) {
        String result = "최종 우승자 : " + String.join(", ", finalWinnerList);
        System.out.println(result);


    }


}
