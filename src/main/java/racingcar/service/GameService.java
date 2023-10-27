package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.printer.GameGuidePrinter;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final GameGuidePrinter gameGuidePrinter;

    public GameService() {
        this.gameGuidePrinter = new GameGuidePrinter();
    }

    public void startGame() {
        gameGuidePrinter.getCarNameInputMessage();
        String carList = carNameInput();
        String[] cars = groupCarsByName(carList);
        gameGuidePrinter.getTryCountMessage();
    }

    private String carNameInput() {
        String carList = Console.readLine();
        return carList;
    }

    private String[] groupCarsByName(String carList) {
        String[] cars = carList.split(",");
        return cars;
    }
}