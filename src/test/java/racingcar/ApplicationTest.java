package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String ERROR_MESSAGE = "[ERROR]";

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
    void 이름에_대한_예외_처리_이름_길이() {
        Exception exception = assertThrows(Exception.class, () -> {
            runException("pobi,javaji","1");
        });
        assertFalse(output().contains(ERROR_MESSAGE));
    }


    @Test
    void 이름에_대한_예외_처리_이름_공백(){
        Exception exception = assertThrows(Exception.class, ()->{
            runException("pobi, ","1");
        });
        assertFalse(output().contains(ERROR_MESSAGE));
    }

    @Test
    void 이름에_대한_예외_처리_이름_중복(){
        Exception exception = assertThrows(Exception.class, ()->{
            runException("pobi,pobi","1");
        });
        assertFalse(output().contains(ERROR_MESSAGE));
    }

//    @Test
//    void 이름에_대한_예외_처리_이름에_문자열이_아닌_경우(){
//        Exception exception = assertThrows(Exception.class, ()->{
//            runException("pobi,123","1");
//        });
//        assertFalse(output().contains(ERROR_MESSAGE));
//    }

    @Test
    void 자동차에_대한_예외_처리(){

        Exception exception = assertThrows(Exception.class, ()->{
            runException(" ","1");
        });
        assertFalse(output().contains(ERROR_MESSAGE));
    }

    @Test
    void 시도_횟수에_대한_예외_처리(){
        Exception exception = assertThrows(Exception.class, ()->{
            runException("pobi,woni","one");
        });
        assertFalse(output().contains(ERROR_MESSAGE));
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
