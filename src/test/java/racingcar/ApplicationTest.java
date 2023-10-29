package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
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
    void systemIn(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
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

    @Test
    void 자동차_이름_입력_정상(){
        systemIn("pobi,woni,jun,,");
        List<String> carNames = ioService.scanCarNames();
        assertEquals("pobi", carNames.get(0));
        assertEquals("woni", carNames.get(1));
        assertEquals("jun", carNames.get(2));
    }

    @Test
    void 자동차_이름_공백_입력_예외_테스트(){
        systemIn("\n");
        List<String> carNames;

        assertThatThrownBy(()->
                ioService.scanCarNames()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력_글자수_초과_테스트(){
        systemIn("pobi,woni,jun,lujaeeee");
        List<String> carNames;

        assertThatThrownBy(()->
                ioService.scanCarNames()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤_숫자_리스트_생성_테스트(){
        int size = 9;
        List<Integer> randomNumbers = NumberGenerator.createRandomNumbers(size);

        assertThat(randomNumbers).hasSize(size);
        randomNumbers.forEach(
                (number)->assertThat(number)
                        .isGreaterThanOrEqualTo(0)
                        .isLessThanOrEqualTo(9)
        );
    }

    @Test
    void 문자_자동차_현재_상태_출력_테스트(){
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

        try{
            Method selectWinners = GameService.class.getDeclaredMethod("selectWinners", List.class);
            selectWinners.setAccessible(true);

            List<Car> winners = (List<Car>)selectWinners.invoke(gameService, carList);

            assertThat(winners.get(0).getName()).isEqualTo("car1");
            assertThat(winners.get(1).getName()).isEqualTo("car3");
            assertThat(winners.get(2).getName()).isEqualTo("car4");
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch(IllegalAccessException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
    }

    @Test
    void 게임_우승자_출력_테스트(){
        List<String> nameList = List.of("youea1", "intell");

        IOService.printWinners(nameList);
        assertThat(output()).isEqualTo("최종 우승자 : youea1, intell");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
