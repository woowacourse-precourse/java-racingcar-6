package racingcar;

import racingcar.io.InputHandler;

import java.util.Scanner;

public class RacingGame extends Game{
    private String[] carNames;
    private int tryCount;

    @Override
    public void initGame() {
        carNames = InputHandler.getCarNames("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)").split(",");
        tryCount = InputHandler.getTryCount("시도할 회수는 몇회인가요?");
    }
}
