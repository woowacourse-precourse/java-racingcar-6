package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.model.CarService;
import racingcar.model.Message;

public class Input {
    private final CarService service = CarService.getInstance();
    private final Message message = Message.getInstance();

    public void inputName() {
        service.name = readLine();
        if(service.name == null) {
            throw new IllegalArgumentException(message.INPUT_WRONG_EXCEPTION);
        }
    }

    public void inputEpoch() {
        service.epoch = Integer.parseInt(readLine());
    }
}
