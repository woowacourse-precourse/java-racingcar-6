package racingcar.controller;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.ResultRepository;
import racingcar.service.RacingService;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;
import racingcar.vo.TryTime;

import java.util.List;

public class RacingController {
    private RacingService racingService = new RacingService(CarRepository.getInstance(), ResultRepository.getInstance());

    public void run() {
        setGame();
        playGame();
        endGame();
    }

    public void endGame() {
        OutputMessage.printResultOutputMessage(racingService.chooseWinner());
    }

    public void playGame() {
        TryTime tryTime = InputMessage.printTryTimesInputMessage();
        OutputMessage.printPlayOutputMessage();

        for (int i = 0; i < tryTime.getTime(); i++) {
            OutputMessage.printRacingProgressOutputMessage(racingService.progressRacing());
        }
    }

    public void setGame() {
        List<String> carNames = InputMessage.printCarNameInputMessage();
        racingService.initializeGame(carNames);
    }
}
