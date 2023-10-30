package unit.input;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.input.CarInputDto;
import racingcar.service.input.Input;
import racingcar.service.input.InputView;

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
        Assertions.assertThat(carInput.cars()[0]).isEqualTo("car1");
    }

    @Test
    void 차량_비어있는_입력_실패__케이스(){
        //given
        System.setIn(createUserInput(""));
        //when
        CarInputDto carInput = input.getCarInput();
        //then
        Assertions.assertThat(carInput.cars()[0]).isEqualTo("car1");
    }


    private InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
