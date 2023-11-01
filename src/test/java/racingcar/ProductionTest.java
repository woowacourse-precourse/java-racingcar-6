package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ProductionTest {

    @Test
    @DisplayName("makeRacingCar로 자동차 리스트를 만들 수 있다")
    void makeRacingCarHappy() {
        //then
        String carName = "poni,benz,volvo,bmw";

        //when
        List<String> result = Production.makeRacingCar(carName);

        //then
        Assertions.assertThat(result).containsExactly("poni", "benz", "volvo", "bmw");
    }

    @Test
    @DisplayName("trialNumber 함수로 시도할 횟수를 입력 받을 수 있다.")
    void trialNumberHappy() {
        //given
        String strTrialNum = "4";

        // when
        int result = Production.trialNumber(strTrialNum);

        // then
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("trialNumber 함수에 음수가 입력되면")
    void trialNumberNegative() {
        // given
        String strTrialNum = "-4";

        //when & then
        Assertions.assertThatThrownBy(() -> Production.trialNumber(strTrialNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 자연수여야 합니다.");
    }

    @Test
    @DisplayName("trialNumber 함수에 정수가 아닌 수가 입력되면")
    void trialNumberFloat() {
        //given
        String strTrialNum = "five";

        //when & then
        Assertions.assertThatThrownBy(() -> Production.trialNumber(strTrialNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 정수여야 합니다.");
    }

    @Test
    @DisplayName("implementMakeRandomNum 로 차의 수만큼의 랜덤 숫자가 담긴 리스트를 얻을 수 있다.")
    void implementMakeRandomNum() {
        List<String> carList = new ArrayList<String>(Arrays.asList("aa","bb","cc","dd"));

        // when
        List<Integer> result = Production.implementMakeRandomNum(carList);

        // then
        Assertions.assertThat(result).hasSize(4);
    }


    @Test
    @DisplayName("makeEmptyList로 ''가 반복된 배열을 만들 수 있다.")
    void makeEmptyListHappy() {
        //given
        int length = 4;
        //when
        List<String> result = Production.makeEmptyList(length);
        //then
        Assertions.assertThat(result).hasSize(length);
        Assertions.assertThat(result).allMatch(s -> s.equals(""));
    }

    @Test
    @DisplayName("makeEmptyList에 음수가 들어가면 에러가 발생한다.")
    void makeEmptyListBad() {
        //given
        int length = -2;
        //when & then
        Assertions.assertThatThrownBy(()->Production.makeEmptyList(length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("배열의 길이는 0이상이어야 합니다.");
    }

}