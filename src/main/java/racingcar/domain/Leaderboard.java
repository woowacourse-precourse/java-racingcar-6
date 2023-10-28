package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard {

    Map<String, Integer> board = new HashMap<String, Integer>();

    public Leaderboard(List<String> names) {
        for (String name : names){
            board.put(name, 0);
        }
    }

    public void status(){
        for (String name : board.keySet()){
            System.out.printf(name+" : ");
            distance(board.get(name));
            System.out.println();
        }
    }

    public void distance(int n){
        for (int i=0; i<n; i++){
            System.out.print("-");
        }
    }

}
