package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarTest {

    @DisplayName("자동차 이름이 5자 초과이면 예외를 발생시킨다.")
    @Test
    public void validateCarNameLengthOverflow(){
        assertThatThrownBy(()-> {
            new Car("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("validateCarNameDuplicate")
    @Test
    public void validateCarNameDuplicate(){
        assertThatThrownBy(()->{
            String [] carList = {"1234","1234"};
            new Cars(carList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 빈 문자열 일 수 없다")
    @ParameterizedTest
    @ValueSource(strings ={""," ","   ","    "})
    @Test
    public void checkCarNameBlank(){
        assertThatThrownBy(()->{
            new Car(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
