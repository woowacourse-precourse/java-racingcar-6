package racingcar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GameView {
    public static void gameStart(){
        System.out.println(Common.strGameStart);
    }

    public static void gameCount(){
        System.out.println(Common.strAskTimes);
    }

    public static void gameCurrent(HashMap<String,Integer> cars){
        Iterator<String> keys = cars.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();

            String str = key +Common.gameCurrentDivider + Common.gameCurrentProgress.repeat(cars.get(key));
            System.out.println(str);
        }
        System.out.println();
    }

    public  static void gameResult(List<String> winner){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < winner.size(); i++){
            if(i > 0){
                sb.append(", ");
            }
            sb.append(winner.get(i));
        }
        String result = Common.resultWinner + sb;
        System.out.println(result);
    }
}
