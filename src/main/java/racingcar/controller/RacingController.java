package racingcar.controller;

import racingcar.domain.CarsDto;
import racingcar.domain.Client;
import racingcar.domain.ResultDto;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RacingService racingService;

    public void run() {
        CarsDto carsDto = createCarsDto();
        Client client = createClientDto();
        racingService = new RacingService(carsDto, client);
        ResultDto result = racingService.playCarRacing();
        outputView.printResult(result);
    }

    private CarsDto createCarsDto() {
        outputView.beforeInputCarNames();
        String inputtedCarNames = inputView.inputCarNames();
        return new CarsDto(inputtedCarNames);
    }

    private Client createClientDto() {
        outputView.beforeInputTryNumber();
        String inputtedTryNumber = inputView.inputTryNumber();
        return new Client(inputtedTryNumber);
    }
}