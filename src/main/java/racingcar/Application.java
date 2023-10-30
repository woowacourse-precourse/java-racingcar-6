package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.resolver.RacingCarRun;

public class Application {
    public static void main(String[] args) {
        try {
            new RacingCarRun().run();
        } finally {
            Console.close();
        }
    }
}
