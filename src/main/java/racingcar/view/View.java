package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class View {
    public String[] getNamesOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String namesOfCars  = Console.readLine();

        String[] splitNamesOfCars = namesOfCars.split(",");
        return splitNamesOfCars;
    }

    public int getNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String stringOfAttempts = Console.readLine();

        try {
            int intOfAttempts = Integer.parseInt(stringOfAttempts);
            return intOfAttempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }

    public void printResult(List<Car> carList) {
        for (Car currentCar : carList) {
            String name = currentCar.getName();
            int distance = currentCar.getDistance();
            String stringOfDistance  = getStringOfDistance(distance);

            System.out.println(name + " : " + stringOfDistance);
        }
        System.out.println();
    }

    public String getStringOfDistance(int distance){
        String stringOfDistance = "";
        for (int i = 0 ; i < distance ; i++) {
            stringOfDistance += '-';
        }

        return stringOfDistance;
    }

    public void printWinner(List<String> winnerList) {
        System.out.print("최종 우승자 : ");

        StringBuilder result = new StringBuilder();
        for (String winner : winnerList) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(winner);
        }

        System.out.println(result);
    }
}