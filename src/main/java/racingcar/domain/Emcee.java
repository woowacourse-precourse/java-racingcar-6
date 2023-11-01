package racingcar.domain;

import java.util.List;
import java.util.Map;

public class Emcee {
    private final static Character POSITION_SYMBOL = '-';
    private final static String JOIN_SYMBOL = ", ";

    public String returnCurrentPosition(Map<String, Integer> carList) {
        StringBuilder sb = new StringBuilder();
        for (String name : carList.keySet()) {
            sb.append(name)
                    .append(" : ")
                    .append(position(carList.get(name)))
                    .append("\n");
        }
        return sb.toString();
    }

    private String position(int count) {
        StringBuilder position = new StringBuilder();
        for (int i = 0; i < count; i++) {
            position.append(POSITION_SYMBOL);
        }
        return position.toString();
    }

    public String returnWinner(List<String> winnerList) {
        return String.join(JOIN_SYMBOL, winnerList);
    }
}
