package racingcar.view;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {


    public void showRacing(String carName, int carSteps) {
        System.out.println(carName + " : " + "-".repeat(carSteps));
    }

    public String selectWinner(List<String> carNames, List<Integer> steps) {
        int max = Collections.max(steps);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < steps.size(); i++) {
            if (steps.get(i) == max) {
                winners.add(carNames.get(i));
            }
        }
        String result = String.join(",", winners);

        return result;
    }
}
