package study;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.CarMap;
import racingcar.RacingGame;

import java.util.LinkedHashMap;

public class StringTest {

    private static final String carList = "pony,mad,max";
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private CarMap carMap;
    private RacingGame racingGame;

    @BeforeEach
    void setUp(){
        carMap = new CarMap(carList);
        racingGame = new RacingGame();
    }

    @Test
    void carMap_생성이_제대로_되나(){
        LinkedHashMap<String, String> result = carMap.getMap();

        assertThat(result).containsKey("pony").containsKey("mad").containsKey("max").containsValues("");
    }

    @Test
    void validateCarList_유효성_검사가_제대로_작동하나(){
        String input1 = "right,case,test";
        String input2 = null;
        String input3 = "";
        String input4 = "TooLong,case,test";

        boolean result = carMap.validateCarList(input1);
        assertThat(result).isEqualTo(true);

        assertThatThrownBy(() -> carMap.validateCarList(input2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> carMap.validateCarList(input3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> carMap.validateCarList(input4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"5,true","13,true"})
    public void validateTryTimes(String number, boolean expected){
        boolean actual = racingGame.validateTryTimes(number);
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void validateTryTimes_입력횟수_유효성검사가_제대로_작동하나(){
        String input = "문자열";
        assertThatThrownBy(() -> racingGame.validateTryTimes(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isGone_전진_정지_판단이_제대로되나(){
        assertRandomNumberInRangeTest(
            () -> {
                boolean result1 = racingGame.isGone();
                assertThat(result1).isEqualTo(true);
                boolean result2 = racingGame.isGone();
                assertThat(result2).isEqualTo(false);
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void CarMap_Go_전진하나() {
        String origin = carMap.getMap().get("pony");
        carMap.go("pony");
        String result = carMap.getMap().get("pony");
        assertThat(result).isEqualTo(origin+"-");
    }

    @Test
    void getFirstScore_1등점수_제대로_출력되나(){
        assertRandomNumberInRangeTest(
            () -> {
                racingGame.playGame(carMap,3);
                int result = racingGame.getFirstScore(carMap);
                assertThat(result).isEqualTo(2);
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void getResultString_결과가_제대로_출력되나(){
        assertRandomNumberInRangeTest(
            () -> {
                racingGame.playGame(carMap,3);
                String result = racingGame.getResultString(carMap, 2);
                assertThat(result).contains("최종 우승자 : pony");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

}
