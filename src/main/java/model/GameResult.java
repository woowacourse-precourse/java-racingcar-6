package model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    public static List<String> winner(List<Car> carList) {

        List<String> winner = new ArrayList<>();
        int winnerGoValue = 0;

        for (Car car : carList) {
            if (car.getGo() > winnerGoValue) {
                winner.clear();
                winnerGoValue = car.getGo();
            }
            if (car.getGo() == winnerGoValue) {
                winner.add(car.getName());
            }
        }

        return winner;
    }

}
