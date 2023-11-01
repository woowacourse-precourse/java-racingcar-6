package racingcar.controller;


import racingcar.model.Car;
import racingcar.model.GameModel;
import racingcar.view.GameView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static racingcar.constant.Constant.*;
import static racingcar.constant.ErrorMessage.*;


public class GameController {
    private GameModel gameModel;


    public void play() {
        List<String> carNameList = gameModel.getCarName();
        List<Car> carList = carNameList.stream()
                .map(Car::new)
                .toList();

        int rounds = gameModel.getRounds();
    }
}