package racingcar.controller;

import racingcar.dto.request.ActionCountDto;
import racingcar.dto.request.CarNamesDto;
import racingcar.dto.response.WinnersDto;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(
            final InputView inputView,
            final OutputView outputView,
            final RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void runGame() {
        CarNamesDto carNamesDto = inputView.carNameRequest();
        ActionCountDto actionCountDto = inputView.actionCountRequest();

        racingService.createCars(carNamesDto);
        startRacing(actionCountDto);

        printFinalWinner();
    }

    public void startRacing(ActionCountDto actionCountDto) {
        outputView.announceGameResult();
        Integer iteration = actionCountDto.getActionCount();
        for(int i = 0; i < iteration; i++) {
            racingService.action();
            outputView.writeMovement(racingService.findAllCars());
        }
    }

    public void printFinalWinner() {
        WinnersDto winnersDto = racingService.findWinners();
        outputView.writeFinalWinner(winnersDto);
    }
}
