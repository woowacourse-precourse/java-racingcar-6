package racingcar;

import racingcar.controller.Stadium;
import racingcar.policy.RacingCarGameMovingPolicy;
import racingcar.policy.RandomNumberGeneratePolicy;
import racingcar.view.Console;
import racingcar.view.MissionUtilsInput;
import racingcar.view.PrintStreamOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        new Stadium(
                new Console(
                        new MissionUtilsInput(), new PrintStreamOutput()
                ),
                new RacingCarGameMovingPolicy(),
                new RandomNumberGeneratePolicy()
        ).start();
    }
}
