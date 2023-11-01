package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameStarter {
    public static void gameIniter(List<Car> cars, Integer round){
        System.out.println("\n" +
                "실행 결과");
        for(int i=0; i<round; i++){
            RaceStarter.startRace(cars);
        }
        CheckScore.compareScore(cars);
    }

}
