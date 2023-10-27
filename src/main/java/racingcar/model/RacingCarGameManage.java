package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;

public class RacingCarGameManage {

    private final int MIN_RANGE = 0;
    private final int MAX_RANGE = 9;
    private final int MOVE_MIN_RANGE = 4;
    private final HashMap<String, Integer> playerRacingCarMap;

    public RacingCarGameManage() {
        this.playerRacingCarMap = new HashMap<>();
        playerRacingCarMap.clear();
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }


    public HashMap<String, Integer> getPlayerRandomNumber(ArrayList<String> playerCarNameList) {
        for(String carName : playerCarNameList) {
            int randomNumber =  getRandomNumber();
            if(randomNumber >= MOVE_MIN_RANGE) {
                playerRacingCarMap.put(carName, playerRacingCarMap.getOrDefault(carName, 0) + 1);
            }

            if(randomNumber < MOVE_MIN_RANGE) {
                playerRacingCarMap.put(carName, playerRacingCarMap.getOrDefault(carName, 0));
            }
        }
        return this.playerRacingCarMap;
    }

}
