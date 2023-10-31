package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    @Test
    void inputRacerName_6글자_이상_실패_테스트(){
        String input = "jinsoo, ori, asd";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Map<String, Integer> testMap = new LinkedHashMap<>();

        assertThatThrownBy(
                () -> {
                    Application.inputRacerName(testMap);
                }
        ).isInstanceOf(IllegalArgumentException.class);

        Console.close();
    }

    @Test
    void inputRacerName_공백_포함_문자열_정상수행_테스트(){
        String input = "pobi, aaa, php,    java";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Map<String, Integer> testMap = new LinkedHashMap<>();


        assertThatCode(
                () -> {
                    Application.inputRacerName(testMap);
                }
        ).doesNotThrowAnyException();

        Console.close();
    }


    @Test
    void inputRaceCount_경주_횟수에_문자열_추가시_실패_테스트(){
        String input = "1a1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(
                () -> {
                    Application.inputRaceCount();
                }
        ).isInstanceOf(IllegalArgumentException.class);

        Console.close();
    }


    @Test
    void race_경주_할때_Map에_값이_잘_반영되는지_테스트(){
        Map<String, Integer> testMap = new LinkedHashMap<>();
        testMap.put("js", 0);
        testMap.put("cal", 0);
        testMap.put("soso", 0);

        assertRandomNumberInRangeTest(
                () -> {
                    Application.race(testMap);
                    assertThat(testMap).contains(entry("js", 1), entry("cal", 0), entry("soso", 1));
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }


    @Test
    void outputCurrentRaceResult_정상적으로_값이_출력되는지_테스트(){
        Map<String, Integer> testMap = new LinkedHashMap<>();
        testMap.put("js", 2);
        testMap.put("cal", 1);
        testMap.put("soso", 3);

        assertThatCode(
                () -> {
                    Application.outputCurrentRaceResult(testMap);
                    assertThat(output()).contains(
                            "js : --",
                            "cal : -",
                            "soso : ---"
                    );
                }
        ).doesNotThrowAnyException();
    }


    @Test
    void outputWinner_최종_우승자_공동출력_성공_테스트(){
        Map<String, Integer> testMap = new LinkedHashMap<>();
        testMap.put("js", 2);
        testMap.put("cal", 1);
        testMap.put("soso", 2);


        assertThatCode(
                () -> {
                    Application.outputWinner(testMap);
                    assertThat(output()).contains(
                            "최종 우승자 : js, soso"
                    );
                }
        ).doesNotThrowAnyException();
    }
}
