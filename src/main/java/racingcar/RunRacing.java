package racingcar;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RunRacing {
    static HashMap<String, Integer> members = new HashMap<String, Integer>();
    static int turn = 0;

    public static void run() {
        RunRacing GetMembersAndTurn = new RunRacing();
        System.out.println("되냐?");
        GetMembersAndTurn.GetMembersAndTurn();
    }
    public void GetMembersAndTurn() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        for ( String name : String.valueOf(Console.readLine()).split(",")) {
            members.put(name, 0);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        turn = Integer.parseInt(Console.readLine());
        System.out.println(members);
        System.out.println(turn);
    }
}
