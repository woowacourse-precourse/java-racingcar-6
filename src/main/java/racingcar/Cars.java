package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String RACE_START_MESSAGE = "\n실행결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private Car[] cars;

    public void setCarList(String[] carNames) {
        cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public void raceStart(int round) {
        System.out.println(RACE_START_MESSAGE);
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < cars.length; j++) {
                cars[j].cycle();
                printPosition(cars[j]);
            }
            System.out.println();
        }
    }

    private void printPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private int getMaxPosition() {
        int maxPosition = cars[0].getPosition();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getPosition() > maxPosition) {
                maxPosition = cars[i].getPosition();
            }
        }
        return maxPosition;
    }

    private List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getPosition() == maxPosition) {
                winnerList.add(cars[i].getName());
            }
        }
        return winnerList;
    }

    public void printWinner() {
        List<String> winnerList = getWinnerList();
        StringBuilder result = new StringBuilder();
        result.append(WINNER_MESSAGE);
        result.append(winnerList.get(0));
        if (winnerList.size() > 1) {
            for (int i = 1; i < winnerList.size(); i++) {
                result.append(", ").append(winnerList.get(i));
            }
        }
        System.out.println(result);
    }
}
