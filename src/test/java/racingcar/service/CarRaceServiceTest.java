package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

class CarRaceServiceTest {



    private static final int TEST_MOVE_COUNT=3;
    private static final String TRACE="-";
    private static final String COLONE=" : ";
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
    @ValueSource(strings = {"1,,,3", ",,,", ""})
    void 자동차이름_길이_0인경우_(String input){
        Assertions.assertThatThrownBy(() ->
            carRaceService.extractSeperator(input)).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @DisplayName("게임 횟수 숫자인지 검증!")
    @ValueSource(strings = {"--=", "abd", "ddd", ""})
    void 게임횟수_입력_검증(String input){
        Assertions.assertThatThrownBy(()-> carRaceService.convertGameRoundToNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }



    @Test
    @DisplayName("실행 결과 별 출력 테스트!")
    void roundResult() {
        //given
        List<Car> cars = new ArrayList<>();
        //랜덤 제어를 위한 임의의 전진 카운트 값 선정!
        cars.add(new Car("pobi", TEST_MOVE_COUNT));
        cars.add(new Car("woni", TEST_MOVE_COUNT));
        List<String> recordResult = new ArrayList<>();

        //when
        for (Car car : cars) {
            recordResult.add(madeCarResult(car)); // 랜덤 제어를 위한 별도의 메서드 생성!
        }

        //then
        Assertions.assertThat(recordResult).contains("pobi : --", "woni : --");
    }


    public String madeCarResult(Car car) {
        StringBuilder madeResult = new StringBuilder();
        madeResult.append(car.getName()).append(COLONE);
        for(int i=0; i<car.getMoveCount(); i++){
            madeResult.append(TRACE);
        }
        return madeResult.toString();
    }




}