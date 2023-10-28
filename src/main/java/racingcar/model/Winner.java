package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;


public class Winner {
    private ArrayList<String> winnerList = new ArrayList<>();
    public void decideWinner(int[] ranking, ArrayList<String> cars){
        for(int i = 0; i < ranking.length; i++){
            if(ranking[i] == Arrays.stream(ranking).max().getAsInt()){
                winnerList.add(cars.get(i));
            }
        }
    }

    public ArrayList<String> getWinnerList(){
        return winnerList;
    }
}
