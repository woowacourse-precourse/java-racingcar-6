package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.game.car.Car;
import racingcar.game.car.CarFactory;
import racingcar.game.director.Director;
import racingcar.game.director.Round;
import racingcar.game.director.Rule;
import racingcar.game.director.Simulator;
import racingcar.game.exception.IllegalBlankException;
import racingcar.game.exception.IllegalDuplicateException;
import racingcar.game.exception.IllegalLengthException;
import racingcar.game.exception.IllegalRangeException;
import racingcar.game.exception.IllegalTypeException;
import racingcar.game.inputgenerateManager.InputGenerateManager;
import racingcar.game.outputgeneratemanager.OutputGenerateManager;

class RacingGameTest extends NsTest {
    private static final String CAR_NAMES = "한놈,두식이,석삼";

    private static final String STRING_REPEAT_COUNT = "5";
    private static final Integer INTEGER_REPEAT_COUNT = 5;
    private static final List<String> CAR_NAME_LIST = Arrays.asList("한놈", "두식이", "석삼");

    @Test
    void 통합테스트() {
        //given
        InputStream originalSystemIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayInputStream inputContent = new ByteArrayInputStream(
                (CAR_NAMES + System.lineSeparator() + STRING_REPEAT_COUNT).getBytes());
        System.setIn(inputContent);
        System.setOut(new PrintStream(outContent));

        Rule rule = new Rule();
        InputGenerateManager inputGenerateManager = Mockito.spy(InputGenerateManager.class);
        OutputGenerateManager outputGenerateManager = new OutputGenerateManager(rule);
        Simulator simulator = new Simulator();
        CarFactory carFactory = new CarFactory(inputGenerateManager);
        Director director = new Director(inputGenerateManager, outputGenerateManager, simulator, carFactory);
        RacingGame racingGame = new RacingGame(director);

        Mockito.when(inputGenerateManager.generateInputStringSplitWithComma(CAR_NAMES)).thenReturn(CAR_NAME_LIST);
        Mockito.when(inputGenerateManager.generateInputStringToInt(STRING_REPEAT_COUNT))
                .thenReturn(INTEGER_REPEAT_COUNT);
        Mockito.when(inputGenerateManager.generateRandomInt()).thenReturn(5);

        //when
        racingGame.start();

        //then
        Assertions.assertThat(outContent.toString()).contains("최종 우승자 : 한놈, 두식이, 석삼");

        System.setIn(originalSystemIn);
        System.setOut(originalOut);
    }

    @Test
    void 메서드_호출_여부() {
        //given
        InputStream originalSystemIn = System.in;
        InputGenerateManager inputGenerateManager = Mockito.mock(InputGenerateManager.class);
        OutputGenerateManager outputGenerateManager = Mockito.mock(OutputGenerateManager.class);
        Simulator simulator = Mockito.mock(Simulator.class);
        CarFactory carFactory = Mockito.mock(CarFactory.class);
        Director director = Mockito.spy(
                new Director(inputGenerateManager, outputGenerateManager, simulator, carFactory));
        RacingGame racingGame = new RacingGame(director);

        System.setIn(new ByteArrayInputStream((CAR_NAMES + System.lineSeparator() + STRING_REPEAT_COUNT).getBytes()));

        Mockito.when(inputGenerateManager.generateInputStringSplitWithComma(CAR_NAMES)).thenReturn(CAR_NAME_LIST);
        Mockito.when(inputGenerateManager.generateInputStringToInt(STRING_REPEAT_COUNT))
                .thenReturn(INTEGER_REPEAT_COUNT);
        Mockito.when(inputGenerateManager.generateRandomInt()).thenReturn(5);

        //when
        racingGame.start();

        //then
        Mockito.verify(director).startProcess();
        Mockito.verify(inputGenerateManager).generateInputStringSplitWithComma(CAR_NAMES);
        Mockito.verify(inputGenerateManager).generateInputStringToInt(STRING_REPEAT_COUNT);

        Mockito.verify(carFactory).createCars(CAR_NAME_LIST);
        Mockito.verify(outputGenerateManager).printCarNameAnnounce();
        Mockito.verify(outputGenerateManager).printRepeatCountAnnounce();
        Mockito.verify(outputGenerateManager).printCarNameAnnounce();
        Mockito.verify(outputGenerateManager).printResultAnnounce();


        System.setIn(originalSystemIn);
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