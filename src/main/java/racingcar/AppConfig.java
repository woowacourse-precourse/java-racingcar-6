package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.repository.MemoryRacingcarRepository;
import racingcar.service.RacingcarService;
import racingcar.service.RacingcarServiceImpl;
import racingcar.view.ReaultView;

public class AppConfig {

    public RacingcarService racingcarService() {
        return new RacingcarServiceImpl(new MemoryRacingcarRepository());
    }

    public RacingcarController racingcarController() {
        RacingcarService racingcarService = racingcarService();
        ReaultView reaultView = new ReaultView();
        return new RacingcarController(racingcarService, reaultView);
    }

}
