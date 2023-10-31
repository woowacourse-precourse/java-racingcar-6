package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.entity.RacingCar;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarController {
    public RacingCarController(String inputCarNameList, String iterStr) {
        int iter = Integer.parseInt(iterStr);   // 시도할 횟수

        String[] carNameList = inputCarNameList.split(",");
        List<RacingCar> racingCarList = new ArrayList<>();

        for (int i = 0; i < carNameList.length; i++) {
            racingCarList.add(new RacingCar(carNameList[i]));
        }

        // 게임 시작(작동)
        startGame(racingCarList, iter);
    }

    // 확률 계산 및 판단
    private void calculateMovement(RacingCar racingCar) {
        int randNum = Randoms.pickNumberInRange(0, 9);

        if (randNum >= 4) {   // 전진
            racingCar.plusProgress();
        }
    }

    // 게임 진행
    public void startGame(List<RacingCar> racingCarList, int iter) {
        // 시도 횟수만큼 반복
        for (int i = 0; i < iter; i++) {
            for (int carNum = 0; carNum < racingCarList.size(); carNum++) {
                calculateMovement(racingCarList.get(carNum));
            }
        }
    }
}
