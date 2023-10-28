package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarManagerTest {

    @Test
    void 자동차_리스트_생성시_이름을_넣지_않으면_예외_발생() {
        //given
        CarManager carManager = new CarManager();
        String inputCarNames = "";

        //when&then
        assertThatThrownBy(() -> carManager.createCarList(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차의_이름_개수에_따라_객체가_생성된다() {
        //given
        CarManager carManager = new CarManager();
        String inputCarNames = "minji,hani,hyein";

        //when
        CarGroup carList = carManager.createCarList(inputCarNames);

        //then
        assertThat(carList.size()).isEqualTo(3);
    }
}