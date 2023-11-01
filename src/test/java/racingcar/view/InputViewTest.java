package racingcar.view;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;


class InputViewTest {

    @Test
    public void 이름_분리_테스트() throws Exception {
        InputView inputView = new InputView();

        //given
        String name = "car1,car2,car_4";

        //when
        List<String> carNames = inputView.getSplitCarNames(name);

        //then
        assertThat(carNames.get(0)).isEqualTo("car1");
        assertThat(carNames.get(1)).isEqualTo("car2");
        assertThat(carNames.get(2)).isEqualTo("car_4");
    }

}