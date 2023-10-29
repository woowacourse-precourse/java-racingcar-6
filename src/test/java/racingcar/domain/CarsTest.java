package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.fixture.NameFixture.VALID_CAR_INPUT;

class CarsTest {

    @Nested
    @DisplayName("[create Test - Constructor Static Factory Method]")
    class createTest {

        @Test
        @DisplayName("[Success] Cars 일급 컬렉션 객체 생성에 성공합니다.")
        void Given_ValidName_When_Create_Then_Success() {
            //given
            String validCarNames = VALID_CAR_INPUT.getName();

            //when && then
            assertDoesNotThrow(() -> Cars.create(validCarNames));
        }
    }
}
