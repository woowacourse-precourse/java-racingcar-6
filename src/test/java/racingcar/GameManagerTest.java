package racingcar;

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
}
