package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<Car> winnerList;
    public static void printRaceResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.printf("%s : %s\n", car.getName(), car.getState());
        }
        System.out.println();
    }

    public void printWinner() {

    public int getLeaderDistance(List<Car> carList) {
        int leaderDistance = carList.stream().map(Car::getState).mapToInt(String::length).max().getAsInt();
        // car 하나씩 빼서 car.getState 가장 긴 것 반환
        return leaderDistance;
    }

}
