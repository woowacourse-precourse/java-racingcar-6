package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printResult(List<Car> carList) {
        for (Car currentCar : carList) {
            String carName = currentCar.getName();

            int intOfDistance = currentCar.getDistance();
            String stringOfDistance  = makeStringOfDistance(intOfDistance);

            System.out.println(carName + " : " + stringOfDistance);
        }

        System.out.println();
    }

    public String makeStringOfDistance(int distance){
        String stringOfDistance = "";

        for (int i = 0 ; i < distance ; i++) {
            stringOfDistance += '-';
        }

        return stringOfDistance;
    }

    public void printWinner(List<String> winnerList) {
        StringBuilder result = new StringBuilder();

        for (String winner : winnerList) {
            if (result.length() > 0) {
                result.append(", ");
            }

            result.append(winner);
        }

        System.out.println("최종 우승자 : " + result);
    }
}