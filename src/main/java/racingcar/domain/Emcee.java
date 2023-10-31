package racingcar.domain;

import java.util.Map;

public class Emcee {
    private final static Character POSITION_SYMBOL = '-';

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

    public String returnWinner() {
        return "";
    }
}
