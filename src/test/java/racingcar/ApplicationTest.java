package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private IOService ioService = new IOService();
    private GameService gameService = new GameService();
    
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
    void 자동차_이름_공백_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 랜덤_숫자_리스트_생성_테스트() {
        int size = 9;
        List<Integer> randomNumbers = NumberGenerator.createRandomNumbers(size);

        assertThat(randomNumbers).hasSize(size);
        randomNumbers.forEach(
                (number) -> assertThat(number)
                        .isGreaterThanOrEqualTo(0)
                        .isLessThanOrEqualTo(9)
        );
    }

    @Test
    void 숫자가_4_이상일때_자동차를_움직이는_테스트(){
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 2);
        Car car3 = new Car("car3", 3);
        Car car4 = new Car("car4", 3);

        List<Car> carList = List.of(car1, car2, car3, car4);

        try {
            Method process = GameService.class.getDeclaredMethod("process", List.class, List.class);
            process.setAccessible(true);

            process.invoke(gameService, carList, List.of(0, 4, 3, 9));

            assertThat(carList.get(0).getPos()).isEqualTo(3);
            assertThat(carList.get(1).getPos()).isEqualTo(3);
            assertThat(carList.get(2).getPos()).isEqualTo(3);
            assertThat(carList.get(3).getPos()).isEqualTo(4);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    void 자동차_이름_문자열_리스트가_주어졌을때_자동차_객체_리스트를_생성(){
        List<String> carNames = List.of("car1", "car2", "car3", "car4");

        try{
            Method createCarList = GameService.class.getDeclaredMethod("createCarList", List.class);
            createCarList.setAccessible(true);

            List<Car> carList = (List<Car>) createCarList.invoke(gameService, carNames);

            assertThat(carList.get(0).getName()).isEqualTo("car1");
            assertThat(carList.get(0).getPos()).isEqualTo(0);

            assertThat(carList.get(1).getName()).isEqualTo("car2");
            assertThat(carList.get(1).getPos()).isEqualTo(0);

            assertThat(carList.get(2).getName()).isEqualTo("car3");
            assertThat(carList.get(2).getPos()).isEqualTo(0);

            assertThat(carList.get(3).getName()).isEqualTo("car4");
            assertThat(carList.get(3).getPos()).isEqualTo(0);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void 자동차_현재_상태_출력_테스트() {
        Car car = new Car("youjae", 4);

        ioService.printCarState(car);
        assertThat(output()).isEqualTo("youjae : ----");
    }

    @Test
    void 게임_우승자_선택_테스트() throws NoSuchMethodException {
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 2);
        Car car3 = new Car("car3", 3);
        Car car4 = new Car("car4", 3);

        List<Car> carList = List.of(car1, car2, car3, car4);

        try {
            Method selectWinners = GameService.class.getDeclaredMethod("selectWinners", List.class);
            selectWinners.setAccessible(true);

            List<Car> winners = (List<Car>) selectWinners.invoke(gameService, carList);

            assertThat(winners.get(0).getName()).isEqualTo("car1");
            assertThat(winners.get(1).getName()).isEqualTo("car3");
            assertThat(winners.get(2).getName()).isEqualTo("car4");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    void 게임_우승자_출력_테스트() {
        List<String> nameList = List.of("youea1", "intell");

        ioService.printWinners(nameList);
        assertThat(output()).isEqualTo("최종 우승자 : youea1, intell");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
