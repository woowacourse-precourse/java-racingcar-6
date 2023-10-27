package racingcar.domain;

import java.util.List;

public class GameData {

    private Integer tryRepetitionNumber;
    private List<Car> winnerList;

    public Integer getTryRepetitionNumber() {
        return tryRepetitionNumber;
    }

    public List<Car> getWinnerList() {
        return winnerList;
    }

    public void setWinnerList(List<Car> winnerList) {
        this.winnerList = winnerList;
    }

    public void setTryRepetitionNumber(Integer tryRepetitionNumber) {
        this.tryRepetitionNumber = tryRepetitionNumber;
    }
}
