package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingGameController;
import racingcar.domain.numberpicker.RandomNumberPicker;
import racingcar.domain.numberpicker.SystemRandomNumberPicker;
import racingcar.io.UserIoManager;
import racingcar.io.input.ConsoleReader;
import racingcar.io.output.ConsoleWriter;

public class Application {

    public static void main(String[] args) {
        RandomNumberPicker randomNumberPicker = new SystemRandomNumberPicker();
        UserIoManager userIoManager = new UserIoManager(new ConsoleReader(), new ConsoleWriter());

        RacingGameController racingGameController = new RacingGameController(randomNumberPicker, userIoManager);
        racingGameController.run();

        Console.close();
    }

}
