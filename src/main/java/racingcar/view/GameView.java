package racingcar.view;

import java.util.List;

public class GameView {
    private final InputHandler carNamesHandler;
    private final InputHandler numberAttemptsHandler;

    public GameView() {
        carNamesHandler = new InputHandler(
                new CarNamesValidator(), new CarNamesParser());
        numberAttemptsHandler = new InputHandler(
                new NumberAttemptsValidator(), new NumberAttemptsParser());
    }

    public List<String> askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return (List<String>) carNamesHandler.handle();
    }

    public Integer askNumberAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return (Integer) numberAttemptsHandler.handle();
    }
}
