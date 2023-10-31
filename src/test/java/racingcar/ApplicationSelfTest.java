package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.controller.RaceController;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.model.Race;
import racingcar.util.Constants;
import racingcar.util.Convertor;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ApplicationSelfTest {

    public static CarList carListTest;
    public static Race raceTest;
    public static RaceController raceControllerTest;

    @BeforeEach
    public void setUp() {
        carListTest = new CarList();
        raceTest = new Race(carListTest);
        raceControllerTest = new RaceController(carListTest, raceTest);
    }



    @Test
    void 자동차_이름_입력() {
        String carNames = "권쵸파,권루피,권조로";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        InputStream in = new ByteArrayInputStream(carNames.getBytes());
        System.setIn(in);

        String carName = InputView.inputString(Constants.INPUT_CAR_NAME);

        assertThat(carName).isInstanceOf(String.class);
    }

    @Test
    void Convertor_콤마_구분_테스트() {

        String carName = "권쵸파,권루피,권조로";

        List<String> result = Convertor.splitCarNamesByComma(carName);

        assertThat(result).containsExactly("권쵸파", "권루피", "권조로");
    }

    @Test
    void Validator_자동차_목록_2개이상_아니면_예외처리() {

        List<String> carNameList = new ArrayList<>();

        carNameList.add("권쵸파");

        assertThatThrownBy(() -> Validator.checkCarNameListSize(carNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_전체공백_예외처리() {

        List<String> carNameList = new ArrayList<>();

        carNameList.add("권쵸파");
        carNameList.add("     ");
        carNameList.add("권루피");

        assertThatThrownBy(() -> Validator.checkCarNameEmpty(carNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_5자_초과_예외처리() {

        List<String> carNameList = new ArrayList<>();

        carNameList.add("1");
        carNameList.add("123");
        carNameList.add("12345");
        carNameList.add("123456");

        assertThatThrownBy(() -> Validator.checkCarNameLength(carNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전진_횟수_문자_예외처리() {
        assertThatThrownBy(() -> Validator.containsOnlyNumbers("하나"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_및_자동차_목록_생성_테스트() {
        List<String> carNameList = new ArrayList<>();
        carNameList.add("권루피");
        carNameList.add("권조로");
        carNameList.add("권쵸파");

        carListTest.generateCar(carNameList);

        List<Car> resultCarList = carListTest.getCarList();
        assertThat(resultCarList)
                .allSatisfy(car -> assertThat(car).isInstanceOf(Car.class))
                .extracting(Car::getCarName)
                .containsExactlyElementsOf(carNameList);
    }

    @Test
    void 전진_회차마다_자동차_전진상황_표현_테스트() {

        List<String> carNameList = new ArrayList<>();
        carNameList.add("권루피");
        carNameList.add("권조로");

        carListTest.generateCar(carNameList);

        Car carLuffy = carListTest.getCarList().get(0);
        carLuffy.move();
        carLuffy.move();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView.currentRacingView(carListTest);

        String output = outContent.toString();
        assertThat(output).contains("권루피 : -", "권조로 : ");

        System.setOut(System.out);
    }

    @Test
    void 랜덤_값이_4_이상_자동차_전진() {

        MockedStatic<RandomNumberGenerator> mockRandom = Mockito.mockStatic(RandomNumberGenerator.class);

        mockRandom.when(RandomNumberGenerator::randomNumber).thenReturn(4);

        List<String> carNameList = new ArrayList<>();
        carNameList.add("권루피");
        carNameList.add("권조로");

        carListTest.generateCar(carNameList);

        System.out.println(carListTest.getCarList());

        raceTest.moveForward();

        for (Car car : carListTest.getCarList()) {
            assertThat(car.getMoveCount()).isEqualTo(1);
        }
    }
}
