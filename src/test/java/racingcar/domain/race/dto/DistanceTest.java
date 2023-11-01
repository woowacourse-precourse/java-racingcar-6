package racingcar.domain.race.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DistanceTest {

    @Test
    void 문자열_추가_테스트() {
        // given
        final String INITIAL_STRING = "initial";
        final String ADD_STRING = "-added";
        final String EXPECTED_STRING = INITIAL_STRING + ADD_STRING;
        final Distance DISTANCE = new Distance(new StringBuilder(INITIAL_STRING));

        // when
        DISTANCE.move(ADD_STRING);

        // then
        assertThat(DISTANCE.toString())
                .isEqualTo(EXPECTED_STRING);
    }

    @Test
    void 길이_확인_테스트() {
        // given
        final String INPUT = "-----";
        final int EXPECTED_LENGTH = 5;
        final Distance DISTANCE = new Distance(new StringBuilder(INPUT));

        // when
        final int LENGTH = DISTANCE.getLength();

        // then
        assertThat(LENGTH)
                .isEqualTo(EXPECTED_LENGTH);
    }

    @Test
    void 문자열_변환_테스트() {
        // given
        final String INPUT = "test";
        final Distance DISTANCE = new Distance(new StringBuilder(INPUT));

        // when
        String toStringResult = DISTANCE.toString();

        // then
        assertThat(toStringResult)
                .isEqualTo(INPUT);
    }

}