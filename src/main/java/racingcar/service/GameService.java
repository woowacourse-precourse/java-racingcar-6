package racingcar.service;

import racingcar.constant.AnnouncerScript;
import racingcar.domain.CarDTO;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class GameService {

    private Output output = Output.getOutput();

    private Input input = Input.getInput();

    public GameService() {
    }

    public void start() {
        output.printMessage(AnnouncerScript.START_MENTION);

        List<CarDTO> carNames = setCarName();
    }

    private List<CarDTO> setCarName() {
        String nameList = input.inputFromUser();
    }

    private void play() {

    }

}
