package racingcar.domain;

import java.util.List;

public class Announcer {
    private String symbol;

    public String announceWinner() {
        return null;
    }

    public String createAnnouncement() {
        return null;
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
