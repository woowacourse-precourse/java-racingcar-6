package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGameController;

class RacingCarGameTest {

    RacingCarGame game = new RacingCarGame(new Referee(), new RacingGameController());

    @DisplayName("List 의 길이는 검증을 통과한 자동차의 수량와 같다.")
    @Test
    void listSizeEqualToCarNameCount() {
        //given //when
        List<Car> list = game.gameStart("감사합니다, 최종민", 3);

        //then
        assertThat(list.size()).isEqualTo(2);
    }

    @DisplayName("게임의 정보를 담고 있는 List 는 정상적으로 생성된다.")
    @Test
    void resultIsNotNull() {
        //given //when
        List<Car> list = game.gameStart("감사합니다, 최종민", 3);

        //then
        assertThat(list.size()).isNotNull();
    }

}