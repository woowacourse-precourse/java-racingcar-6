package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Score {
    public String scoreVisualization(int score) {
        String result ="";
        for (int i = 0; i < score; i++) {
            result += "-";
        }
        return result;
    }

    public void printRoundResult(List<Car> Cars) {
        System.out.println();
        for(Car car : Cars) {
            System.out.println(car.name + " : " + scoreVisualization(car.score));
        }
    }

    public void printWinnerResult(List<Car> Cars) {
        int max = Integer.MIN_VALUE;
        List<String> winnerNames = new ArrayList<>();
        String result="";

        for(Car car : Cars) {
            if(car.score > max) max = car.score;
        }
        for(Car car : Cars) {
            if(car.score == max) {
                winnerNames.add(car.name);
            }
        }
        System.out.println();
        result = String.join(",", winnerNames);
        System.out.println("최종 우승자 : " + result);
    }
}
