package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.core.Core;
import racingcar.model.Car;
import racingcar.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void stringToStringList_테스트() {
        // given
        final Core core = new Core();
        String case1 = "pobi,woni,jun";
        String case2 = "kim,lee,park";
        String case3 = "james,tom,sam";

        // when
        final List<String> result1 =  core.stringToStringList(case1);
        final List<String> result2 =  core.stringToStringList(case2);
        final List<String> result3 =  core.stringToStringList(case3);

        // then
        assertThat(result1).isEqualTo(List.of("pobi", "woni", "jun"));
        assertThat(result2).isEqualTo(List.of("kim", "lee", "park"));
        assertThat(result3).isEqualTo(List.of("james", "tom", "sam"));
    }

    @Test
    void getCarListByCarNames_테스트() {
        // given
        Core core = new Core();
        final List<String> case1 = List.of("pobi", "woni", "jun");
        final List<String> case2 = List.of("kim", "lee", "park");
        final List<String> case3 = List.of("james", "sam", "tom");

        // when
        final List<Car> result1 = core.getCarListByCarNames(case1);
        final List<Car> result2 = core.getCarListByCarNames(case2);
        final List<Car> result3 = core.getCarListByCarNames(case3);

        // then
        assertThat(result1.get(0).getName()).isEqualTo("pobi");
        assertThat(result1.get(1).getName()).isEqualTo("woni");
        assertThat(result1.get(2).getName()).isEqualTo("jun");
        assertThat(result2.get(0).getName()).isEqualTo("kim");
        assertThat(result2.get(1).getName()).isEqualTo("lee");
        assertThat(result2.get(2).getName()).isEqualTo("park");
        assertThat(result3.get(0).getName()).isEqualTo("james");
        assertThat(result3.get(1).getName()).isEqualTo("sam");
        assertThat(result3.get(2).getName()).isEqualTo("tom");
    }

    @Test
    void countForward_테스트() {
        // given
        Core core = new Core();
        final Car case1 = Car.make("pobi", 4);
        final Car case2 = Car.make("woni", 3);
        final Car case3 = Car.make("jun", 2);

        // when
        final String result1 = core.countForward(case1);
        final String result2 = core.countForward(case2);
        final String result3 = core.countForward(case3);

        // then
        assertThat(result1).isEqualTo("----");
        assertThat(result2).isEqualTo("---");
        assertThat(result3).isEqualTo("--");
    }

    @Test
    void getWinner_테스트() {
        // given
        Core T = new Core();
        List<Car> case1 = List.of(Car.make("pobi", 3), Car.make("woni", 4), Car.make("jun", 1));
        List<Car> case2 = List.of(Car.make("kim", 2), Car.make("lee", 4), Car.make("park", 4));
        List<Car> case3 = List.of(Car.make("james", 5), Car.make("tom", 4), Car.make("sam", 3));

        // when
        final List<String> result1 = T.getWinner(case1);
        final List<String> result2 = T.getWinner(case2);
        final List<String> result3 = T.getWinner(case3);

        // then
        assertThat(result1).isEqualTo(List.of("woni"));
        assertThat(result2).isEqualTo(List.of("lee", "park"));
        assertThat(result3).isEqualTo(List.of("james"));
    }

    @Test
    void validateCarNameLength_정상처리_테스트() {
        // given
        final List<String> case1 = List.of("pobi", "woni", "jun");
        final List<String> case2 = List.of("kim", "le e", "park");
        final List<String> case3 = List.of("james", "tom", "Mr.Jo");

        // when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateCarNameLength(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateCarNameLength(case2);
        });
        final Throwable thrown3 = catchThrowable(() -> {
            Utils.validateCarNameLength(case3);
        });

        // then
        assertThat(thrown1).doesNotThrowAnyException();
        assertThat(thrown2).doesNotThrowAnyException();
        assertThat(thrown3).doesNotThrowAnyException();
    }

    @Test
    void validateCarNameLength_예외처리_테스트() {
        // given
        final List<String> case1 = List.of("stephanie", "james", "robinson");
        final List<String> case2 = List.of("kim", "Jon Doe", "park");
        final List<String> case3 = List.of("BMW", "Mercedes", "Pagani Zonda");

        // when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateCarNameLength(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateCarNameLength(case2);
        });
        final Throwable thrown3 = catchThrowable(() -> {
            Utils.validateCarNameLength(case3);
        });

        // then
        assertThat(thrown1).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하만 가능합니다.");
        assertThat(thrown2).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하만 가능합니다.");
        assertThat(thrown3).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void validateStringDigit_정상처리_테스트() {
        // given
        final String case1 = "5";
        final String case2 = "10";

        // when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateStringDigit(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateStringDigit(case2);
        });

        // then
        assertThat(thrown1).doesNotThrowAnyException();
        assertThat(thrown2).doesNotThrowAnyException();
    }

    @Test
    void validateStringDigit_예외처리_테스트() {
        // given
        final String case1 = "!2";
        final String case2 = "Not a Number";

        // when
        final Throwable thrown1 = catchThrowable(() -> {
            Utils.validateStringDigit(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            Utils.validateStringDigit(case2);
        });

        // then
        assertThat(thrown1).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
        assertThat(thrown2).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
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
}
