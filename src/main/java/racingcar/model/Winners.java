package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<String> winnerList = new ArrayList<>();
    
    public void addWinner(String winner) {
        winnerList.add(winner);
    }
    
    public List<String> getWinner() {
        return winnerList;
    }
}
