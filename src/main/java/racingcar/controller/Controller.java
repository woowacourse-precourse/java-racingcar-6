package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.dto.CarOutputRequestDto;
import racingcar.service.CarService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutPutView;
import utils.Parser;

public class Controller {
    private final RacingGameService racingGameService;
    private final CarService carService;

    private Long racingGameId = 1L;
    private Long carId = 1L;

    public Controller(RacingGameService racingGameService, CarService carService) {
        this.racingGameService = racingGameService;
        this.carService = carService;
    }

    public void initRacingGame() {
        List<Long> carsIdList = getCarsIdList();
        int gameCount = getGameCount();
        RacingGame racingGame = racingGameService.createNewGame(carsIdList, gameCount, racingGameId);
        racingGameService.join(racingGame);
        racingGameId += 1;
        play(racingGame);
    }

    private void play(RacingGame racingGame) {
        List<Long> carsIdList = racingGame.getCarsIdList();
        while (!racingGameService.isGameFinish(racingGame.getId())) {
            moveCarsForwardOrNotByRandomNumber(carsIdList);
            OutPutView.printScore(mapToCarRequestDto(carsIdList));
            racingGameService.addGameCount(racingGame.getId());
        }
    }

    private List<CarOutputRequestDto> mapToCarRequestDto(List<Long> carsIdList) {
        List<CarOutputRequestDto> carDtoList = new ArrayList<>();
        for (Long id : carsIdList) {
            Car findCar = carService.findCarById(id);
            carDtoList.add(new CarOutputRequestDto(findCar.getName(), findCar.getPosition()));
        }
        return carDtoList;
    }

    private void moveCarsForwardOrNotByRandomNumber(List<Long> carsIdList) {
        for (Long id : carsIdList) {
            if (racingGameService.isMoveableForwardByRandomNumber()) {
                carService.moveCarToForward(id);
            }
        }
    }

    private int getGameCount() {
        String gameCountString = getGameCountStringByUserInput();
        return Parser.parseNumberOfCount(gameCountString);
    }

    private List<Long> getCarsIdList() {
        String nameString = getNameStringByUserInput();
        List<String> carNameList = Parser.parseCarNames(nameString);
        return saveCarsInRepository(carNameList);
    }

    private List<Long> saveCarsInRepository(List<String> carNameList) {
        List<Long> carIdList = new ArrayList<>();
        for (String s : carNameList) {
            carService.join(new Car(s, carId));
            carIdList.add(carId);
            carId += 1;
        }
        return carIdList;
    }

    private String getGameCountStringByUserInput() {
        InputView.requestNumberOfGameCount();
        return Console.readLine();
    }

    private String getNameStringByUserInput() {
        InputView.requestCarName();
        return Console.readLine();
    }
}
