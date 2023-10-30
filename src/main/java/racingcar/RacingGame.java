package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.Production.*;

public class RacingGame {

    static List<String> ifNumIsOver4(List<Integer> randomNumList, List<String> gameSituation) {
        // randomNumList 를 받아서 4 이상인지 판단 후, repeat 함수 호출해서 gameSituation 리스트에 반영하기
        int listLength = randomNumList.size();
        List<String> newGameSituation = makeEmptyList(listLength);

        for (int i = 0; i < randomNumList.size(); i++) {
            boolean MoveOrStop = repeatIfNumIsOver4(randomNumList.get(i));
            if (MoveOrStop) {
                newGameSituation = move(gameSituation, i);
            }
        }

        return newGameSituation;
    }

    static boolean repeatIfNumIsOver4(int randomNum) {
        // randomNum 이 4 이상이면 return true
        return randomNum >= 4;
    }

    static List<String> move(List<String> gameSituation, int index) {
        // MoveOrStop이 true 인 것만 gameSitutation[index] 에 - 추가해서 업데이트하기
        gameSituation.set(index, gameSituation.get(index)+"-");

        return gameSituation;
    }

    static void printRaceSituation(List<String> carList, List<String> gameSituation) {
        // 경주 현황 출력하기
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i)+" : "+gameSituation.get(i));
        }
        System.out.println();
    }

}
