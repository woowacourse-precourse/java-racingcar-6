package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RaceResult;

import java.util.ArrayList;

public class RacingView {
    // 레이싱 게임의 출력을 담당
    private static final String PLAY_RESULT = "실행 결과";

    public static void viewPlay() {
        System.out.println(PLAY_RESULT);
    }
    public static void viewRace(RaceResult raceResult) {
        printView(raceResult.raceToString());
        printView("");
    }

    public static void viewWinner(String winner){
        printView(winner);
    }

    private static void printView(String view){
        System.out.println(view);
    }
}
