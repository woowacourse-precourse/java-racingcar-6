package racingcar;

import java.util.ArrayList;

public class Judgement {

    private int furthestMovement;
    private String carName;
    private int carMovement;
    private ArrayList<String> winnerList = new ArrayList<>();

    public boolean isOverFour(int number) {
        if (number >= 4) {
            return true;
        }
        return false;
    }

    public ArrayList<String> checkWinner(ArrayList<Car> cars) {
        furthestMovement = findFurthestMovement(cars);
        for (int i = 0; i < cars.size(); i++) {
            carName = cars.get(i).getCarName();
            carMovement = cars.get(i).getCarMovement();
            if (carMovement == furthestMovement) {
                winnerList.add(carName);
            }
        }
        return winnerList;
    }

    public int checkWinnersNumber(ArrayList<String> winnerList) {
        return winnerList.size();
    }

    public int findFurthestMovement(ArrayList<Car> cars) {
        int max = -1;
        for (int i = 0; i < cars.size(); i++) {
            carName = cars.get(i).getCarName();
            carMovement = cars.get(i).getCarMovement();
            max = Math.max(max, carMovement);
        }
        return max;
    }
}
