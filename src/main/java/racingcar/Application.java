package racingcar;

import racingcar.controller.ProgressController;
import racingcar.controller.InitController;
import racingcar.dto.InitDto;
import racingcar.repository.CarRepositoryImpl;
import racingcar.repository.Repository;
import racingcar.service.InputService;
import racingcar.service.InputServiceImpl;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;

public class Application {
    public static void main(String[] args) {
        Repository repository = new CarRepositoryImpl();
        InputService inputService = new InputServiceImpl(repository);

        InitController initController = new InitController(inputService);
        InitDto initDto = initController.gameInit();

        RacingService racingService = new RacingServiceImpl(initDto.getCars(), initDto.getTimes(), repository);

        ProgressController progressController = new ProgressController(racingService);
        progressController.gameProgress();
    }
}
