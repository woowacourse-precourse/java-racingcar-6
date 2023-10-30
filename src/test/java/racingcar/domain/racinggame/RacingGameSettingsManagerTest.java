package racingcar.domain.racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.IOTest;
import racingcar.domain.car.config.CarConfig;
import racingcar.domain.racinggame.config.RacingGameConfig;
import racingcar.domain.victory.config.VictoryConfig;

class RacingGameSettingsManagerTest extends IOTest {

    RacingGameConfig racingGameConfig = new RacingGameConfig(new CarConfig(new VictoryConfig()));

    @Test
    void 자동차와_시도횟수를_세팅한다() {

        //give
        command("car1, car2, car3","3");
        RacingGameSettingsManager racingGameSettingsManager = racingGameConfig.racingGameSettingsManager();

        //when
        racingGameSettingsManager.setting();

        //then
        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", "시도할 회수는 몇회인가요?");
    }
}