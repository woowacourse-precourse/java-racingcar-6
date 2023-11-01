package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.dto.CarOutputRequestDto;
import racingcar.dto.CarWinnerDto;
import racingcar.service.CarService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutPutView;
import utils.string.StringUtils;
import utils.validator.Validator;

public class Controller {
    private final RacingGameService racingGameService;
    private final CarService carService;
    private final Validator validator = new Validator();

    private Long racingGameId = 1L;
    private Long carId = 1L;

    public Controller(RacingGameService racingGameService, CarService carService) {
        this.racingGameService = racingGameService;
        this.carService = carService;
    }

    public RacingGame initRacingGame() {
        List<Long> carsIdList = getCarsIdList();
        int gameCount = getGameCount();
        RacingGame racingGame = racingGameService.createNewGame(carsIdList, gameCount, racingGameId);
        racingGameService.join(racingGame);
        racingGameId += 1;
        return racingGame;
    }

    public void play(Long racingGameId) {
        RacingGame racingGame = racingGameService.findGameById(racingGameId);
        List<Long> carsIdList = racingGame.getCarsIdList();
        OutPutView.printResultMessage();

        do {
            moveCarsForwardOrNotByRandomNumber(carsIdList);
            OutPutView.printScore(mapToCarRequestDtoList(carsIdList));
            racingGameService.addGameCount(racingGame.getId());
        } while (!racingGameService.isGameFinish(racingGame.getId()));

        printFinalWinner(racingGameId);
    }

    private void printFinalWinner(Long racingGameId) {
        List<Long> winners = racingGameService.getWinningCarsId(racingGameId);
        OutPutView.printFinalWinner(mapToCarWinnersDtoList(winners));
    }

    private List<CarWinnerDto> mapToCarWinnersDtoList(List<Long> winners) {
        return winners.stream()
                .map(c -> new CarWinnerDto(carService.findCarById(c).getName()))
                .collect(Collectors.toList());
    }

    private List<CarOutputRequestDto> mapToCarRequestDtoList(List<Long> carsIdList) {
        return carsIdList.stream()
                .map(c -> new CarOutputRequestDto(carService.findCarById(c).getName(),
                        carService.findCarById(c).getPosition()))
                .collect(Collectors.toList());
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
        validator.checkGameCountInput(gameCountString);
        return StringUtils.parseNumberOfCount(gameCountString);
    }

    private List<Long> getCarsIdList() {
        String nameString = getNameStringByUserInput();
        validator.checkCarNamesInput(nameString);
        List<String> carNameList = StringUtils.parseCarNames(nameString);
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
