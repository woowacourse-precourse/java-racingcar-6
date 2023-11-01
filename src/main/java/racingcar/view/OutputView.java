package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {

    public static void printResultOfCarStatus(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + getCarPositionString(car));
        }
        System.out.println();
    }

    public static String getCarPositionString(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void printFinalWinners(List<String> winnersName) {
        StringBuilder sb = new StringBuilder("최종 우승자는 ");
        if (!winnersName.isEmpty()) {
            sb.append(winnersName.get(0));
        }

        for (int i = 1; i < winnersName.size(); i++) {
            sb.append(", ").append(winnersName.get(i));
        }
        sb.append(" 입니다.");
        System.out.println(sb);
    }

}