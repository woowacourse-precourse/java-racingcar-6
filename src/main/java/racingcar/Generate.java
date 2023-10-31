package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Generate {
    //
    public static HashMap<String, Integer> carGenerate(HashMap<String, Integer> map, String carString) {
        String[] car = carString.split(",");
        for(int i = 0; i < car.length; i++) {
            if(car[i].length() > 5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            map.put(car[i], 0);
        }

        return map;
    }

    public static void raceResultGenerate(HashMap<String, Integer> map) {
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            String forwardCount = barGenerate(value);
            System.out.println(key + " " + ":" + " " + forwardCount);
        }
        System.out.println();
    }

    public static String barGenerate(Integer count) {
        String bar = "";

        for(int i = 0; i < count; i++) {
            bar += "-";
        }

        return bar;
    }

    public static void gameResultGenerate(HashMap<String, Integer> map) {
        int winnerCount = 0;
        String winner = "";

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if(value > winnerCount) {
                winnerCount = value;
                winner = key;
            } else if(value == winnerCount) {
                winner += (", " + key);
            }
        }

        System.out.println("최종 우승자 : " + winner);
    }
}
