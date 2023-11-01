package myTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.ConstantAndGameLogic.GameLogic;
import racingcar.ConstantAndGameLogic.Message;
import racingcar.Model.Car;
import racingcar.View.Output;
import racingcar.View.User_Input;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 단독_우승자_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승자_처리(){
        assertRandomNumberInRangeTest(
        ()->{
            run("pobi,woni,hyeon", "3");
            assertThat(output()).contains("pobi : --", "woni : --", "hyeon : --");
        },
        STOP,MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD,
        MOVING_FORWARD,STOP,STOP);
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

    @Test
    void 거리에_대한_올바른_처리() {
        int location = 5;
        Output moving = new Output();
        String result = moving.Moving(location);

        assertEquals("-----",result);
    }

    @Test
    void 자동차의이름_올바르게_가져오기() {
        String carName = "Car1";
        Car car = new Car(carName);
        assertEquals(carName, car.getCarName());
    }

    @Test
    void 입력_공백처리(){
        User_Input user_input = new User_Input();
        String input ="pobi,,hyeon";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> user_input.checkNameSpace(input));
        assertEquals(Message.NAME_SPACE, exception.getMessage());
    }

    @Test
    public void 쉼표_처리() {
        User_Input user_input = new User_Input();
        String input = "pobi,woni,";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> user_input.checkCommaInput(input));
        assertEquals(Message.CAR_NAME_COMMA, exception.getMessage());
    }

    @Test
    public void 이동횟수_문자입력_판별() {
        User_Input user_input = new User_Input();
        String input = "InvalidInput";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> user_input.checkCountInput(input));
        assertEquals(Message.MUST_INPUT_NUMBER, exception.getMessage());
    }

    @Test
    public void 사용자_5글자_입력처리() {
        User_Input userinput = new User_Input();
        String input = "5";
        assertDoesNotThrow(() -> userinput.checkCountInput(input));
    }

    @Test
    public void 움직임_결정하기() {
        Car car = new Car("Car1");

        car.decisionToMove(3);
        assertEquals(0, car.getCurrentLocation());

        car.decisionToMove(4);
        assertEquals(1, car.getCurrentLocation());
    }

    @Test
    public void 차량_이름_등록() {
        GameLogic gameLogic = new GameLogic();
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");

        gameLogic.registerCarName(carNames);
        List<Car> cars = gameLogic.getCars();

        assertEquals(carNames.size(), cars.size());
        for (int i = 0; i < carNames.size(); i++) {
            assertEquals(carNames.get(i), cars.get(i).getCarName());
        }
    }

    @Test
    void 움직임_횟수_받기(){

        int inputCount = 10;
        GameLogic logic = new GameLogic();

        logic.registerMovingNumber(inputCount);
        int distance = logic.getMovingPosition();

        assertEquals(distance,inputCount);
    }

    @Test
    public void 올바른_게임진행() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.registerCarName(Arrays.asList("Car1", "Car2"));
        gameLogic.registerMovingNumber(5);

        for (int i = 0; i < 5; i++) {
            gameLogic.racingStart();
            List<Car> cars = gameLogic.getCars();
            assertTrue(cars.get(0).getCurrentLocation() >= 0);
            assertTrue(cars.get(1).getCurrentLocation() >= 0);
        }
    }
}
