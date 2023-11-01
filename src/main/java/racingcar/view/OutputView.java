package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void currentLocation(Map<String, Integer> car) {
        for (String key : car.keySet()) {
            int locationNumber = car.get(key);
            System.out.print(key + " : ");
            printLocation(locationNumber);
            System.out.println("");
        }
    }

    private void printLocation(int locationNumber) {
        for (int i = 0; i < locationNumber; i++) {
            System.out.print("-");
        }
    }

    public void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : ");

        if (winner.size() == 1) {
            System.out.println(winner.get(0));
            return;
        }

        System.out.print(winner.get(0));
        for (int i = 1; i < winner.size(); i++) {
            System.out.print(", ");
            System.out.print(winner.get(i));
        }
    }
}
