package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    public void 입력한_실행_횟수가_판단_기준보다_크다() {
        Referee referee = new Referee();

        assertThat(referee.isGreaterThanEqual(9)).isTrue();
        assertThat(referee.isGreaterThanEqual(8)).isTrue();

        assertThat(referee.isGreaterThanEqual(2)).isFalse();
    }
}
