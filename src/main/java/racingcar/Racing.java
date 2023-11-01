package racingcar;

import java.util.ArrayList;

public class Racing {
    Car[] cars;
    int raceCount;
    ArrayList<String> winnerList = new ArrayList<String>();

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
            outputRaceProcess();
        }
    }

    public void findWinner() {
        int maxPosition = -1;

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
        outputWinner();
    }

    public void outputRaceProcess() {
        for (Car i : cars) {
            System.out.println(i.name + " : " + "-".repeat(i.position));
        }
        System.out.println();
    }

    public void outputWinner() {
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

}
