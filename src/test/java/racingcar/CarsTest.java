package racingcar;

import domain.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 같은_자동차_이름을_입력한_경우_예외처리_발생_테스트() {
        //given
        String userInput = "yoon,su,yoon";
        String[] carNames = userInput.split(",");
        Cars cars = new Cars(carNames);

        //when & then
        Assertions.assertThatThrownBy(()-> cars.validateDuplication())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 자동차 이름을 입력하였습니다. 애플리케이션을 종료합니다.");
    }
}
