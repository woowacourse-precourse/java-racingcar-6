package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_NUM_OF_ATTEMPTS_MESSGE = "시도할 회수는 몇회인가요?";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void askNumOfAttemptsMessage() {
        System.out.println(ASK_NUM_OF_ATTEMPTS_MESSGE);
    }

    public void printProgress(String name, int position) {
        System.out.println(name + " : " + convertPositionString(position));
    }

    private String convertPositionString(int position) {
        String stringPosition = "";
        for (int i = 0; i < position; i++) {
            stringPosition += "-";
        }
        return stringPosition;
    }

    public void printAfterAskNumber() {
        System.out.println('\n' + "실행결과");
    }

    public void printWinners(List<Car> winners) {
        List<String> winCars = new ArrayList<>();
        System.out.print("최종 우승자 : ");
        winCars = convertStringList(winners);
        System.out.println(String.join(",", winCars));
    }

    public List<String> convertStringList(List<Car> carList) {
        List<String> stringCarList = new ArrayList<>();
        for (Car car : carList) {
            stringCarList.add(car.getName());
        }
        return stringCarList;
    }

}
