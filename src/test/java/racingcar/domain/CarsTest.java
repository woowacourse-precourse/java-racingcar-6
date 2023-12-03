package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("자동차 생성 테스트")
class CarsTest {

    @Nested
    @DisplayName("자동차 생성시 잘못된 사용자 입력으로 예외 발생")
    class CarsExceptionTest {
        @Test
        @DisplayName("자동차 이름이 5자 초과 이므로 익셉션 발생")
        void validateName() throws Exception {
            //given
            String input = "ABCDEF, AB";
            //when
            //then
            assertThatThrownBy(() -> new Cars(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("5글자");

        }

        @Test
        @DisplayName("자동차의 대수가 2대 이상이 아니므로 익셉션 발생")
        void validateSize() throws Exception {
            //given
            String input = "A";
            //when
            //then
            assertThatThrownBy(() -> new Cars(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("2대 이상");
        }

        @Test
        @DisplayName("자동차의 이름이 중복이므로 익셉션 발생")
        void validateDuplicate() throws Exception {
            //given
            String input = "A,A,A";
            //when

            //then
            assertThatThrownBy(() -> new Cars(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("중복");
        }


    }

    @Test
    @DisplayName("자동차 생성 완료")
    void 자동차_생성_완료() throws Exception {
        //given
        String input = "A,B,C";
        //when
        Cars cars = new Cars(input);
        //then
        assertThat(cars.getMaps()).isEqualTo(Map.of("A", 0, "B", 0, "C", 0));
    }


}