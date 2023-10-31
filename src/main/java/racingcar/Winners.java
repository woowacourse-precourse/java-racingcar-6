package racingcar;

import java.util.List;

public class Winners {

    private List<String> winners;

    public Winners(List<String> winners) {
        this.winners = winners;
    }

    public String getWinner(int max, List<String> scores, Cars cars) {
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i).length() == max) {
                winners.add(cars.getCar(i).getCarName());
            }
        }
        return String.join(",", winners);
    }

}
