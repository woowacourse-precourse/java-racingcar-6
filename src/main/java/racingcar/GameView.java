package racingcar;

import java.util.Map;

public class GameView {

    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void askHowManyTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printResult(Map<String, Integer> carData) {
        for (Map.Entry<String, Integer> entry : carData.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (int j = 0; j < entry.getValue(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printWinner(Map<String, Integer> carData, int maxPosition) {
        System.out.print("최종 우승자 : ");
        carData.forEach((name, position) -> {
            if (position == maxPosition) {
                System.out.print(name + " ");
            }
        });
    }
}
