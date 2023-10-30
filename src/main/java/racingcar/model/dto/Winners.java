package racingcar.model.dto;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<String> winnerList;

    public Winners(List<String> winnerList) {
        this.winnerList = winnerList;
    }

    public List<String> getWinnerList() {
        return new ArrayList<>(winnerList);
    }
}
