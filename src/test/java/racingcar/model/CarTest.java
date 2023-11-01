package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @DisplayName("자동차 이름 생성 5자 이하  테스트")
    @ParameterizedTest
    @ValueSource(strings = {"12345","1234","일이삼"})
    void createCarWithNameNormalTest(String inputName) {

        // when
        final Car car = new Car(inputName);

        // then
        assertThat(car.getName()).as("사용자가 입력한 이름이 차의 이름이 아닙니다.")
                .isEqualTo(inputName);
    }

    @DisplayName("자동차 이름 생성 5자 초과 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123456","12  34","일이삼사오육칠"})
    void createCarWithNameErrorTest(String inputName) {

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {new Car(inputName);});

    }


}
