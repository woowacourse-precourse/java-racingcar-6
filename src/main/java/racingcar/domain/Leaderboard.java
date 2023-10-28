package racingcar.domain;

import java.util.*;

public class Leaderboard {

    public Map<String, Integer> board = new LinkedHashMap<String, Integer>();

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
        System.out.println();
    }

    public void distance(int n){
        for (int i=0; i<n; i++){
            System.out.print("-");
        }
    }
    public void winner() {
        String result="최종 우승자 : ";
        int maxDistance = Collections.max(board.values());
        int numberOfWinners = 0;

        for (String name : board.keySet()){

            if (maxDistance==board.get(name)) {

                if (numberOfWinners == 0) {
                    result = result + name;
                } else {
                    result = result + (", " + name);
                }

                numberOfWinners++;
            }
        }

        System.out.print(result);
    }

}