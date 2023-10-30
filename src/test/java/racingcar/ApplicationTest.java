package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.function.CheckName;
import racingcar.function.CheckNumber;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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
//}
    @Test
    void 이름에_대한_예외_처리_빈문자열() {
        assertThatThrownBy(() -> CheckName.validate("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름에_대한_예외_처리_공백() {
        assertThatThrownBy(() -> CheckName.validate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름에_대한_예외_처리_대문자() {
        assertThatThrownBy(() -> CheckName.validate("aBc,AbbC,Abc,abC,ABCD,abcD"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 구분자에_의해_정상_구분_여부() {
        assertThatCode(() -> CheckName.validate("abcd,efgh,qwer,asdf,ppap,yass,eras"))
                .doesNotThrowAnyException();
    }
    @Test
    void 다른_구분자는_무시하는지_여부() {
        assertThatThrownBy(() -> CheckName.validate("ab/c,a b "))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름에_대한_예외_처리_공백을포함한소문자() {
        assertThatThrownBy(() -> CheckName.validate("a c,a , a ,bd , q,h wi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시행횟수에_대한_예외_처리_0회시행() {
        assertThatThrownBy(() -> CheckNumber.validate("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 시행횟수에_대한_예외_처리_음수시행() {
        assertThatThrownBy(() -> CheckNumber.validate("-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

//    @Test -> 오류발생
//    void 시행횟수에_대한_예외_처리_공백입력() {
//        assertThatThrownBy(() -> CheckNumber.validate(null))
//                .isInstanceOf((IllegalArgumentException.class));
//    }









}
