package racingcar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class PlayGame {
    public void TryGame(List<String> members, int TryNumber){
        System.out.println("실행 결과");
        List<Integer> count = new ArrayList<>();
        for(int i=0;i<members.size();i++)
            count.add(0);
        for(int i=0;i<TryNumber;i++){
            count = CheckMoveOrStop(members, count);
            System.out.println("");
        }
        CheckWinner(members, count);
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
    public void CheckWinner(List<String> members, List<Integer> count){
        int MaxIndex = FindMaxIndex(count);
        int CountSize = count.size();
        int max = count.get(MaxIndex);
        System.out.print("최종 우승자 : " + members.get(MaxIndex));
        for(int i=0;i<CountSize;i++){
            if(i == MaxIndex)
                continue;
            if(max == count.get(i))
                System.out.print(", " + members.get(i));
        }
    }
    public int FindMaxIndex(List<Integer> count){
        int index = 0;
        int size = count.size();
        for(int i = size; i <= 0; i--){
            if(count.get(i) == Collections.max(count))
                index = i;
        }
        return index;
    }
}
