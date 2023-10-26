package view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @BeforeEach
    public void clearConsole() {
        Console.close();
    }

    @ParameterizedTest(name = "입력 값 : {0}")
    @ValueSource(strings = {"pobi,json,test", "sky,ant,new", "tree,cap,book"})
    @DisplayName("사용자 이름 입력 시 올바른 배열로 바뀌는지")
    public void 사용자_이름_입력_테스트(String input) {
        //given
        String[] results = input.split(",");
        
        //when
        provideInput(input);
        String[] splitedInput = InputView.getCarsNameFromUserInput();

        //then
        Assertions.assertThat(splitedInput).isEqualTo(results);
    }
}
