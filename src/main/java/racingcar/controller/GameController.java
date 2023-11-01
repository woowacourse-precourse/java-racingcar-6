package racingcar.controller;

import racingcar.constant.GameViewConstant;
import racingcar.model.CarDto;
import racingcar.model.GameDto;
import racingcar.view.GameView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private GameDto gameDto;
    public void start() {
        List<CarDto> cars = initializeCars();
        int raceCount = getRaceCount();
        gameDto = new GameDto(cars);

        System.out.println(GameViewConstant.RACE_RESULT);
        startRace(raceCount);
    }

    private List<CarDto> initializeCars() {
        return Arrays.stream(GameView.carNameView().split(","))
                .map(CarDto::new)
                .collect(Collectors.toList());
    }

    private int getRaceCount() {
        return GameView.gameCountView();
    }

    private void startRace(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            gameDto.run();
            GameView.resultView(gameDto.getCars());
        }
    }

    public List<CarDto> getWinners() {
        int maxPosition = gameDto.getCars().stream().mapToInt(CarDto::getDistance).max().orElse(0);
        return gameDto.getCars().stream().filter(car -> car.getDistance() == maxPosition).collect(Collectors.toList());
    }
}
