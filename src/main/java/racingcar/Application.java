package racingcar;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Print print = new Print();
        Input input = new Input();
        RacingGame racingGame = new RacingGame();

        print.carName();
        Map<String, Integer> carNames = input.carNames(); // todo tdd
        print.tryCount();
        int tryCount = input.tryCount(); // todo tdd

        print.executeInit();
        for (int i = 0; i < tryCount; i++) {
            // todo 게임 수행
            racingGame.executeCondition(carNames);
            print.executeProgress(carNames);
        }
        print.result(tryCount, carNames);
    }
}
