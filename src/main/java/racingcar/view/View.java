package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class View {
    public String[] getCarNameArray() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNames  = Console.readLine();

        String[] carNameArray = carNames.split(",");

        for (String name : carNameArray) {
            if (name.length()>5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        return carNameArray;
    }

    public int getTimes() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String stringOfTimes = Console.readLine();

        try {
            int intOfTimes = Integer.parseInt(stringOfTimes);
            return intOfTimes;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }

    public void printResult(List<Car> carList) {
        for (Car currentCar : carList) {
            String carName = currentCar.getName();
            int intOfDistance = currentCar.getDistance();
            String stringOfDistance  = getStringOfDistance(intOfDistance);

            System.out.println(carName + " : " + stringOfDistance);
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