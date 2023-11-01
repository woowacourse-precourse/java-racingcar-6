package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();
    private static final int MOVING_FORWARD = 5;
    private static final int STOP = 3;

    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut; // 표준 스트림

    @BeforeEach
    void setUp() {
        standardOut = System.out; // 표준 스트림 초기화
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }

    @Test
    void createCarTest() {
        //given
        String carName1 = "lee";
        String carName2 = "juho";
        String carName3 = "test";
        List<String> carNames = Arrays.asList(carName1, carName2, carName3);
        //when
        List<Car> carList = game.createCar(carNames);
        //then
        for (int i = 0; i < carList.size(); i++) {
            Car createdCar = carList.get(i);
            String carName = carNames.get(i);

            assertThat(createdCar.getName()).isEqualTo(carName);
        }
    }

    @Test
    void distanceOutputTest() {
        //given
        int movingCount = 5;
        String carName = "lee";
        Car car = new Car(carName);
        StringBuilder stringBuilder = new StringBuilder(carName + " : ");
        for (int i = 0; i < movingCount; i++) {
            stringBuilder.append("-");
            car.run(MOVING_FORWARD);
        }

        //when
        game.distanceOutput(car);
        //then
        assertThat(getOutput()).contains(stringBuilder.toString());
    }

    @Test
    void sameCarNameValidation_자동차_이름이_전부_다른_경우() {
        //given
        String carName1 = "lee";
        String carName2 = "juho";
        String carName3 = "test";
        List<String> carNames = Arrays.asList(carName1, carName2, carName3);
        //when
        game.sameCarNameValidation(carNames);
        //then
    }

    @Test
    void sameCarNameValidation_자동차_이름이_하나라도_같은경우() {
        //given
        String carName1 = "lee";
        String carName2 = "test";
        String carName3 = "test";
        List<String> carNames = Arrays.asList(carName1, carName2, carName3);
        //when
        //then
        assertThatThrownBy(() -> game.sameCarNameValidation(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Util.OutputMessage.SAME_CAR_NAME_ERROR_MESSAGE.getMessage());
    }

    @Test
    void attemptValidation_문자_입력_된_경우() {
        //given
        String inputAttempt = "a";
        //when
        //then
        assertThatThrownBy(() -> game.attemptValidation(inputAttempt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Util.OutputMessage.ATTEMPT_VALUE_ERROR_MESSAGE.getMessage());
    }

    @Test
    void attemptValidation_0_입력_된_경우() {
        //given
        String inputAttempt = "0";
        //when
        //then
        assertThatThrownBy(() -> game.attemptValidation(inputAttempt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Util.OutputMessage.ATTEMPT_VALUE_ERROR_MESSAGE.getMessage());
    }

    @Test
    void attemptValidation_1_이상_입력_된_경우() {
        //given
        String inputAttempt = "3";
        //when
        game.attemptValidation(inputAttempt);
        //then
    }
}