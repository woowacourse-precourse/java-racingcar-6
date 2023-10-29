package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printGameResultMessage() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Map<String, String>> racingCarsInfo) {
        for (Map<String, String> carInfo : racingCarsInfo) {
            String carName = carInfo.get("name");
            String position = carInfo.get("position");
            System.out.println(carName + " : " + position);
        }
        System.out.println();
    }
}
