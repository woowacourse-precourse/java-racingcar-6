package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.util.RacingCarVariables;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    public void play() {
        RacingCarService racingCarService = new RacingCarService();

        // 자동자 이름 입력
        System.out.println(RacingCarVariables.getInputCarNameSentence());
        String carNameString = Console.readLine();

        String[] splitCarNames = carNameString.split(",");
        // 자동차 이름 길이 유효성 검사
        for (String carName : splitCarNames) {
            checkValidation(carName);
        }

        // 게임에 참여한 자동차 정보 저장
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String carName : splitCarNames) {
            RacingCar racingCar = racingCarService.saveRacingCar(carName);
            racingCarList.add(racingCar);
        }

        // 시도할 횟수 입력
        System.out.println(RacingCarVariables.getTryCountSentence());
        int tryCount = Integer.parseInt(Console.readLine());

        // 레이싱 게임 시작
        int realPlayCount = 0;
        System.out.println(RacingCarVariables.getResultSentence());
        while (realPlayCount < tryCount) {
            realPlayCount++;
            racingCarService.playGame(racingCarList); // 각 차수별 게임 진행
        }

        printWinners(racingCarService, racingCarList); // 우승자 발표
    }

    private void checkValidation(String carNameString) {
        if (carNameString.length() >= 6)
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
    }

    private static void printWinners(RacingCarService racingCarService, List<RacingCar> racingCarList) {
        List<String> winnerList = racingCarService.getWinner(racingCarList);

        StringBuilder stringBuilder = new StringBuilder(RacingCarVariables.getWinnerSentence());
        for (int i = 0; i < winnerList.size(); i++) {
            String winnerName = winnerList.get(i);
            if (i == (winnerList.size()-1)) {
                stringBuilder.append(winnerName);
            }
            else {
                stringBuilder.append(winnerName).append(", ");
            }
        }
        System.out.println(stringBuilder.toString());
    }

}
