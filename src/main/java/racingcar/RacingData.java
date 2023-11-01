package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingData {

    private List<String> playerStringList;
    private Integer tryNumber;

    public List<String> getPlayerStringList() {
        return playerStringList;
    }

    public void setPlayerStringList(List<String> inputString) {
        playerStringList = inputString;
    }

    public void initPlayerStringList() {
        playerStringList = new ArrayList<String>();
    }

    public Integer getTryNumber() {
        return tryNumber;
    }

    public void setTryNumber(Integer inputInteger) {
        tryNumber = inputInteger;
    }

    public void initTryNumber() {
        tryNumber = 0;
    }

    public void saveRacingData(List<String> inputString, Integer inputInteger) {
        setPlayerStringList(inputString);
        setTryNumber(inputInteger);
    }

}
