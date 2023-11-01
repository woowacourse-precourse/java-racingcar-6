package racingcar.controller;

import racingcar.entity.GameCount;
import racingcar.generator.ListLengthGenerator;
import racingcar.generator.RandomNumberGenerator;
import racingcar.generator.WinArrayGenerator;

import java.util.List;

import static racingcar.generator.WinArrayGenerator.win;


public class GameController {
    WinArrayGenerator winArrayGenerator=new WinArrayGenerator();
    public void GameStart(List<String> participantes) {
        winArrayGenerator.initializeWinArray(participantes.size());
        CarLocationController carLocationController = new CarLocationController();
        GameCount gameCount = new GameCount(participantes);
        Integer[] wincountList = gameCount.getWincount().toArray(new Integer[0]); // List를 배열로 변환
        int t = ListLengthGenerator.count(participantes);


        for (int i = 0; i < t; i++) {
            int n = wincountList[i];
            int r= RandomNumberGenerator.RandomNumber();
            n = carLocationController.forward(n,r);
            wincountList[i] = n; // 배열로 변환한 리스트의 값을 업데이트
            win[i] += wincountList[i];
        }
    }
}
