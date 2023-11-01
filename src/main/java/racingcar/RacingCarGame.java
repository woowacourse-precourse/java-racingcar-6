package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingCarGame {
    public static void play(List<String> carNames, int tryCount){
        for (int i = 0; i < tryCount; i++){
            printRoundResult(i + 1, carNames);
        }
    }

    public static void printRoundResult(int round, List<String> carNames){
        System.out.println("\n" + round + "회 경주 결과:");

        for (String carName : carNames){
            printCarMove(carName);
        }
        System.out.println();
    }

    private static void printCarMove(String carName){
        if(Randoms.pickNumberInRange(0,9) >= 4){
            System.out.print(carName + " : -");
        } else {
            System.out.print(carName + " : ");
        }
    }
}


