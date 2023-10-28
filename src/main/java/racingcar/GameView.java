package racingcar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GameView {
    public static void gameStart(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void gameCount(){
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void gameCurrent(HashMap<String,Integer> cars){
        Iterator<String> keys = cars.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
//            System.out.println( String.format("키 -> %s, 값 -> %s", key, cars.get(key)) );

            String str = key + " : " + "-".repeat(cars.get(key));
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
        String result = "최종 우승자 : " + sb;
        System.out.println(result);
    }

    //테스트용 view
    public static void gameMonitoring(HashMap<String,Integer> cars,int count){
        System.out.println("차량상태" + cars);
        System.out.println("시도할횟수" + count);
    }
}
