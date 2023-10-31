package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void Car_이름의_길이가_5초과하면_예외발생() {
        // given
        final String carName = "abcdef";

        // when && then
        Assertions.assertThatThrownBy(() -> Car.create(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이가 초과되었습니다.");
    }

    @Test
    public void Car_이름은_영어와숫자만_특수문자는_에러() {
        // given
        final String carName = "1bcd@";

        // when && then
        Assertions.assertThatThrownBy(() -> Car.create(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 알파벳, 숫자만 가능합니다.");
    }

    @Test
    public void Car_이름은_영어와숫자만_공백은_에러() {
        // given
        final String carName = "1bc ";

        // when && then
        Assertions.assertThatThrownBy(() -> Car.create(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 알파벳, 숫자만 가능합니다.");
    }

    //TODO: Car에서 get~~(getPosition)같은것을 쓸경우 이거를 위한 테스트 따로하기(위치 이동시킨다음  위치값 저장 잘되는지)
    // 이건 Car Model이 아닌 Service에서 하는게 맞을듯.
}