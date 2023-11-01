package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;
import racingcar.controller.Input;

public class Application {
    public static void main(String[] args) {
        var gameStartData = Input.inputGameInfo();

        Map<String, StringBuilder> racer = new HashMap<>();
        for(String name: gameStartData.carName){
            racer.put(name, new StringBuilder());
        }

        final int LEAST_POWER = 4;

        for(int i = 0 ; i < gameStartData.loopCount;++i){
            for(StringBuilder sb : racer.values()){
                int forwardPower = Randoms.pickNumberInRange(0, 9);
                if(forwardPower < LEAST_POWER) continue;
                sb.append('-');
            }

            // print result after step
            for(String key: racer.keySet()){
                System.out.println(key + " : " + racer.get(key).toString());
            }
            System.out.println();
        }

        int maxLength = 0;
        for(var sb : racer.values()){
            if(maxLength < sb.length()){
                maxLength = sb.length();
            }
        }


        int finalMaxLength = maxLength;
        var winner = racer.keySet()
                .stream()
                .filter(key -> finalMaxLength == racer.get(key).length())
                .toList();

        var sb = new StringBuilder();

        sb.append("최종 우승자 : ");
        sb.append(String.join(", ", winner));

        System.out.println(sb);
    }


}
