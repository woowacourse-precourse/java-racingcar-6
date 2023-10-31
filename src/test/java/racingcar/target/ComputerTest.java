package racingcar.target;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private int size = 3;

    @Test
    @DisplayName("컴퓨터가 숫자를 알맞은 사이즈로 생성하는지 확인")
    void getNumberTest() {
        //given
        Computer computer = new Computer();
        int size = 3;

        //when
        computer.getNumber(3);

        //then
        Assertions.assertThat(computer.getNumber(3)).size().isEqualTo(3);
    }
}