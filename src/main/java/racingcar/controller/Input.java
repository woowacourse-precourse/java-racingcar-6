package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.model.CarService;

public class Input {
    private final CarService service = CarService.getInstance();

    public void inputName() {
        service.name = readLine();
    }

    public void inputEpoch() {
        service.epoch = Integer.parseInt(readLine());
    }
}
