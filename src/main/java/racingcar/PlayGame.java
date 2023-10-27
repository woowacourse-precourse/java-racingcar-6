package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class PlayGame {
    public void TryGame(int TryNumber, List<String> members){
        System.out.println("실행 결과");
        List<Integer> count = new ArrayList<>();
        for(int i=0;i<members.size();i++)
            count.add(0);
        for(int i=0;i<TryNumber;i++){
            count = CheckMoveOrStop(members, count);
            System.out.println("");
        }
    }
    public List<Integer> CheckMoveOrStop(List<String> members, List<Integer> count){
        int MembersSize = members.size();
        for(int i=0;i<MembersSize;i++){
            String result = "";
            int RandomNumber = Randoms.pickNumberInRange(0,9);
            if(RandomNumber >= 4){
                result += "-";
                count.add(i, 1);
            }
            System.out.println(members.get(i) + " : " + result);
        }
        return count;
    }
}
