package racingcar.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputValidateTest {

    @Test
    void 입력값중_특수문자_포함시_에러출력(){
        String[] carNames = new String[2];
        carNames[0] = "!@$";
        carNames[1] = "^$*!";
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> InputValidate.validateCarName(carNames));
        assertThat(e.getMessage()).isEqualTo("잘못된 형식의 값을 입력하였습니다");
    }

    @Test
    void 입력값중_길이가_6이상이면_예외처리(){
        String[] carNames = new String[2];
        carNames[0] = "aaaaaa";
        carNames[1] = "bbbbbb";
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> InputValidate.validateCarName(carNames));
        assertThat(e.getMessage()).isEqualTo("잘못된 형식의 값을 입력하였습니다");
    }

    @Test
    void 차_이동_횟수가_숫자가_아니면_예외처리(){
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> InputValidate.validateCarMoveNum("abc"));
        assertThat(e.getMessage()).isEqualTo("잘못된 형식의 값을 입력하였습니다");
    }

}