package racingcar;

import java.util.List;

public class Logic {
    private static final Input input = new Input();
    private static final Output output = new Output();

    public static void doGame() {
        Output.printGuideCarName(); //4번 기능

        List<String> carNames = Input.getCarNames(); //1번 기능

        Output.printGuideTryCount(); //5번 기능

        Long tryCount = Input.getTryCount(); //2번 기능
    }
}
