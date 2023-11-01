package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static constants.Constant.*;

public class RacingController {

    List<String> playerList;
    List<String> winnerList = new ArrayList<String>();
    Integer tryNumber;

    RacingController(RacingData racingData) {
        playerList = racingData.getPlayerStringList();
        tryNumber = racingData.getTryNumber();
    }

    private Integer pickRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_NUM, END_RANDOM_NUM);
    }

    public void play(Map<String, Integer> playerResultMap) {

        for (String name : playerList) {
            Integer value = playerResultMap.get(name);

            Integer pickedNum = pickRandomNumber();
            boolean checkGoFlag = checkGoOrNot(pickedNum);

            if (checkGoFlag) {
                playerResultMap.put(name, value + 1);
            }
        }
    }

    private boolean checkGoOrNot(Integer pickedNum) {
        if (pickedNum >= Pivot_FOR_GO_NUM)
            return true;
        else if (pickedNum < Pivot_FOR_GO_NUM)
            return false;
        return false;
    }

    public boolean checkEnd(Map<String, Integer> playerResultMap) {
        boolean checkEndFlag = false;
        for (String name : playerList) {
            Integer position = playerResultMap.get(name);

            if (Objects.equals(position, tryNumber)) {
                winnerList.add(name);
                checkEndFlag = true;
            }
        }
        return checkEndFlag;
    }

    public List<String> getWinnerList() {
        return winnerList;
    }


    public void initSetting(Map<String, Integer> playerResultMap) {
        for (String name : playerList) {
            Integer position = playerResultMap.get(name);
            if (position == null) {
                playerResultMap.put(name, POSITION_ZERO_INTEGER);
            }
        }
    }
}
