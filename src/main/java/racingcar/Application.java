package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController =
                new RacingCarGameController(
                        new RacingCarGameService()
                );
        racingCarGameController.start();
    }
}
