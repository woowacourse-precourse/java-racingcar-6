package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CarInfoListTest {
    CarInfoList generateCarInfoList(String inputTestString) {
        return new CarInfoList(inputTestString);
    }

    @Test
    void split_메서드로_주어진_값을_구분() {
        String inputOneTwo = "1,2";

        CarInfoList carInfoList = generateCarInfoList(inputOneTwo);
        assertThat(carInfoList.getCarNameList()).contains("2", "1");
        assertThat(carInfoList.getCarNameList()).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String inputOnlyOne = "1";

        CarInfoList carInfoList = generateCarInfoList(inputOnlyOne);
        assertThat(carInfoList.getCarNameList()).contains("1");
    }

    @Test
    void length_다섯자리_초과_이름_포함된_경우_예외_발생() {
        String inputLengthFive = "aaaaa,bbbbb,ccccc";
        String inputLengthSix = "aaabbb,bbbccc,cccddd";

        // 최대 5자리인데 입력이 5자리면 예외 미발생
        assertThatNoException().isThrownBy(() -> generateCarInfoList(inputLengthFive));

        // 최대 5자리인데 입력이 6자리면 예외 발생
        assertThatThrownBy(() -> generateCarInfoList(inputLengthSix))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void winner_1번_2번만_더해졌을_때_1번_2번_우승자_반환() {
        String inputOneTwoThree = "1,2,3";
        List<Integer> moveForwardList = Arrays.asList(5,5,0);

        CarInfoList carInfoList = generateCarInfoList(inputOneTwoThree);
        carInfoList.updateCarInfoList(moveForwardList);
        assertThat(carInfoList.getWinnerList()).contains("1", "2");
    }

}
