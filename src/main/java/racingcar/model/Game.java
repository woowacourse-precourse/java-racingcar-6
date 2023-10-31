package racingcar.model;

import java.util.ArrayList;

public class Game {
    public ArrayList<Car> carList = new ArrayList<>();
    public int round;
    private final ArrayList<String> winnerNameList = new ArrayList<>();
    private int maxScore;

    public void updateWinners(String carName, int carScore){
        if (carScore > maxScore) {
            maxScore = carScore;
            winnerNameList.clear();
        }
        if (carScore == maxScore) {
            winnerNameList.add(carName);
        }
    }

    public ArrayList<String> getWinners(){
        return winnerNameList;
    }
}
