package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> winner;

    public Winner(List<Car> winner) {
        this.winner = winner;
    }

    public void printWinner(){
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winner) {
            winnerNames.add(car.getName());
        }
        String winners = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winners);
    }
}
