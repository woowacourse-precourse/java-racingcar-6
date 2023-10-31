package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingWinner {
    public int findWinner(Map<String,String> list){
        int maxValue=0;
        for(Map.Entry<String,String> entry: list.entrySet()){
            if(entry.getValue().length()>=maxValue){
                maxValue=entry.getValue().length();
            }
        }
        return maxValue;
    }
    public void printRaceWinner(Map<String,String> list, int maxLength){
        System.out.print("최종 우승자 : ");
        List<String> winnerList=new ArrayList<>();
        for(Map.Entry<String,String> entry:list.entrySet()){
            if(entry.getValue().length()==maxLength){
                winnerList.add(entry.getKey());
            }
        }
        if(winnerList.size()==1){
            System.out.println(winnerList.get(0));
        }else{
            printWinners(winnerList);
        }

    }
    public void printWinners(List<String> winnersList){
        for (int i = 0; i < winnersList.size(); i++) {
            System.out.print(winnersList.get(i));
            if (i < winnersList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
