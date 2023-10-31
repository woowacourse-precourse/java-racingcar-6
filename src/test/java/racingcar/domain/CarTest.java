package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 개별의 실행 결과 출력 메시지 테스트")
    void createRoundRaceResult() {
        // given
        Car pobi = new Car("pobi");

        // when
        pobi.updateScore();
        pobi.updateScore();
        pobi.updateScore();
        StringBuilder roundRaceResult = pobi.createRoundRaceResult();

        // then
        assertThat(roundRaceResult.toString()).isEqualTo("pobi : ---");
    }

    @Test
    @DisplayName("최종 우승자 생성 시 정해진 출력값 형식과 다르면 오류 발생")
    void createWinnerTest() {
        // given
        Car pobi = new Car("pobi");

        // when
        StringBuilder winner = pobi.createWinner();

        // then
        assertThat(winner.toString()).isEqualTo("pobi, ");
    }
}