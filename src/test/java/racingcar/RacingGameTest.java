package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;

@DisplayName("레이싱 게임 테스트")
class RacingGameTest {

    @Test
    @DisplayName("자동차 이름들 문자열이 들어왔을 경우 해당 문자열을 통해 레이싱에 참여할 자동차 리스트를 생성하며 게임 생성")
    void init_CarNameIsEntered() {
        // given
        String carNameString = "beom,sic,test";

        // when
        RacingGame racingGame = RacingGame.of(carNameString);

        // then
        List<Car> racingCarList = racingGame.getRacingCarList();
        assertAll(
                () -> assertThat(racingCarList).isNotEmpty(),
                () ->  assertThat(racingCarList).hasSize(3)
        );
    }

}
