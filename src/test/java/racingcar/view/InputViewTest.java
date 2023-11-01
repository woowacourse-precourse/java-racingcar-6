package racingcar.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"bmw,kia"})
    void 컴마_구분의_자동차_이름이_주어질때는_저장_성공(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView iv = new InputView();
        iv.registCarName();
        assertThat(iv.registedCar.get(0).getName()).isEqualTo("bmw");
        assertThat(iv.registedCar.get(1).getName()).isEqualTo("kia");
    }

    @ParameterizedTest
    @ValueSource(strings = {"bmw#kia"})
    void 컴마_구분이_아닌_방식의_이름_입력은_예외_처리(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView iv = new InputView();
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> iv.registCarName());
        assertThat(e.getMessage()).isEqualTo("잘못된 형식의 값을 입력하였습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"hyundai,mercedesBenz"})
    void 입력_이름이_6자_이상이면_예외_처리(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView iv = new InputView();
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> iv.registCarName());
        assertThat(e.getMessage()).isEqualTo("잘못된 형식의 값을 입력하였습니다");
    }

}