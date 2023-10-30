package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarController {

    private final RacingCarService racingCarService;

    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarService racingCarService, RacingCarView racingCarView) {
        this.racingCarService = racingCarService;
        this.racingCarView = racingCarView;
    }

    public void initCar() {
        racingCarView.carNameListInputPrint();
        racingCarService.createCarList();
    }

    public int setCount() {
        racingCarView.readCountPrint();

        return racingCarService.readCount();
    }

    public void playGame(int count) {
        for (int i = 0; i < count; i++) {
            CarList carList = racingCarService.checkCarListMove();
            racingCarView.gameProgressPrint(carList);
        }
    }

    public void getWinner() {
        List<String> winnerList = racingCarService.getWinner();
        racingCarView.printWinner(winnerList);
    }

}
