package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private User user;
    private List<String> winnerMembers = new ArrayList<>();

    public GameManager(User user) {
        this.user = user;
    }

    public String announceWinner() {
        int longestDistanceDriven = -1;

        for (Car car : user.getCars()) {
            if (longestDistanceDriven < car.getDistanceDriven().length()) {
                longestDistanceDriven = car.getDistanceDriven().length();
            }
        }

        for (Car car : user.getCars()) {
            if (longestDistanceDriven == car.getDistanceDriven().length()) {
                winnerMembers.add(car.getCarName());
            }
        }

        return String.join(", ", winnerMembers);
    }
}
