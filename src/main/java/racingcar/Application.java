package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import static racingcar.Production.*;
import static racingcar.Production.makeEmptyList;
import static racingcar.RacingGame.*;

public class Application {
    // TODO 프로그램 구현

    public static void main(String[] args) {
        List<String> gameStateUpdate = new ArrayList<String>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> racingCar = makeRacingCar(Console.readLine());

        // 자동차 이름이 5자를 넘어가면 오류 던지기
        for (String car : racingCar) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int trialNum = trialNumber(Console.readLine());

        List<String> gameSituation = makeEmptyList(racingCar.size());

        System.out.println("실행 결과");
        for (int i = 0; i < trialNum; i++) {
            List<Integer> RandomNumOfCar = implementMakeRandomNum(racingCar);
            gameStateUpdate = ifNumIsOver4(RandomNumOfCar, gameSituation);
            printRaceSituation(racingCar, gameStateUpdate);
        }

        // 최종 결과 계산하기 (누가 우승자인지)
        int[] finalDistance = calculateFinalDistance(gameStateUpdate);
        int maxDistance = judgeMaxNum(finalDistance);
        judgeWinner(maxDistance, racingCar, finalDistance);
    }

    static int[] calculateFinalDistance(List<String> gameResult) {
        int[] finalDistance = new int[gameResult.size()];

        for (int i = 0; i < gameResult.size(); i++) {
            // 각각의 차가 최종적으로 얼마나 갔는지 그 거리를 담은 리스트
            finalDistance[i] = gameResult.get(i).length();
        }
        return finalDistance;
    }

    static int judgeMaxNum(int[] raceResult) {
        // 가장 멀리 간 거리를 계산
        return Arrays.stream(raceResult).max()
                .orElse(-1);
    }

    static void judgeWinner(int max, List<String> racingcarList, int[] distanceList) {
        // 최종 우승자 출력
        List<String> winnerList = new ArrayList<String>();

        for (int i = 0; i < racingcarList.size(); i++) {
            if (distanceList[i] == max) winnerList.add(racingcarList.get(i));
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if (i != winnerList.size()-1) System.out.print(", ");
        }
    }
}

