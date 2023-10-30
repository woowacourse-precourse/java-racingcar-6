package racingcar.controller;

import racingcar.entity.GameCount;
import racingcar.generator.RandomNumberGenerator;

import java.util.List;

import static racingcar.entity.Participantes.InputParticipantes;

public class GameController {
    public void GameStart() {
        CarLocationController carLocationController=new CarLocationController();
        GameCount gameCount = new GameCount();
        gameCount.MakeWinCountList();

        List<Integer> wincountList = gameCount.getWincount();

        for(int i=0; i<gameCount.getWincount().size();i++){
            int winCount = wincountList.get(i);
            carLocationController.forward(winCount);
        }
    }
}

