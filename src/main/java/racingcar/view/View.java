package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.io.IOManager;
import racingcar.model.Player;

public class View {

    private final IOManager ioManager;

    public View(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public String printInputCarsNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return ioManager.readString();
    }

    public int printInputRacingTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        return parseRacingTime(ioManager.readString());
    }

    private int parseRacingTime(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("");
        }
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printMovedLog(Map<Player, Integer> moveLog) {

        StringBuilder sb = new StringBuilder();

        for (Entry<Player, Integer> entry : moveLog.entrySet()) {
            Player player = entry.getKey();
            int moveCnt = entry.getValue();
            sb.append(player.getName()).append(" : ").append("-".repeat(Math.max(0, moveCnt)))
                    .append("\n");
        }

        System.out.println(sb);
    }

    public void printWinnerNames(List<String> names) {
        System.out.println("최종 우승자 : " + String.join(", ", names));
    }
}
