package mytest;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;

public class UserSettingTest {
    @DisplayName("자동차 생성 테스트")
    @Test
    void 자동차_생성_태스트() {
        assertThatCode(()-> new Car("pobi"))
                .doesNotThrowAnyException();
    }

    @DisplayName("문자열로 입력 받은 사용자 이름에 대한 리스트 생성 확인 테스트")
    @Test
    void 입력받은_사용자_리스트_반환_태스트() {
        //given

        //when

        //then
    }
}
