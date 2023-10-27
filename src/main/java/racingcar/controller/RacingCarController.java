package racingcar.controller;

import racingcar.model.PlayerInputManage;
import racingcar.model.RacingCarGameManage;
import racingcar.model.RacingCarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RacingCarController {

    private InputView inputView;
    private OutputView outputView;
    private PlayerInputManage playerInputManage;
    private RacingCarGameManage racingCarGame;
    private RacingCarStatus status;

    private String carNameList;
    private String tryCount;

    private ArrayList<String> playerCarNameList;
    private ArrayList<String> winnerList;
    private HashMap<String, Integer> playerRacingCarMap;


    public RacingCarController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingCarGame = new RacingCarGameManage();
        status = RacingCarStatus.STOP;
    }

    public void Game() {
        carNameList = inputView.inputCarName();
        tryCount = inputView.inputTryCount();
        outputView.outputResultMessage();

        playerInputManage = new PlayerInputManage(carNameList, tryCount);
        playerCarNameList = playerInputManage.getPlayerCarNameList();

        play(Integer.parseInt(tryCount));
    }

    private void play(int tryCount) {
        for(int tryGame = 1;  tryGame <= tryCount; tryGame++) {
            playerRacingCarMap = racingCarGame.getPlayerRandomNumber(playerCarNameList);
            printResult();
        }
        winnerList = getWinner(playerRacingCarMap);
        outputView.outputWinnerMessage(winnerList);
    }

    private void printResult() {
        for(String carName : playerCarNameList) {
            outputView.outputRacingCarGameStatus(carName, playerRacingCarMap.get(carName));
        }
        outputView.outputEmptyLine();
    }

    private ArrayList<String> getWinner(HashMap<String, Integer> playerRacingCarMap) {
        winnerList = new ArrayList<>();
         playerRacingCarMap.forEach((key, value) -> {
            if(Objects.equals(value, playerRacingCarMap.values().stream().max(Integer::compare).get())) {
                winnerList.add(key);
            }
         }
        );
        return winnerList;

    }
}
