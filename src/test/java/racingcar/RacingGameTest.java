package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.Car;
import racingcar.game.car.CarFactory;
import racingcar.game.director.Director;
import racingcar.game.director.Round;
import racingcar.game.director.Simulator;
import racingcar.game.exception.IllegalBlankException;
import racingcar.game.exception.IllegalDuplicateException;
import racingcar.game.exception.IllegalLengthException;
import racingcar.game.exception.IllegalRangeException;
import racingcar.game.exception.IllegalTypeException;
import racingcar.game.inputgenerateManager.InputGenerateManager;
import racingcar.game.outputgeneratemanager.OutputGenerateManager;

class RacingGameTest extends NsTest {

    private static final String CAR_NAMES = "car1,car2,car3";
    private static final String STRING_REPEAT_COUNT = "5";
    private static final Integer INTEGER_REPEAT_COUNT = 5;
    private static final List<String> CAR_NAME_LIST = Arrays.asList("car1", "car2", "car3");

    @Test
    void 디렉터_호출_확인() {
        //given
        InputGenerateManager inputGenerateManager = Mockito.mock(InputGenerateManager.class);
        OutputGenerateManager outputGenerateManager = Mockito.mock(OutputGenerateManager.class);
        Simulator simulator = Mockito.mock(Simulator.class);
        CarFactory carFactory = Mockito.mock(CarFactory.class);
        Director director = Mockito.mock(Director.class);
        RacingGame racingGame = new RacingGame(director);

        Mockito.when(inputGenerateManager.generateInputStringSplitWithComma(CAR_NAMES)).thenReturn(CAR_NAME_LIST);
        Mockito.when(inputGenerateManager.generateInputStringToInt(STRING_REPEAT_COUNT))
                .thenReturn(INTEGER_REPEAT_COUNT);
        List<Car> cars = carFactory.createCars(CAR_NAME_LIST);
        Round mockRound = Mockito.mock(Round.class);
        Mockito.when(simulator.perRound(cars)).thenReturn(mockRound);

        ByteArrayInputStream in = new ByteArrayInputStream(
                (CAR_NAMES + System.lineSeparator() + STRING_REPEAT_COUNT).getBytes());
        System.setIn(in);

        //when
        racingGame.start();

        //then
        Mockito.verify(director).startProcess();

        System.setIn(System.in);
    }

    private final static String NORMAL_STRING_NAME = "한놈,두식이,석삼";
    private final static String ONLY_BLANK = " ";
    private final static String STRING_NAMES_CONTAIN_OVER_LENGTH = "한놈,두식이,다섯글자이상";
    private final static String STRING_NAMES_CONTAIN_SPACE = "한놈,두식이, ";
    private final static String STRING_NAMES_CONTAIN_DUPLICATE_NAME = "한놈,두식이,한놈";
    private final static String ONLY_STRING = "onlyString";
    private final static String OVER_VALUE = "99999999999999999";

    @Test
    void 이름입력시_공백만_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(" ")).isInstanceOf(IllegalBlankException.class));
    }

    @Test
    void 이름입력시_글자수_초과() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(STRING_NAMES_CONTAIN_OVER_LENGTH)).isInstanceOf(
                IllegalLengthException.class));
    }

    @Test
    void 이름입력시_누락() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(STRING_NAMES_CONTAIN_SPACE)).isInstanceOf(
                IllegalBlankException.class));
    }

    @Test
    void 이름입력시_중복() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(STRING_NAMES_CONTAIN_DUPLICATE_NAME)).isInstanceOf(
                IllegalDuplicateException.class));
    }

    @Test
    void 횟수입력시_타입() {
        assertSimpleTest(() -> assertThatThrownBy(
                () -> runException(NORMAL_STRING_NAME + System.lineSeparator() + ONLY_STRING)).isInstanceOf(
                IllegalTypeException.class));
    }

    @Test
    void 횟수입력시_공백() {
        assertSimpleTest(() -> assertThatThrownBy(
                () -> runException(NORMAL_STRING_NAME + System.lineSeparator() + ONLY_BLANK)).isInstanceOf(
                IllegalTypeException.class));
    }

    @Test
    void 횟수입력시_큰값() {
        assertSimpleTest(() -> assertThatThrownBy(
                () -> runException(NORMAL_STRING_NAME + System.lineSeparator() + OVER_VALUE)).isInstanceOf(
                IllegalRangeException.class));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}