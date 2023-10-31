package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class RacingView {
    public String getCarListInput() {
        return Console.readLine();
    }

    public String getAttemptInput() {
        return Console.readLine();
    }

    public void printRacingStartMessage() {
        System.out.println("실행 결과");
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s\n", winnerNames);
    }

    public void printProgress(Map<String, Integer> status) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> carStatus : status.entrySet()) {
            String name = carStatus.getKey();
            String progress = "-".repeat(carStatus.getValue());
            sb.append(String.format("%s : %s%n", name, progress));
        }
        sb.append('\n');
        System.out.print(sb);
    }

    public void printCarListInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptInputMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }
}
