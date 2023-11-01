package racingcar;

import java.util.List;

public class OutputPrinter {
    public static void winnerPrinter(List<String> winnerList){
        String result = "최종 우승자 : ";
        if(winnerList.size() >= 2){
            winnersPrinter(winnerList, result);
        }else{
            for(String winner: winnerList){
                result += winner;
            }
            System.out.println(result);
        }
    }
    public static void winnersPrinter(List<String> winnerList, String result){
        for(int i =0; i< winnerList.size(); i++){
            if(i != winnerList.size()-1){
                result += (winnerList.get(i) + ", ");
            }else{
                result += winnerList.get(i);
            }
        }
        System.out.println(result);
    }
}
