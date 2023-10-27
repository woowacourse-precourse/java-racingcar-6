package racingcar.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.utils.randomNum;

public class outputView {
    public void resultView(int count, HashMap<String, Integer> carNameHashMap) {
        randomNum randomNum = new randomNum();
        Set<String> keySet = carNameHashMap.keySet();
        List<String> maxKey = new ArrayList<>();
        int maxValue = 0;

        System.out.println("실행결과");
        for (int i = 0; i < count; i++) {
            for (String key : keySet) {
                int randNum = randomNum.makeRandomNum();
                if (randNum >= 4) {
                    carNameHashMap.put(key, carNameHashMap.get(key) + 1);
                }
            }

            for (String key : keySet) {
                int value = carNameHashMap.get(key);
                System.out.print(key + " : ");
                for (int j = 0; j < value; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        for (Map.Entry<String, Integer> entry : carNameHashMap.entrySet()) {
            int value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
                maxKey.clear();
                maxKey.add(entry.getKey());
            } else if (value == maxValue) {
                maxKey.add(entry.getKey());
            }
        }

        if(!maxKey.isEmpty()){
            String winner = String.join(", ",maxKey);
            System.out.println("최종 우승자 : "+winner);
            return;
        }
    }
}
