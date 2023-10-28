package racingcar.domain;

import java.util.*;

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
    public void winner() {
        List<String> names = new ArrayList<>(board.keySet());
        Collections.sort(names, (name1, name2) -> (board.get(name2).compareTo(board.get(name1))));

        String result="최종 우승자 : ";
        int maxDistance = 0;

        for (String name : board.keySet()){
            if (maxDistance==0) {
                maxDistance = board.get(name);
                result=result+name;
                continue;
            }

            if (maxDistance==board.get(name)){
                result=result+(", "+name);
            }
            else {
                break;
            }
        }

        System.out.print(result);
    }

}
