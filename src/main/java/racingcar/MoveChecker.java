package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MoveChecker {
    public List<Integer> checkMoveOrStop(List<String> members, List<Integer> count){
        ResultChecker resultChecker = new ResultChecker();
        int MembersSize = members.size();
        String result = "";
        for(int i=0;i<MembersSize;i++){
            int RandomNumber = Randoms.pickNumberInRange(0,9);
            if(RandomNumber >= 4){
                count.set(i, count.get(i)+1);
            }
            result = resultChecker.checkResult(count.get(i));
            System.out.println(members.get(i) + " : " + result);
        }
        return count;
    }
}
