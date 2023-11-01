package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @DisplayName("자동차 이름 생성 5자 이하  테스트")
    @ParameterizedTest
    @ValueSource(strings = {"12345", "1234", "일이삼"})
    void createCarWithNameNormalTest(String inputName) {

        // when
        final Car car = new Car(inputName);

        // then
        assertThat(car.getName()).as("사용자가 입력한 이름이 차의 이름이 아닙니다.")
                .isEqualTo(inputName);
    }

    @DisplayName("자동차 이름 생성 5자 초과 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "12  34", "일이삼사오육칠"})
    void createCarWithNameErrorTest(String inputName) {

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(inputName);
        });

    }


    @DisplayName("자동차 전진, 멈춤 테스트")
    @Test
    void stopOrMoveForwardTest() {
        //given
        final Car car = new Car("hi");

        //when
        car.stopOrMoveForward();

        //then
        assertThat(car.measureDistance()).as("자동차가 한칸 전진하거나 멈추지 않았습니다.")
                .satisfiesAnyOf(actual -> assertThat(actual).isEqualTo(0)
                        , actual -> assertThat(actual).isEqualTo(1));
    }

    @DisplayName("자동차 현재 위치 출력 테스트")
    @Test
    void distanceConvertStringTest() {
        //given
        final Car car = new Car("hello");
        car.stopOrMoveForward();

        //when then
        if (car.measureDistance() > 0) {
            assertThat(car.distanceConvertString()).as("자동차의 위치가 문자열 형태로 변환되지 않았습니다.").contains("hello : ", "-");
        } else {
            assertThat(car.distanceConvertString()).as("자동차의 위치가 문자열 형태로 변환되지 않았습니다.").contains("hello : ");
        }
    }

}
