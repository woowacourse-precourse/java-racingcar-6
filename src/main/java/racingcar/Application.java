package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingGameController;
import racingcar.domain.numberpicker.RandomNumberPicker;
import racingcar.domain.numberpicker.SystemRandomNumberPicker;
import racingcar.io.UserIoManager;
import racingcar.io.input.ConsoleReader;
import racingcar.io.input.InputManager;
import racingcar.io.input.Reader;
import racingcar.io.output.ConsoleWriter;

public class Application {

    public static void main(String[] args) {
        RandomNumberPicker randomNumberPicker = new SystemRandomNumberPicker();

        Reader reader = new ConsoleReader();
        UserIoManager userIoManager = new UserIoManager(new InputManager(reader), new ConsoleWriter());

        RacingGameController racingGameController = new RacingGameController(randomNumberPicker, userIoManager);
        racingGameController.run();

        Console.close();
    }

}
