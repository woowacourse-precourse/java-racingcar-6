package racingcar.util;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 숫자 생성기 테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RandomNumberGeneratorTest {

    @Order(1)
    @DisplayName("Case1. 정수만을 생성하는가")
    @RepeatedTest(1_000)
    void Case_1_Is_Generated_Integer() {
        assertThat(RandomNumberGenerator.generate())
                .isInstanceOf(Integer.class);
    }

    @Order(2)
    @DisplayName("Case2. 요구되는 유효 범위내의 값만을 생성하는가")
    @RepeatedTest(1_000)
    void Case_2_Is_Generated_In_Available_Range() {
        assertThat(RandomNumberGenerator.generate())
                .isIn(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}