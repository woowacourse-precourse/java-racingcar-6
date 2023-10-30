package racingcar;

import java.util.List;

public class OutputHandler {

    public void printStartMessages() {
        String result = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        System.out.println(result);
    }

    public void printAskRounds() {
        String result = "시도할 회수는 몇회인가요?";
        System.out.println(result);
    }

    public void printResults(String name, int distance) {
        StringBuilder result = new StringBuilder();
        result.append(name + " : ");

        for (int i = 0; distance > i; i++) {
            result.append("-");
        }

        System.out.println(result);
    }

    public void printWinners(List<String> winners) {
        String result = "최종 우승자 : " + String.join(", ", winners);
        System.out.println(result);
    }
}
