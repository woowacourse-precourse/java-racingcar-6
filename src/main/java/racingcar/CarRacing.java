package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRacing {
    private ArrayList<Integer> countGo = new ArrayList<>();
    private String winner;
    private CarRacing(ArrayList<String> nameList, ArrayList<Integer> countGo){
        this.countGo = countGo;
        this.winner = winner(nameList, countGo);

    }

    public static CarRacing carRacing(ArrayList<String> nameList, int racingNumber){
        ArrayList<Integer> countGo = new ArrayList<>();

        for(int j=0;j<nameList.size();j++){
            countGo.add(0);
        }

        for(int i=0;i<racingNumber;i++){
            for(int j=0;j<nameList.size();j++){
                if(stopGo()){
                    countGo.set(j, countGo.get(j) + 1);
                }
            }
            racingNow(nameList,countGo);
        }

        return new CarRacing(nameList, countGo);
    }


    public String winner(ArrayList<String> nameList, ArrayList<Integer> countGo){
        String winner = "";
        int max = Collections.max(countGo);
        int cnt = 0;

        for(int i=0;i< countGo.size();i++){
            if(countGo.get(i) == max){
                if(cnt == 0){
                    winner = nameList.get(i);
                    cnt += 1;
                    continue;
                }
                if(cnt > 0) {
                    winner = winner.concat(", " + nameList.get(i));
                    cnt += 1;
                }
            }
        }

        return winner;
    }

    public static void racingNow(ArrayList<String> nameList, ArrayList<Integer> countGo){

        for(int i=0;i<nameList.size();i++){
            System.out.print(nameList.get(i) + " : ");
            for(int j=0;j<countGo.get(i);j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean stopGo(){
        if(Randoms.pickNumberInRange(0,9) >= 4){
            return true;
        }
        return false;
    }

    public String getWinner(){
        return winner;
    }

}
