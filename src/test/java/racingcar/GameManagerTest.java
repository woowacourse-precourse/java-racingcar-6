package racingcar;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GameManagerTest {

    @Test
    void 우승자를_알려주는_테스트() {
        User user = new User();
        String inputStr = "pobi,woni,jun,hoon";
        user.makeCars(inputStr);
        int attemptNumber = 10;
        user.tryDriving(attemptNumber);

        GameManager gameManager = new GameManager(user);
        System.out.println(gameManager.announceWinner());
    }

    private class GameManager {
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
}
