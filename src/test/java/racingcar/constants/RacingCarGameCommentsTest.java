package racingcar.constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarGameCommentsTest {

    @Test
    @DisplayName("자동차 경주 게임 문구 테스트")
    void racingCarGameCommentsTest() {
        assertAll(
                "자동차 경주 게임 문구 테스트",
                () -> assertThat(RacingCarGameComments.OPENING_COMMENT).isEqualTo(
                        "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
                () -> assertThat(RacingCarGameComments.TRY_COMMENT).isEqualTo("시도할 회수는 몇회인가요?"),
                () -> assertThat(RacingCarGameComments.RESULT_COMMENT).isEqualTo("실행 결과"),
                () -> assertThat(RacingCarGameComments.WINNER_COMMENT).isEqualTo("최종 우승자 : ")
        );
    }

}