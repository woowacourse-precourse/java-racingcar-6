package racingcar.engine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @DisplayName("자동차 객체는 임계값 이상의 랜덤한 수를 입력받을 때 앞으로 전진한다.")
    @ParameterizedTest(name = "[{index}차]시도: threshold: {0}, randomNumber: {1}")
    @CsvSource({"1,2", "2,3", "2,2", "1,1", "1,100"})
    void testDrive(int threshold, int randomNumber) {
        //given
        Car whyWhale = new Car("whyWhale");
        int expectedProgress = 1;
        //when
        whyWhale.drive(threshold, randomNumber);
        //then
        assertThat(whyWhale.getProgress()).isEqualTo(expectedProgress);
    }

    @DisplayName("자동차 객체는 임계값 미만의 랜덤한 수를 입력받을 때 전진하지 않는다.")
    @ParameterizedTest(name = "[{index}차]시도: threshold: {0}, randomNumber: {1}")
    @CsvSource({"2,1", "3,2", "100,2", "10,1", "100,99"})
    void failDrive(int threshold, int randomNumber) {
        //given
        Car whyWhale = new Car("whyWhale");
        int expectedProgress = 0;
        //when
        whyWhale.drive(threshold, randomNumber);
        //then
        assertThat(whyWhale.getProgress()).isEqualTo(expectedProgress);
    }


}