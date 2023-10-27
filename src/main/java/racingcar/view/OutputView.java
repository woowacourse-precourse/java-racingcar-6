package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    public static void printResultHeaderMessage() {
        System.out.println("실행 결과");
    }

    // 현재 자동차들의 전진 상태 출력 하는 기능
    public static void printCurrentForwardState(Cars carList) {
        System.out.println(getForwardStateStringOfCarList(carList));
    }

    public static String getForwardStateStringOfCarList(Cars carList) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList.getCarList()) {
            sb.append(getForwardStateStringOfCar(car));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String getForwardStateStringOfCar(Car car) {
        return car.getName() + " : "
                + "-".repeat(car.getPosition());
    }

    // 최종 우승자 출력 하는 기능
    public static void printWinners(Cars winners) {
        System.out.println(winnersToString(winners));
    }

    private static String winnersToString(Cars winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i).getName());
            if (i != winners.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
