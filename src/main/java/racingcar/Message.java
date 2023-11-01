package racingcar;

import java.util.ArrayList;

public class Message {
    public static void NameInputMsg() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void RaceTryTimeInputMsg() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void raceInterimResultMsg(String msg) {
        System.out.println(msg);
    }

    public static void finalWinnerMsg(ArrayList<String> winnerNameList) {
        String winnerNameStr = String.join(",", winnerNameList);
        System.out.println(String.format("최종 우승자 : %s", winnerNameStr));
    }
}
