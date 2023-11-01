package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.Iterator;

public class RacingcarView {
    public void GetMembers() {
        System.out.println(RacingcarModel.INPUT_USERS);
        String names = DealWithExceptionCase.IsNameValuable(Console.readLine());
        for (String name : names.split(",")) {
            RacingcarModel.members.put(name, 0);
        }
    }
    public void GetTurn() {
        System.out.println(RacingcarModel.INPUT_TURNS);
        DealWithExceptionCase.IsTurnTypeInteger(Console.readLine());
    }
    public void StartRacing() {
        System.out.println();
        System.out.println(RacingcarModel.RUN_RESULT);
        for (int i = 0; i < RacingcarModel.turn; i++) {
            RacingcarController.RaceIndividually();
        }
    }

    public static void printMemberStatus(String member) {
        System.out.print(member+ RacingcarModel.STATUS_COLONE);
        for (int i = 0; i < RacingcarModel.members.get(member); i++) {
            System.out.print(RacingcarModel.UPPER_DASH);
        }
        System.out.println();
    }

    public static void printResult() {
        System.out.print(RacingcarModel.PRINT_WINNER);
        Iterator<String> keys = RacingcarModel.members.keySet().iterator();
        while(keys.hasNext()){
            IsMaxValue(keys.next());
        }
    }

    public static void IsMaxValue(String member) {
        if (RacingcarModel.members.get(member).equals(RacingcarModel.maxScore)) {
            if (RacingcarModel.winnerCnt > 0) {
                System.out.print(RacingcarModel.SPOT);
            }
            System.out.print(RacingcarModel.SPACE_BAR+member);
            RacingcarModel.winnerCnt += 1;
        }
    }

}
