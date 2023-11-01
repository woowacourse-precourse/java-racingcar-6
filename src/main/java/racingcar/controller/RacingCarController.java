package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.entity.RacingCar;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarController {
    List<RacingCar> racingCarList = new ArrayList<>();
    int iter;   // 시도할 횟수

    public RacingCarController(String inputCarNameList, String iterStr) {
        this.iter = Integer.parseInt(iterStr);
        String[] carNameList = inputCarNameList.split(",");

        for (int i = 0; i < carNameList.length; i++) {
            // 자동차 이름이 5자 이하가 아닌 경우 Exception 발생
            if (carNameList[i].length() > 5) {
                throw new IllegalArgumentException();
            }

            this.racingCarList.add(new RacingCar(carNameList[i]));
        }
    }

    // 최종 우승자 판단 및 출력
    public void printWinner() {
        String winner = "";
        int maxLength = -1;

        for (int carNum = 0; carNum < racingCarList.size(); carNum++) {
            RacingCar currentCar = racingCarList.get(carNum);
            int currentLength = currentCar.getProgress().length();

            if (maxLength < currentLength) {
                // 우승자 교체
                maxLength = currentLength;
                winner = currentCar.getCarName();
            } else if (maxLength == currentLength) {
                // 공동 우승자 추가
                winner += ", " + currentCar.getCarName();
            }
        }

        // 우승자 출력
        System.out.println("최종 우승자 : " + winner);
    }

    // 실행 결과 출력
    public void printResult() {
        for (int carNum = 0; carNum < racingCarList.size(); carNum++) {
            System.out.println(
                    racingCarList.get(carNum).getCarName() + " : " + racingCarList.get(carNum).getProgress());
        }
        System.out.println();
    }

    // 확률 계산 및 판단
    public void calculateMovement(RacingCar racingCar) {
        int randNum = Randoms.pickNumberInRange(0, 9);

        if (randNum >= 4) {   // 전진
            racingCar.plusProgress();
        }
    }

    // 게임 진행
    public void startGame() {
        System.out.println("\n실행 결과");

        // 시도 횟수만큼 반복
        for (int i = 0; i < iter; i++) {
            // 각 자동차 전진 OR 멈춤 수행
            for (int carNum = 0; carNum < racingCarList.size(); carNum++) {
                calculateMovement(racingCarList.get(carNum));
            }

            // 실행 결과 출력
            printResult();
        }

        // 최종 우승자 출력
        printWinner();
    }
}
