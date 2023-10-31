package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Number;
import racingcar.util.TestUtil;

class RacingCarGameTest extends NsTest {
    static final String[] TEST_CAR_NAME = {"Car1", "Car2", "Car3"}; // 자동차 이름
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    RacingCarGame racingCarGame;

    @BeforeEach
    void setup() {
        this.racingCarGame = new RacingCarGame();
    }

    @DisplayName("유저 이름 읽기")
    @Test
    void readUserNames() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // then
        final String inputNames = TestUtil.stringArrayToString(TEST_CAR_NAME);
        Method method = getAccessibleMethod("readUserNames");
        run(inputNames);

        // when 메소드를 실행한다.
        String[] names = (String[]) method.invoke(racingCarGame);

        // then
        assertThat(names).isEqualTo(TEST_CAR_NAME);
    }

    @DisplayName("자동차 만들기")
    @Test
    void createCars() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Method method = getAccessibleMethod("createCars", String[].class);

        // when 메소드를 실행한다.
        Car[] resultCar = (Car[]) method.invoke(racingCarGame, (Object) TEST_CAR_NAME);

        // then
        assertThat(resultCar).hasSameSizeAs(TEST_CAR_NAME); // 반환된 배열의 크기가 입력 크기와 같은지 확인
        for (int i = 0; i < resultCar.length; i++) {
            Car car = resultCar[i];
            assertThat(car.getName()).isEqualTo(TEST_CAR_NAME[i]); // 각 Car 객체의 이름이 기대하는 이름과 같은지 확인
        }
    }

    @DisplayName("너무 긴 길이의 이름으로 자동차 만들기")
    @Test
    void createCarsThrowCase1() throws NoSuchMethodException {
        // given
        String[] name = {"123456"};
        Method method = getAccessibleMethod("createCars", String[].class);

        // when, then
        assertThatThrownBy(() -> {
            method.invoke(racingCarGame, (Object) name);
        })
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 이름으로 자동차 만들기")
    @Test
    void createCarsThrowCase2() throws NoSuchMethodException {
        // given
        String[] name = {""};
        Method method = getAccessibleMethod("createCars", String[].class);

        // when, then
        assertThatThrownBy(() -> {
            method.invoke(racingCarGame, (Object) name);
        })
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("진행 횟수 입력 받기")
    @Test
    void readFullRound()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        final String fullRound = "3";
        final int fullRoundNum = Integer.parseInt(fullRound);
        Method method = getAccessibleMethod("readFullRound");

        // when
        run(fullRound);
        Number round = (Number) method.invoke(racingCarGame);

        // then 정상적으로 처리되어 반환했는지 확인
        assertThat(round.getNumber()).isEqualTo(fullRoundNum);
    }

    @DisplayName("잘못된 진행 횟수 입력 받기: 0")
    @Test
    void readFullRoundThrowCase1()
            throws NoSuchMethodException {
        // given
        final String fullRound = "0";
        Method method = getAccessibleMethod("readFullRound");

        // when, then
        run(fullRound);
        assertThatThrownBy(() -> {
            Number round = (Number) method.invoke(racingCarGame);
        })
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 진행 횟수 입력 받기: -1 (음수)")
    @Test
    void readFullRoundThrowCase2()
            throws NoSuchMethodException, NoSuchFieldException {
        // given
        final String fullRound = "-1";
        Method method = getAccessibleMethod("readFullRound");

        // when, then
        run(fullRound);
        assertThatThrownBy(() -> {
            Number round = (Number) method.invoke(racingCarGame);
        })
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 진행 횟수 입력 받기: 문자열")
    @Test
    void readFullRoundThrowCase3()
            throws NoSuchMethodException, NoSuchFieldException {
        // given
        final String fullRound = "일";
        Method method = getAccessibleMethod("readFullRound");

        // when, then
        run(fullRound);
        assertThatThrownBy(() -> {
            Number round = (Number) method.invoke(racingCarGame);
        })
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("준비가 되었는지 확인한다.")
    @Test
    void checkReady() throws NoSuchMethodException {
        // given
        Method method = getAccessibleMethod("checkReady");

        assertThatThrownBy(() -> {
            method.invoke(racingCarGame);
        })
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(RuntimeException.class);
    }

    @DisplayName("한 라운드가 정상적으로 잘 되는지 확인")
    @Test
    void oneRound() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        // given
        setTestCar(new Car[]{new Car("car1"), new Car("car2")});
        Method method = getAccessibleMethod("oneRound");

        // when, then
        assertRandomNumberInRangeTest(
                () -> {
                    method.invoke(racingCarGame);
                    assertThat(output()).contains("car1 : ", "car2 : -");
                },
                STOP, MOVING_FORWARD
        );

    }

    @DisplayName("승리 결과가 정상 출력되는지 확인한다. (1명)")
    @Test
    void printResultCase1()
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.increaseAdvance();
        setTestCar(new Car[]{car1, car2});
        Method method = getAccessibleMethod("printResult");

        // when, then
        method.invoke(racingCarGame);
        assertThat(output()).contains("최종 우승자 : car1");
    }

    @DisplayName("승리 결과가 정상 출력되는지 확인한다. (여러명)")
    @Test
    void printResultCase2()
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.increaseAdvance();
        car2.increaseAdvance();
        setTestCar(new Car[]{car1, car2});
        Method method = getAccessibleMethod("printResult");

        // when, then
        method.invoke(racingCarGame);
        assertThat(output()).contains("최종 우승자 : car1, car2");
    }

    /**
     * 생성한 자동차들을 설정한다.
     *
     * @param cars 필드를 통해 설정할 자동차들
     * @return field를 반환
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private Field setTestCar(Car[] cars) throws NoSuchFieldException, IllegalAccessException {
        Field field = getAccessibleField("cars");
        field.set(racingCarGame, cars);

        return field;
    }

    private Field getAccessibleField(String variableName) throws NoSuchFieldException {
        Field field = racingCarGame.getClass().getDeclaredField(variableName);
        field.setAccessible(true);

        return field;
    }

    private Method getAccessibleMethod(String methodName, Class<?>... parameterTypes)
            throws NoSuchMethodException {
        Method method = racingCarGame.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);

        return method;
    }

    @Override
    public void runMain() {
    }
}