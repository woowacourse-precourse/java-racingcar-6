package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.model.Car;
import racingcar.util.GameNumberGenerator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

class RacingGameTest {
    @InjectMocks
    private RacingGame racingGame;
    @Mock
    private GameNumberGenerator gameNumberGenerator;

    @BeforeEach
    void before() {
        MockitoAnnotations.openMocks(this);
        //랜덤 숫자 생성 부분 모킹
        when(gameNumberGenerator.randomNumber()).thenReturn(5);
        racingGame = new RacingGame(gameNumberGenerator);
    }

    @Test
    void setupGame() {
        racingGame.setupGame(List.of("test1", "test2"), 3);

        List<String> resultCarNames = racingGame.getCarRepository()
                .getCars().stream()
                .map(Car::getName).toList();
        int resultRepeatCnt = racingGame.getRepeatCount();

        assertThat(resultCarNames).contains("test1", "test2");
        assertThat(resultRepeatCnt).isEqualTo(3);
    }

    @Test
    void play() {
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputBuffer));

        racingGame = new RacingGame(gameNumberGenerator);
        racingGame.setupGame(List.of("test1", "test2"), 3);
        racingGame.play();

        //모든 경우 움직인다(랜덤 숫자 생성 부분 모킹)
        String result = outputBuffer.toString();
        String expected = "\n실행 결과\ntest1 : - \ntest2 : - \n\ntest1 : -- \ntest2 : -- \n\ntest1 : --- \ntest2 : --- \n\n";
        assertThat(result).isEqualTo(expected);

        System.setOut(System.out);
    }

    @Test
    void oneRoundMove() {
        racingGame.setupGame(List.of("test1", "test2"), 3);
        racingGame.oneRoundMove();

        List<Integer> carScore = racingGame.getCarRepository().getCars()
                .stream().map(Car::getForwardCount)
                .toList();

        //모두 1점씩 오른다
        for (Integer nowScore : carScore) {
            assertThat(nowScore).isEqualTo(1);
        }

    }

    @ParameterizedTest
    @CsvSource({"0,False", "1,False", "4,True", "5,True"})
    void isMove(int num, boolean expected) {
        boolean result = racingGame.isMove(num);
        assertThat(result).isEqualTo(expected);
    }

}