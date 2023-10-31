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

}