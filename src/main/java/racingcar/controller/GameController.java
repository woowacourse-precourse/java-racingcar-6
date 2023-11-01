package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Judgement;
import racingcar.model.RunGame;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private Input inputController;
    private Output outputController;
    private List<String> carNameList;
    private List<Car> carList = new ArrayList<>();
    private List<Car> winnerList;
    private Judgement judgement = new Judgement();
    private RunGame runGame = new RunGame();
    private int tryCount;

    private void initCarNameList() {
        String inputCarString = inputController.inputNames();
        carNameList = inputController.stringToList(inputCarString);
    }
}
