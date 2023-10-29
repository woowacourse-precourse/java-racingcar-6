package racingcar.controller;

import racingcar.entity.GameCount;
import racingcar.generator.RandomNumberGenerator;

public class GameController {
    public void GameStart() {
        GameCount gameCounter = new GameCount();
        gameCounter.MakeWinCountList();
        int GameCount= gameCounter.getWinCountListSize();
        for(int i=0;i<GameCount;i++){
        }
    }
}
