package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private OutputView() {
    }

    public static void printRacingStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAskCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printCarsMove(Map<String, Integer> currentPosition) {
        for (Entry<String, Integer> carsInformation : currentPosition.entrySet()) {
            StringBuilder carString = new StringBuilder();
            carString.append(carsInformation.getKey());
            carString.append(" : ");
            for (int i = 0; i < carsInformation.getValue(); i++) {
                carString.append("-");
            }
            System.out.println(carString);
        }
        System.out.println();
    }

    public static void printFindWinner(List<String> winners) {
        System.out.println("최종 우승자 :" + " " + String.join(", ", winners));
    }
}
