//package racingcar;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Iterator;
//import camp.nextstep.edu.missionutils.Console;
//import camp.nextstep.edu.missionutils.Randoms;
//
//public class RunRacing {
//    static Map<String, Integer> members = new LinkedHashMap<String, Integer>();
//    static int turn = 0;
//    static int winnerCnt = 0;
//
//    public static void run() {                              // controller
//        RunRacing GetMembersAndTurn = new RunRacing();
//        RunRacing StartRacing = new RunRacing();
//        RunRacing GetResult = new RunRacing();
//
//        GetMembersAndTurn.GetMembersAndTurn();
//        StartRacing.StartRacing();
//        GetResult.GetResult();
//    }
//    public void IsNameAccurate(String name) {              // controller
//        if (name.length() > 5)
//            throw new IllegalArgumentException();
//    }
//    public void GetMembersAndTurn() {
//        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"); // view
//        for ( String name : String.valueOf(Console.readLine()).split(",")) {
//            IsNameAccurate(name);                         // controller
//            members.put(name, 0);                         // view
//        }
//        System.out.println("시도할 회수는 몇회인가요?");     // view
//        turn = Integer.parseInt(Console.readLine());     // view
//    }
//    public void StartRacing() {
//        System.out.println("실행 결과");                  // view
//        for (int i = 0; i < turn; i++) {
//            RaceIndividually();
//        }
//    }
//    public void RaceIndividually() {                    // controller
//        Iterator<String> keys = members.keySet().iterator();
//        while(keys.hasNext()){
//            MoveForward(keys.next());
//        }
//        System.out.println();
//    }
//    public void MoveForward(String member) {            // controller
//        int pickedNum = Randoms.pickNumberInRange(0,9);
//        if (pickedNum >= 4) {
//            members.put(member, members.get(member)+1);
//        }
//        System.out.print(member+" : ");                 // 이거는 함수로 하나 분리를 하자 view > printMemberStatus()
//        for (int i = 0; i < members.get(member); i++) { // view > printMemberStatus()
//            System.out.print("-");
//        }
//        System.out.println();                           // view > printMemberStatus()
//    }
//    static int maxScore = 0;
//    public void GetResult() {
//        Iterator<String> keys = members.keySet().iterator();
//        Collection<Integer> values = members.values();
//
//        maxScore = Collections.max(values);             // controller > GetMaxValues()
//        System.out.print("최종 우승자 :");                // view > printResult()
//        while(keys.hasNext()){                          // view > printResult()
//            IsMaxValue(keys.next());
//        }
//    }
//    public void IsMaxValue(String member) {             // view
//        if (members.get(member).equals(maxScore)) {
//            if (winnerCnt > 0) {
//                System.out.print(",");
//            }
//            System.out.print(" "+member);
//            winnerCnt += 1;
//        }
//    }
//}
