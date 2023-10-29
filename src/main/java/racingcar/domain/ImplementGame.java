package racingcar.domain;

import racingcar.domain.CreateMoveMap;
import racingcar.domain.UserInput;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Scanner;
public class ImplementGame {
    UserInput userInput = new UserInput();
    CreateMoveMap createMoveMap = new CreateMoveMap();

    public Map<String, Integer> playGame(){
        List<String> carList = userInput.askCar();
        int gameNumber = userInput.askNumberGame();
        System.out.println("경기 실행 결과:");
        Map<String, Integer> numMoveMap = createMoveMap.initMap(carList);
        for (int i = 0; i < gameNumber; i++){
            numMoveMap = createMoveMap.decideIncMove(carList, numMoveMap);
        }
        return numMoveMap;
    }

}
