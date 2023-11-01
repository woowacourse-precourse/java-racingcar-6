package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

class Cars {
    public static String[] carNames;
    public static int[] carDistance;

    public static void readyCars(String[] inputCarNames) {
        int carNum = inputCarNames.length;
        carNames = new String[carNum];
        carDistance = new int[carNum];

        System.arraycopy(inputCarNames, 0, carNames, 0, carNum);
    }
}

class Round {

    private static int nowRound = 0;
    public static int finalRound;

    public Round(int inputNum) {
        this.finalRound = inputNum;
    }

    public static boolean isContinue() {
        nowRound ++;
        return nowRound <= finalRound;
    }
}


public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputCarNames = Console.readLine().split(",");
        Cars.readyCars(inputCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        Round.finalRound = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        while (Round.isContinue()) {

        }

        System.out.print("최종 우승자 : ");
    }
}
