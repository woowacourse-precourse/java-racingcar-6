package racingcar;

import racingcar.domain.controller.RacingController;
import racingcar.domain.service.ClientService;
import racingcar.domain.service.RacingService;

public class Application {

    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        RacingService racingService = new RacingService();
        RacingController racingController = new RacingController(clientService, racingService);
        racingController.run();
    }
}
