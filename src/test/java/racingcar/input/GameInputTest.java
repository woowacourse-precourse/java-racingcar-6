package racingcar.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.CarRaceService;

public class GameInputTest {

    private CarRaceService carRaceService;

    @BeforeEach
    void init(){
        carRaceService = new CarRaceService();
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 입력에 따른 예외 처리! 입력 길이 5 초과인 경우")
    @ValueSource(strings = {"123223", "123456,222,333", "123123123,23232323,44444"})
    void 자동차이름_길이_5초과(String input){
        Assertions.assertThatThrownBy(() ->
            carRaceService.extractSeperator(input)).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @DisplayName("자동차 이름 입력에 따른 예외 처리! 입력 길이 0인 경우")
    @ValueSource(strings = {"1,,,3", ",,,"})
    void 자동차이름_길이_0인경우_(String input){
        Assertions.assertThatThrownBy(() ->
            carRaceService.extractSeperator(input)).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @DisplayName("게임 횟수 숫자인지 검증!")
    @ValueSource(strings = {"--=", "abd", "ddd", ""})
    void 게임횟수_입력_검증(String input){
        Assertions.assertThatThrownBy(()-> carRaceService.convertGameCountToNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }





}
