package racingcar;

import racingcar.controller.ProgressController;
import racingcar.controller.InitController;
import racingcar.dto.GameSettingDto;
import racingcar.repository.CarRepository;
import racingcar.service.InputService;
import racingcar.service.RacingService;

public class Application {
    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        InputService inputService = new InputService(carRepository);
        InitController initController = new InitController(inputService);
        GameSettingDto gameSettingDto = initController.gameInit();
        RacingService racingService = new RacingService(gameSettingDto.getCars(), gameSettingDto.getTimes(), carRepository);
        ProgressController progressController = new ProgressController(racingService);
        progressController.gameProgress();
    }
}
