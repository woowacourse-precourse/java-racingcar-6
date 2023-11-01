package racingcar.game;

import org.junit.jupiter.api.Test;
import racingcar.game.components.Car;
import racingcar.game.components.GameSetting;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameManagerTest {

    private final RacingGameManager gameManager = new RacingGameManager();

    @Test
    void setting() {
        String carNames = "enzo,na,kim,park";
        String attemptCount = "5";
        String settingValue = carNames + "\n" + attemptCount;

        systemIn(settingValue);
        GameSetting setting = gameManager.setting();

        List<Car> userList = Arrays.asList(
                new Car("enzo"),
                new Car("na"),
                new Car("kim"),
                new Car("park")
        );
        List<Car> systemList = setting.getCarList();
        assertEquals(userList, systemList);

        int userAttemptCount = Integer.parseInt(attemptCount);
        int systemAttemptCount = setting.getAttemptCount();
        assertThat(systemAttemptCount).isEqualTo(userAttemptCount);
    }

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}