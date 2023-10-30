package unit.input;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.input.CarInputDto;
import racingcar.dto.input.TimeInputDto;
import racingcar.service.input.Input;
import racingcar.service.input.InputView;
import racingcar.util.validator.Validator;

public class InputViewUnitTest {
    private Input input;

    @BeforeEach
    void init(){
        input = new InputView();
    }
    @AfterEach
    void finished() {
        Console.close();
    }

    @Test
    void 차량_입력_성공_케이스(){
        //given
        System.setIn(createUserInput("car1,car2,car3"));
        //when
        CarInputDto carInput = input.getCarInput();
        //then
        assertThat(carInput.cars()[0]).isEqualTo("car1");
    }

    @Test
    void 차량_비어_있는_입력_실패__케이스(){
        //given
        System.setIn(createUserInput(""));
        //then
        assertThatThrownBy(()->input.getCarInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈 값은 입력이 불가능합니다.");
    }

    @Test
    void 차량_이름_길이_초과_입력_실패_케이스(){
        //given
        System.setIn(createUserInput("car12345,car2,car3"));
        //then
        assertThatThrownBy(()->input.getCarInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름은 5자 이하만 가능합니다.");
    }
    @Test
    void 차량_이름_콤마_뒤에_붙은_실패_케이스(){
        //given
        System.setIn(createUserInput("car12345,car2,car3,"));
        //then
        assertThatThrownBy(()->input.getCarInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름은 5자 이하만 가능합니다.");
    }
    @Test
    void 차량_이름_콤마_앞에_붙은_실패_케이스(){
        //given
        System.setIn(createUserInput(",car12345,car2,car3"));
        //then
        assertThatThrownBy(()->input.getCarInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 횟수_입력_성공_케이스(){
        //given
        System.setIn(createUserInput("7"));
        //when
        TimeInputDto timeInput = input.getTimeInput();
        //then
        assertThat(timeInput.time()).isEqualTo(7);
    }

    @Test
    void 횟수_비어_있는_입력_실패__케이스(){
        //given
        System.setIn(createUserInput(""));
        //then
        assertThatThrownBy(()->input.getTimeInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈 값은 입력이 불가능합니다.");
    }

    @Test
    void 횟수_띄어있는_입력_실패__케이스(){
        //given
        System.setIn(createUserInput("1 3 5"));
        //then
        assertThatThrownBy(()-> input.getTimeInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 하나의 숫자만 입력해주세요.");
    }
    

    private InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
