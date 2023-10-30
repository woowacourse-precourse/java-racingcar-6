package racingcar;
import camp.nextstep.edu.missionutils.Console;
import racingcar.racingcarModel;
import racingcar.racingcarController;

import java.util.Iterator;

public class racingcarView {
    public void GetMembersAndTurn() {
        System.out.println(racingcarModel.INPUT_USERS);
        for ( String name : String.valueOf(Console.readLine()).split(",")) {
            racingcarController.IsNameAccurate(name);
            racingcarModel.members.put(name, 0);
        }
        System.out.println(racingcarModel.INPUT_TURNS);
        racingcarModel.turn = Integer.parseInt(Console.readLine());
    }
    public void StartRacing() {
        System.out.println(racingcarModel.RUN_RESULT);
        for (int i = 0; i < racingcarModel.turn; i++) {
            racingcarController.RaceIndividually();
        }
    }
    public static void printMemberStatus(String member) {
        System.out.print(member+racingcarModel.STATUS_COLONE);
        for (int i = 0; i < racingcarModel.members.get(member); i++) {
            System.out.print(racingcarModel.UPPER_DASH);
        }
        System.out.println();
    }
    public static void printResult() {
        System.out.print(racingcarModel.PRINT_WINNER);
        Iterator<String> keys = racingcarModel.members.keySet().iterator();
        while(keys.hasNext()){
            IsMaxValue(keys.next());
        }
    }
    public static void IsMaxValue(String member) {
        if (racingcarModel.members.get(member).equals(racingcarModel.maxScore)) {
            if (racingcarModel.winnerCnt > 0) {
                System.out.print(racingcarModel.SPOT);
            }
            System.out.print(racingcarModel.SPACE_BAR+member);
            racingcarModel.winnerCnt += 1;
        }
    }
}
