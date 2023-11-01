package racingcar;

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

    public Integer getTryNumber() {
        return tryNumber;
    }

    public void setTryNumber(Integer inputInteger) {
        tryNumber = inputInteger;
    }

    public void saveRacingData(List<String> inputString, Integer inputInteger){
        setPlayerStringList(inputString);
        setTryNumber(inputInteger);
    }

}
