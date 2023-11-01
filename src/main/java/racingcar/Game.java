package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final List<Car> carList;
    private final int racingCount;

    public Game(List<Car> carList, int racingCount) {
        this.carList = carList;
        this.racingCount = racingCount;
    }

    public void printStartPlaying() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void playRacing() {
        for (int i = 0; i < racingCount; i++) {
            playEachRacing();
        }
    }

    private void playEachRacing() {
        for (Car car : carList) {
            playEachCar(car);
        }
        System.out.println();
    }

    private void playEachCar(Car car) {
        int randomNumber = car.getRandomNumber();
        car.updateMovingCountOrNot(randomNumber);
        String result = car.getResult();
        System.out.println(result);
    }

    public List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        int maxCount = getMaxCount();

        for (Car car : carList) {
            String name = car.getName();

            if (car.isWinner(maxCount)) {
                winnerList.add(name);
                continue;
            }
            break;
        }
        return winnerList;
    }

    private int getMaxCount() {
        carList.sort(Collections.reverseOrder());
        Car maxCountCar = carList.get(0);
        return maxCountCar.getMovingCount();
    }

    public void printWinners(List<String> winnerList) {
        int listSize = winnerList.size();

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < listSize-1; i++) {
            System.out.print(winnerList.get(i) + ", ");
        }
        System.out.println(winnerList.get(listSize - 1));
    }
}