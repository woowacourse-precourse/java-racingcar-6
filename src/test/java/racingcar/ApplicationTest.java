package racingcar;

//import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
//import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.gameLogic.Driver;
import racingcar.gameLogic.RacingCar;
import racingcar.gameLogic.User;
import racingcar.utils.InputValidator;
import racingcar.utils.RandomNumbers;
import racingcar.views.OutputViewer;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int UPPER_LIMIT_OF_DIGIT = 9;

//    @Test
//    void 전진_정지() {
//        assertRandomNumberInRangeTest(
//            () -> {
//                run("pobi,woni", "1");
//                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
//            },
//            MOVING_FORWARD, STOP
//        );
//    }
//
//    @Test
//    void 이름에_대한_예외_처리() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

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
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        RacingCar racingCar = new RacingCar();
        racingCar.init();

        Method setDrivers = RacingCar.class.getDeclaredMethod("setDrivers", List.class);
        setDrivers.setAccessible(true);

        Field drivers = RacingCar.class.getDeclaredField("drivers");
        drivers.setAccessible(true);
        List<Driver> driversTest = (List<Driver>) drivers.get(racingCar);

        List<Driver> correctList = new ArrayList<>(
                List.of(new Driver("pobi"), new Driver("jun"))
        );
        setDrivers.invoke(racingCar, new ArrayList<>(List.of("pobi", "jun")));

        // RacingCar내부의 drivers 리스트에 driver가 잘 추가되었는지
        assertThat(driversTest.size()).isEqualTo(correctList.size());

        Driver pobiTest = driversTest.get(0);
        Driver junTest = driversTest.get(1);
        Driver pobiCorrect = correctList.get(0);
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
                    .thenReturn(4, 3);

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
                    .thenReturn(4, 3);

            driver.pushPedal();// 난수: 4, 전진
            assertThat(driver.sayMovedDistance()).isEqualTo(1);
            driver.pushPedal();// 난수: 3, 정지
            assertThat(driver.sayMovedDistance()).isEqualTo(1);
        }

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
