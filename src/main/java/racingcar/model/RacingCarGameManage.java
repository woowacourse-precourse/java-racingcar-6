package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RacingCarGameManage {

    private final int MIN_RANGE = 0;
    private final int MAX_RANGE = 9;
    private final int MOVE_MIN_RANGE = 4;
    private final HashMap<String, Integer> playerRacingCarMap;
    private ArrayList<Car> winnerList;

    public RacingCarGameManage() {
        this.playerRacingCarMap = new HashMap<>();
        playerRacingCarMap.clear();
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }


    public HashMap<String, Integer> getPlayerRandomNumber(ArrayList<Car> playerCarNameList) {
        for(Car carName : playerCarNameList) {
            int randomNumber =  getRandomNumber();
            if(randomNumber >= MOVE_MIN_RANGE) {
                playerRacingCarMap.put(carName.getName(), playerRacingCarMap.getOrDefault(carName.getName(), 0) + 1);
            }

            if(randomNumber < MOVE_MIN_RANGE) {
                playerRacingCarMap.put(carName.getName(), playerRacingCarMap.getOrDefault(carName.getName(), 0));
            }
        }
        return this.playerRacingCarMap;
    }

    public ArrayList<Car> getWinner(HashMap<String, Integer> playerRacingCarMap) {
        winnerList = new ArrayList<>();
        playerRacingCarMap.forEach((key, value) -> {
                    if(Objects.equals(value, playerRacingCarMap.values().stream().max(Integer::compare).get())) {
                        winnerList.add(new Car(key));
                    }
                }
        );
        return winnerList;

    }

}
