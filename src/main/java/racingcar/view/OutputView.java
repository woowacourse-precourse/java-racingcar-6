package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputView {
    public static void printRequestCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRequestTryNumberMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printGameResultMessage(List<String> carNameList, LinkedHashMap<String, Integer> locations) {
        for (int i = 0; i < locations.size(); i++) {
            System.out.print(carNameList.get(i) + " : ");
            printCarLocationMessage(locations.get(carNameList.get(i)));
        }
    }

    public static void printCarLocationMessage(int carLocation) {
        for (int i = 0; i < carLocation; i++) {
            System.out.print("-");
        }
        System.out.println();
    }


}
