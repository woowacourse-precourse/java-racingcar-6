package racingcar.domain;

import java.util.List;

public class Announcer {
    private final static String JOIN_SYMBOL = ", ";
    private final static String LOCATION_SYMBOL = "-";

    public String generateWinnerAnnouncement(List<String> winners) {
        return String.join(JOIN_SYMBOL, winners);
    }

    public String generateLocationAnnouncement(List<Car> carList) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.getName())
                    .append(" : ")
                    .append(LOCATION_SYMBOL.repeat(car.getLocation()))
                    .append("\n");
        }
        return sb.toString();
    }
}
