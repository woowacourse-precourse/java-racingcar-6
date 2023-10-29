package racingcar;

import java.util.List;

public class WinnerChecker {
    public void checkWinner(List<String> members, List<Integer> count){
        IndexFinder indexFinder = new IndexFinder();
        int MaxIndex = indexFinder.findMaxIndex(count);
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
}
