package racingcar.controller;

import racingcar.entity.GameCount;
import racingcar.generator.ListLengthGenerator;
import racingcar.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static racingcar.entity.Participantes.InputParticipantes;

public class GameController {
    public void GameStart(List<String> participantes) {
        CarLocationController carLocationController = new CarLocationController();
        GameCount gameCount = new GameCount(participantes); // 객체를 올바르게 생성
        List<Integer> wincountList = gameCount.getWincount();
        System.out.println(wincountList);
        int t = ListLengthGenerator.count(participantes);

        for (int i = 0; i < t; i++) {
            int n = wincountList.get(i);
            carLocationController.forward(n);
            wincountList.set(i, n);
        }
    }
}
