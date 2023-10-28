package racingcar.inputest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.CarGameService;

public class InputTest {

    private CarGameService carGameService;

    @BeforeEach
    void init(){
        carGameService = new CarGameService();
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 입력에 따른 예외 처리! 입력 길이 5 초과인 경우")
    @CsvSource({"123223", "123456,222,333", "123123123,23232323,44444"})
    void 자동차이름_길이_5초과(String input){
        Assertions.assertThatThrownBy(() ->
            carGameService.extractSeperator(input)).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @DisplayName("자동차 이름 입력에 따른 예외 처리! 입력 길이 0인 경우")
    @ValueSource(strings = {"1,,,3", ",,,"})
    void 자동차입름_길이_0인경우_(String input){
        Assertions.assertThatThrownBy(() ->
            carGameService.extractSeperator(input)).isInstanceOf(IllegalArgumentException.class);
    }





}
