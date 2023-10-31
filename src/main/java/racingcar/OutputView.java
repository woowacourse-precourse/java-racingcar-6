package racingcar;

import java.util.List;

public class OutputView {

    public void printResult(int count, RacingCars racingCars) {
        System.out.println("실행 결과");
        while (count > 0) {
            racingCars.turnOn();

            for (RacingCar car : racingCars.getRacingCars()) {
                System.out.println(car.getName() + " : " + convertDistanceToDash(car.getDistance()));
            }
            System.out.println();
            count--;
        }
    }

    private String convertDistanceToDash(int distance) {
        String dash = "";
        while(distance-- >0) {
            dash += "-";
        }
        return dash;
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 :" + convertWinnersToStr(winners));
    }


    private String convertWinnersToStr(List<String> winners) {
        String finalWinners = "";
        for (String winner : winners) {
            finalWinners += " " + winner +",";
        }
        return finalWinners.substring(0,finalWinners.length() - 1);
    }
}
