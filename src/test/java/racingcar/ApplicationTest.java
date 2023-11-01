package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.support.ReflectionSupport;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.util.Validator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.PATH;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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


    @Nested
    class CarTest {
        @Test
        @DisplayName("toString 재정의, 전진 테스트")
        public void toStringTest() {
            Car pobi = new Car("pobi");
            String result = "pobi : --";
            pobi.moveAdvance(5);
            pobi.moveAdvance(5);

            assertThat(pobi.toString()).isEqualTo(result);
        }

        @Test
        @DisplayName("랜덤한 수에 따라 전진해도 되는지 확인")
        public void isOkayToGoForwardTest() {
            Car car = new Car("철수");

            assertThat(car.isOkayToGoForward(6))
                    .isEqualTo(true);
            assertThat(car.isOkayToGoForward(3))
                    .isEqualTo(false);
        }

    }

    @Nested
    class ValidatorTest {

        @Test
        @DisplayName("숫자이외의 문자가 들어오면 예외 테스트")
        void validateNumericInputTest() {
            assertThatThrownBy(() -> Validator.validateNumericInput("avb"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자를 입력해");
        }

        @Test
        @DisplayName("올바른 입력값 테스트(예외 던지기)")
        void validateNames_Exception_Test() {
            String carNames = "pobi,woni,jun,dragon,김테스트";
            assertThatThrownBy(() ->
                    Validator.validateCarNames(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 값을");
        }

        @Test
        @DisplayName("올바른 입력값 테스트(올바른 입력일 경우)")
        void validateNames_Normal_Test() {
            String carNames = "rambo,pubao,fire,sony";
            Assertions.assertDoesNotThrow(() ->
                    Validator.validateCarNames(carNames));
        }


    }

    @Nested
    class RacingTest {

        //        static 메소드 mocking을 위한 MockedStatic객체 생성
        private static MockedStatic<Console> consoleMock;

        //        리플렉션으로 private 메소드 테스트하기
        static Constructor<?> racingConstructor = null;
        static Racing racingObj = null;


        @BeforeAll
        public static void beforeALl() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            consoleMock = mockStatic(Console.class);

            racingConstructor = Racing.class.getDeclaredConstructor(List.class);
//            private 생성자 접근 허용
            racingConstructor.setAccessible(true);

            racingObj = (Racing) racingConstructor.newInstance(List.of(new Car("kia"),
                    new Car("rambo")));
        }

        @AfterAll
        public static void afterAll() {
            consoleMock.close();
        }

        @Test
        @DisplayName("레이싱에서 자동차 이름 리스트 만들기")
        void Test() {

//            static 메소드 스터빙
            given(Console.readLine()).willReturn("pobi,woni,jun");

            String result = "pobi : \nwoni : \njun : \n";

            Racing racing = Racing.registerCarList();

            assertThat(racing.toString())
                    .isEqualTo(result);
        }

        @Test
        @DisplayName("가장 많이 전진한 횟수 구하기")
        void getMaxAdvanceCount_Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            List<Car> carList = List.of(new Car("pobi")
                    , new Car("taxi")
                    , new Car("bus"));
            carList.get(1).moveAdvance(7);
            carList.get(1).moveAdvance(7);

//            리플렉션으로 private 메소드 가져오기
            Method targetMethod = Racing.class
                    .getDeclaredMethod("getMaxAdvanceCount",
                            List.class);
//            private 메소드 접근 허용
            targetMethod.setAccessible(true);

            assertThat((int) targetMethod.invoke(racingObj, carList))
                    .isEqualTo(2);
        }

        @Test
        @DisplayName("레이싱 우승자 명단 만들기")
        void getWinner_Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            List<Car> carList = List.of(new Car("pobi")
                    , new Car("taxi")
                    , new Car("bus"));

            //            리플렉션으로 private 메소드 가져오기
            Method targetMethod = Racing.class
                    .getDeclaredMethod("getWinner",
                            List.class);
//            private 메소드 접근 허용
            targetMethod.setAccessible(true);

            String result = "pobi, taxi, bus";

            assertThat(targetMethod.invoke(racingObj, carList))
                    .isEqualTo(result);
        }

        @Test
        @DisplayName("레이싱 시작 테스트")
        void racingStart_Test() {
//            사용자 입력부분 스터빙
            given(Console.readLine()).willReturn("4");

//            리플렉션으로 생성한 인스턴스를 스파이로 감싼다
            Racing racingSpy = spy(racingObj);

            racingSpy.racingStart();

            verify(racingSpy, times(4)).raceOneStep();

        }


    }


}
