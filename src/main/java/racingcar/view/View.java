package racingcar.view;

import java.util.List;
import racingcar.io.IOManager;

public class View {

    IOManager ioManager;

    public View(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public String printInputCarsNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return ioManager.readString();
    }

    public String printInputAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return ioManager.readString();
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printMovedLog(String name, int moveCnt) {

        String movedLog = name + " : "
                + "-".repeat(Math.max(0, moveCnt));

        System.out.println(movedLog);
    }

    public void printWinnerNames(List<String> names) {
        String winnerNames = String.join(", ", names);
        System.out.println(winnerNames);
    }
}
