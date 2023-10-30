package racingcar;

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
        String result = "";
        for(Car car : Cars) {
            System.out.println(car.name + " : " + scoreVisualization(car.score));
        }
    }

    public void printWinnerResult(List<Car> Cars) {
        //List<String> members = Arrays.asList("pobi", "jason");
        //String result = String.join(",", members); // "pobi,jason"
        int max = Integer.MIN_VALUE;
        int count=0;
        String[] winnerNames;
        String result="";

        for(Car car : Cars) {
            if(car.score > max) max = car.score;
        }
        for(Car car : Cars) {
            if(car.score == max) count++;
        }
        winnerNames = new String[count];
        for(Car car : Cars) {
            if(car.score == max) {
                winnerNames[count] = car.name;
            }
        }
        result = String.join(",", winnerNames);
        System.out.println("최종 우승자 : " + result);
    }
}
