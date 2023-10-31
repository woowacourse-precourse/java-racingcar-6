package racingcar.controller;

import racingcar.entity.GameCount;
import racingcar.generator.ListLengthGenerator;

import java.util.List;


public class GameController {
    public int[] win;

    public void initializeWinArray(int size) {
        win = new int[size];
        for (int i = 0; i < size; i++) {
            win[i] = 0;
        }
    }
    public void GameStart(List<String> participantes) {
        initializeWinArray(participantes.size());

        CarLocationController carLocationController = new CarLocationController();
        GameCount gameCount = new GameCount(participantes);
        Integer[] wincountList = gameCount.getWincount().toArray(new Integer[0]); // List를 배열로 변환


        for (int i = 0; i <  participantes.size(); i++) {
            int n = wincountList[i];
            n = carLocationController.forward(n);
            wincountList[i] = n; // 배열로 변환한 리스트의 값을 업데이트
            win[i] += wincountList[i];
        }
    }

}
