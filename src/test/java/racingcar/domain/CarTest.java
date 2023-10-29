package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    void 자동차_생성_테스트(){

        String carName = "povi";

        Car car = new Car(carName);

        Assertions.assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "5글자가 넘는 이름", ""})
    void 자동차_이름_유효성검사(String name){
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }



}