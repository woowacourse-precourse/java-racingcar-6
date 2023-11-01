package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import racingcar.model.Car;

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

    @Test
    void 경주할_자동차_이름을_입력하는_메시지_출력() {
        final String expected = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        Application.printInputCarNameMessage();
        assertThat(output()).contains(expected);
    }

    @Test
    void 경주할_자동차_이름을_입력() {
        final String expected = "pobi,woni,jun";

        try (MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine()).thenReturn(expected);
            final String actual = Application.readCarNames();
            assertThat(actual).contains(expected);
        }
    }

    @Test
    @DisplayName("자동차 이름은 쉼표로 구분한다.")
    void 자동차_이름을_쉼표로_구분하여_이름_배열을_만듦() {
        final List<String> expected = List.of("pobi", "woni", "jun");
        final List<String> actual = Application.getCarNameListFromCarNames("pobi,woni,jun");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("각 자동차 이름의 좌우 공백을 제거한다.")
    void getCarNameListFromCarNames_메서드에서_trim_메소드로_좌우_공백을_제거() {
        final List<String> expected = List.of("pobi", "woni", "jun");

        final String actualInput = " pobi,woni, jun ";
        final List<String> actual = Application.getCarNameListFromCarNames(actualInput);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getCarNameListFromCarNames_메서드에서_받은_리스트는_수정이_불가능() {
        final List<String> carNameList = Application.getCarNameListFromCarNames("pobi,woni,jun");
        assertThatThrownBy(() -> carNameList.set(0, "daram"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 자동차_이름_목록으로_자동차_객체_목록_생성() {
        final List<Car> expected = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        final List<String> carNameList = List.of("pobi", "woni", "jun");
        final List<Car> actual = Application.getCarList(carNameList);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 시도할_회수를_물어보는_문구_출력() {
        final String expected = "시도할 회수는 몇회인가요?";
        Application.printInputTryCountMessage();
        assertThat(output()).contains(expected);
    }

    @Test
    @DisplayName("사용자에게 입력을 받아 몇 번 이동할 지 데이터로 저장한다.")
    void 시도할_회수를_입력() {
        final int expected = 5;

        try (MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine()).thenReturn(String.valueOf(expected));
            final int actual = Application.readTryCount();
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    @DisplayName("주어진 횟수를 입력할 때 숫자가 아닌 입력 시 예외를 일으킨다.")
    void 시도할_회수를_입력시_숫자가_아닌경우_예외() {
        final String expected = "가";

        try (MockedStatic<Console> mockConsole = mockStatic(Console.class)) {
            mockConsole.when(() -> Console.readLine()).thenReturn(expected);
            assertThatThrownBy(() -> Application.readTryCount())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 실행_결과_문구를_출력() {
        final String STRING_EXECUTION_RESULT = "실행 결과";
        Application.printExecutionResult();
        assertThat(output()).contains(STRING_EXECUTION_RESULT);
    }

    @Test
    @DisplayName("한 횟수 동안 N 대의 자동차는 전진 또는 멈춘다.")
    void Car_리스트_안에_있는_모든_Car를_앞으로_움직임() {
        final List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        final List<String> expected = List.of("-", "-", "");

        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP);

            Application.moveForward(carList);

            final List<String> actual = carList.stream()
                    .map(Car::getDistanceString)
                    .collect(Collectors.toList());

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    void Car_리스트_안에서_가장_멀리_간_Car_목록_생성() {
        final List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        final List<Car> expected = List.of(carList.get(0), carList.get(1));

        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP);

            Application.moveForward(carList);
            final List<Car> actual = Application.getCarListWithLongestDistance(carList);

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    void Car_리스트에서_최종_우승자_이름_목록_생성() {
        final List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        final String expected = "pobi, woni";

        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP);

            Application.moveForward(carList);
            final String actual = Application.getWinnersFromCarList(carList);

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.")
    void 최종_우승자를_출력() {
        final List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP);

            Application.moveForward(carList);
            Application.printWinnersFromCarList(carList);

            assertThat(output()).isEqualTo("최종 우승자 : pobi, woni");
        }
    }

    @Test
    void 모든_Car_목록의_경주_현황을_출력() {
        final List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP);

            Application.moveForward(carList);
            Application.printCarNameAndDistanceStringInCarList(carList);

            assertThat(output()).isEqualTo("pobi : -\nwoni : -\njun : ".trim());
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
