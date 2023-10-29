package racingcar.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;

class CarTest {
    private final Car car = new Car();

    @Test
    void validateName_메서드_사용시_자동차_이름이_5자_초과할_때_예외_발생() {
        assertThatThrownBy(() -> car.createName("pooooo")).hasMessageContaining(ExceptionMessage.NAME_OF_RANGE);
    }

    @Test
    void stringToStringList_메서드_사용시_쉼표_없는_문자열_반환(){
        car.createName("oop,ppp,123");

        assertThat(car.getNames()).isEqualTo(Arrays.asList("oop","ppp","123"));
    }

    @Test
    void moveToGo_메서드_사용시_무작위_값이_4이상일_경우_참을_반환() {
        Car car = new Car();
        boolean result = car.moveToGo();

        assertThat(result).isTrue();
    }
}