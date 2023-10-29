package racingcar;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RunRacing {
    static HashMap<String, Integer> members = new HashMap<String, Integer>();
    static int turn = 0;

    public static void run() {
        RunRacing GetMembersAndTurn = new RunRacing();
        RunRacing StartRacing = new RunRacing();
        System.out.println("되냐?");
        GetMembersAndTurn.GetMembersAndTurn();
        StartRacing.StartRacing();
        System.out.println(members);
    }
    public void GetMembersAndTurn() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        for ( String name : String.valueOf(Console.readLine()).split(",")) {
            members.put(name, 0);
        }
        System.out.println("시도할 회수는 몇회인가요?");
        turn = Integer.parseInt(Console.readLine());
    }
    public void StartRacing() {
        System.out.println("실행 결과");
        for (int i = 0; i < turn; i++) {
            RaceIndividually();
        }
    }
    public void RaceIndividually() {
        Iterator<String> keys = members.keySet().iterator();
        while(keys.hasNext()){
            MoveForward(keys.next());
        }
    }
    public void MoveForward(String member) {
        int pickedNum = Randoms.pickNumberInRange(0,9);
        if (pickedNum >= 4) {
            members.put(member, members.get(member)+1);
        }
    }

}
