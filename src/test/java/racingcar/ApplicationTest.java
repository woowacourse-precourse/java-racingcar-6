package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static racingcar.utils.Constants.MOVING_FORWARD;
import static racingcar.utils.Constants.STOP;
import static racingcar.utils.Constants.UPPER_LIMIT_OF_DIGIT;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.gameLogic.Driver;
import racingcar.gameLogic.RaceOfficial;
import racingcar.gameLogic.RacingCar;
import racingcar.gameLogic.User;
import racingcar.utils.InputValidator;
import racingcar.utils.RandomNumbers;
import racingcar.views.OutputViewer;

class ApplicationTest extends NsTest {

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

    /*
    아래부터 docs에 명시된 기능들(1번부터 15번까지)을 검증하는 테스트 코드입니다.
     */
    @Test
    @DisplayName("기능 1번: 시작문구 출력되는지 테스트")
    void 시작문구_출력함수_확인() {
        OutputViewer.printRequestingCarName();

        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("기능 2번: 차 이름 입력되는지 테스트")
    void 자동차_이름_입력_확인() {
        User user = new User();

        command("pobi, jun,kim ,po bi");
        List<String> carNames = user.inputCarName();

        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        assertThat(carNames).containsExactly("pobi", "jun", "kim", "po bi");

        Console.close();
    }

    @Test
    @DisplayName("기능 3번: 차 이름 검증되는지 테스트")
    void 자동차_이름_입력_검증_확인() {
        User user = new User();

        List<String> emptyList = new ArrayList<>();
        List<String> duplicatedNameList = new ArrayList<>(List.of("pobi", "pobi", "jun"));
        String nameOverFiveLength = "poobii";
        String nameUnderOneLength = "";
        String correctInput = "pobi,jun,kim,po bi, abc,aaa ";

        assertThatThrownBy(() -> InputValidator.validateNumberOfCars(emptyList.size()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1대 이상의 차량을 입력하세요.");

        assertThatThrownBy(() -> InputValidator.validateIsNamesDistinct(duplicatedNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않는 이름들을 입력하세요.");

        assertThatThrownBy(() -> InputValidator.validateNameLength(nameOverFiveLength.length()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1자 이상, 5자이하의 이름을 입력하세요.");

        assertThatThrownBy(() -> InputValidator.validateNameLength(nameUnderOneLength.length()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1자 이상, 5자이하의 이름을 입력하세요.");

        command(correctInput);
        assertThatCode(user::inputCarName)
                .doesNotThrowAnyException();
        Console.close();

    }

    @Test
    @DisplayName("기능 4번: Driver클래스 생성 잘되는지 테스트")
    @SuppressWarnings("unchecked")
    void 차량_생성_확인()
            throws IllegalAccessException, NoSuchFieldException {
        RacingCar racingCar = new RacingCar();
        RaceOfficial raceOfficial = new RaceOfficial();
        racingCar.init();

        Field drivers = RacingCar.class.getDeclaredField("drivers");
        drivers.setAccessible(true);

        List<String> carNamesTest = new ArrayList<>(List.of("pobi", "jun"));
        List<Driver> driversTest = (List<Driver>) drivers.get(racingCar);
        List<Driver> correctList = new ArrayList<>(
                List.of(new Driver("pobi"), new Driver("jun"))
        );
        raceOfficial.enrollDrivers(driversTest, carNamesTest);

        // RacingCar내부의 drivers 리스트에 driver가 잘 추가되었는지 크기와 요소의 이름 값 비교를 통해 검증
        assertThat(driversTest.size()).isEqualTo(correctList.size());

        Driver pobiTest = driversTest.get(0);
        Driver pobiCorrect = correctList.get(0);
        Driver junTest = driversTest.get(1);
        Driver junCorrect = correctList.get(1);

        assertThat(pobiTest.sayCarName()).contains(pobiCorrect.sayCarName());
        assertThat(junTest.sayCarName()).contains(junCorrect.sayCarName());
    }

    @Test
    @DisplayName("기능 5번: 시도횟수 요청문구 출력되는지 테스트")
    void 시도횟수_요청문구_출력함수_확인() {
        OutputViewer.printRequestingNumberOfTry();

        assertThat(output()).contains("시도할 회수는 몇회인가요?");
    }

    @Test
    @DisplayName("기능 6번: 시도횟수 입력되는지 테스트")
    void 시도횟수_입력_확인() {
        User user = new User();
        int numberOfTry;

        command(" 5 ");
        numberOfTry = user.inputNumberOfTry();

        assertThat(output()).contains("시도할 회수는 몇회인가요?");
        assertThat(numberOfTry).isEqualTo(5);

        Console.close();
    }

    @Test
    @DisplayName("기능 7번: 시도횟수 검증되는지 테스트")
    void 시도횟수_입력_검증_확인() {
        User user = new User();

        String notNumberInput = "12a";
        int notNaturalNumber = 0;
        String correctInput = " 123 ";

        assertThatThrownBy(() -> InputValidator.validateIsInputNumber(notNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수가 아닌 숫자를 입력하세요.(숫자 사이 공백 불가)");

        assertThatThrownBy(() -> InputValidator.validateIsNaturalNumber(notNaturalNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1이상인 자연수를 입력해야합니다.");

        command(correctInput);
        assertThatCode(user::inputNumberOfTry)
                .doesNotThrowAnyException();
        Console.close();
    }

    @Test
    @DisplayName("기능 8번: 난수가 0이상 9이하인지 테스트")
    void 난수_생성_범위_확인() {
        int numberOfTry = 0;

        while (numberOfTry < 10000) {
            int randomNumber = RandomNumbers.generateZeroToNineDigit();
            assertThat(randomNumber).isNotNegative();
            assertThat(randomNumber).isLessThanOrEqualTo(UPPER_LIMIT_OF_DIGIT);
            numberOfTry++;
        }

    }

    @Test
    @DisplayName("기능 9번: 4이상이면 참, 아니면 거짓이 잘나오는지 테스트")
    void 전진_여부_결정_확인()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Driver driver = new Driver("test");
        Method canMove = Driver.class.getDeclaredMethod("canMove");
        canMove.setAccessible(true);

        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(RandomNumbers::generateZeroToNineDigit)
                    .thenReturn(MOVING_FORWARD, STOP);

            assertThat(canMove.invoke(driver)).isEqualTo(true);
            assertThat(canMove.invoke(driver)).isEqualTo(false);
        }
    }

    @Test
    @DisplayName("기능 10번: 차량 전진/정지 기능 확인")
    void 차량_전진_확인() {
        Driver driver = new Driver("test");
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(RandomNumbers::generateZeroToNineDigit)
                    .thenReturn(MOVING_FORWARD, STOP);

            driver.pushPedal();// 난수: 4, 전진
            assertThat(driver.sayMovedDistance()).isEqualTo(1);
            driver.pushPedal();// 난수: 3, 정지
            assertThat(driver.sayMovedDistance()).isEqualTo(1);
        }

    }

    @Test
    @DisplayName("기능 11번: 결과 출력 암시 문구 출력되는지 확인")
    void 암시_문구_출력_확인() {
        OutputViewer.printNoticeResultWillBePrinted();
        assertThat(output()).contains("실행 결과");
    }

    @Test
    @DisplayName("기능 12번: 차량 별 이동거리 출력 확인")
    void 차량_이동거리_출력_확인() {
        String name1 = "pobi";
        String name2 = "jun";
        String name3 = "kim";

        int distance1 = 2;
        int distance2 = 1;
        int distance3 = 0;

        OutputViewer.printMovedDistanceOfCar(name1, distance1);
        assertThat(output()).contains("pobi : --");

        OutputViewer.printMovedDistanceOfCar(name2, distance2);
        assertThat(output()).contains("jun : -");

        OutputViewer.printMovedDistanceOfCar(name3, distance3);
        assertThat(output()).contains("kim :");
    }

    @Test
    @DisplayName("기능 13.1: 경주 진행 확인")
    void 경주_진헹_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains(
                            "pobi : -", "woni : "
                            , "pobi : --", "woni : -"
                            , "pobi : ---", "woni : -"
                    );
                },
                MOVING_FORWARD, STOP
                , MOVING_FORWARD, MOVING_FORWARD
                , MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("기능 13.2: 최대 이동거리 추적 확인")
    void 최대_이동거리_추적확인() {
        RaceOfficial raceOfficial = new RaceOfficial();
        List<Driver> drivers = new ArrayList<>(
                Arrays.asList(new Driver("pobi"), new Driver("woni"))
        );

        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(RandomNumbers::generateZeroToNineDigit)
                    .thenReturn(MOVING_FORWARD, STOP);
            for (Driver driver : drivers) {
                driver.pushPedal();
                raceOfficial.setHighestScore(driver);
            }
            assertThat(raceOfficial.showHighestScore()).isEqualTo(1);
        }

    }

    @Test
    @DisplayName("기능 14번: 우승자 판별 확인")
    void 우승자_판별_확인()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        RaceOfficial raceOfficial = new RaceOfficial();
        List<Driver> drivers = new ArrayList<>(
                Arrays.asList(new Driver("pobi"), new Driver("woni"))
        );
        Method determineWinners = RaceOfficial.class.getDeclaredMethod("determineWinners", List.class);
        determineWinners.setAccessible(true);

        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(RandomNumbers::generateZeroToNineDigit)
                    .thenReturn(MOVING_FORWARD, MOVING_FORWARD);
            for (Driver driver : drivers) {
                driver.pushPedal();
                raceOfficial.setHighestScore(driver);
            }
            determineWinners.invoke(raceOfficial, drivers);
            assertThat(raceOfficial.showWinnerList()).containsExactly("pobi", "woni");
        }
    }

    @Test
    @DisplayName("기능 15번: 우승자들 출력 확인")
    void 우승자_명단_출력_확인() {
        List<String> winners = new ArrayList<>(
                Arrays.asList("pobi", "woni", "jun")
        );
        OutputViewer.printWinners(winners);
        assertThat(output()).contains("최종 우승자 : pobi, woni, jun");
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
