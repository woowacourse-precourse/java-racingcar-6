package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    public static String resultHeaderMessage() {
        return "실행 결과";
    }

    // 현재 자동차들의 전진 상태 출력 템플릿 생성
    public static String currentForwardStateMessage(Cars carList) {
        return getForwardStateString(carList);
    }

    private static String getForwardStateString(Cars carList) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList.getCarList()) {
            sb.append(getForwardStateString(car));
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String getForwardStateString(Car car) {
        return car.getName() + " : "
                + "-".repeat(car.getPosition());
    }

    // 최종 우승자 출력 템플릿 생성
    public static String WinnersMessage(Cars winners) {
        return winnersToString(winners);
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
