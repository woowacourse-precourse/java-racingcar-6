package racingcar;
import java.util.stream.IntStream;

import static racingcar.service.RacingGameService.createRacingCars;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.model.Cars;
import racingcar.view.RacingGameView;
public class RacingGameManager {
    private final RacingGameView view;
    private final RacingGameService service;
    private final RacingGameController controller;

    public RacingGameManager(){
        this.view = new RacingGameView();
        this.service = new RacingGameService();
        this.controller = new RacingGameController();
    }
    public void play(){
        view.printGameStartMessage();
        Cars userCars = createRacingCars(controller.getInputCarNames());
        view.printRepeatCountMessage();
        view.printExecutionMessage();
        IntStream.range(0, controller.getInputRepeatCount()).forEach(j -> {
            IntStream.range(0, userCars.getCarsLength()).mapToObj(i ->
                    userCars.getCars().get(i)).forEach(service::randomNumber);
            view.printGameProcessingMessage(userCars);
        });
        view.printGameResultMessage(service.getWinner(userCars));
    }
}
