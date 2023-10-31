package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.entity.RacingCar;

public class RacingCarController {

    public RacingCarController(String inputCarNameList, String iterStr) {
        int iter = Integer.parseInt(iterStr);   // 시도할 횟수

        String[] carNameList = inputCarNameList.split(",");
        List<RacingCar> racingCarList = new ArrayList<>();

        for (int i = 0; i < carNameList.length; i++) {
            racingCarList.add(new RacingCar(carNameList[i]));
        }

        // 게임 시작(작동)
        startRacingCarGame(racingCarList, iter);
    }

    public void startRacingCarGame(List<RacingCar> racingCarList, int iter) {

    }
}
