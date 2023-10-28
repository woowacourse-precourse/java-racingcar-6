package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameExecutor {
    private RacingCarGame game;
    private InputView inputView;

    public GameExecutor() {
        this.inputView = new InputView();
    }

    public void run() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] names = inputView.getNames();
            System.out.println("시도할 회수는 몇회인가요?");
            int trial = inputView.getTrial();
            game = new RacingCarGame(trial, names);
        } finally {
            inputView.close();
        }
    }
}
