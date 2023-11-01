package racingcar;

import java.util.ArrayList;

public class Racing {
    Car[] cars;
    int raceCount;
    public Racing(String[] carList, int raceCount) {
        this.raceCount = raceCount;
        cars = new Car[carList.length];
        for (int i = 0; i < carList.length; i++)
            cars[i] = new Car(carList[i], 0);
    }

    public void race() {
        for (int i = 0; i < raceCount; i++) {
            for (Car j : cars)
                j.moveCar();
        }
    }

    public void findWinner() {
        int maxPosition = -1;
        ArrayList<String> winnerList = new ArrayList<String>();

        for (Car i : cars) {
            if (i.position > maxPosition) {
                maxPosition = i.position;
                winnerList = new ArrayList<String>();
                winnerList.add(i.name);
            }
            else if (i.position == maxPosition) {
                winnerList.add(i.name);
            }
        }
    }

    

}
