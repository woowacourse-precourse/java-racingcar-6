package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.Input;
import racingcar.view.Description;
import racingcar.view.View;

import java.util.HashMap;
import java.util.Map;

public class Game {

    public static void run(){
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

            View.showCurrentState(racer);
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

        String winnerString = String.join(", ", winner);
        View.show(Description.WINNER + winnerString);

    }

}
