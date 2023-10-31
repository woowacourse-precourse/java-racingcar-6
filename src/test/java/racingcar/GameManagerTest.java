package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameManagerTest {
    @ParameterizedTest
    @CsvSource({"'pobi,woni,jun,hoon', 5", "'mario,hamzi,ham,otter', 5", "lutte, 5"})
    void 우승자를_알려주는_테스트(String carName, Integer attemptNum) {
        User user = new User();
        user.makeCars(carName);
        user.tryDriving(attemptNum);
        GameManager gameManager = new GameManager(user);
        System.out.println(gameManager.announceWinner());
    }
}
