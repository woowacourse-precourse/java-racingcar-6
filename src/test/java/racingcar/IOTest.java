package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.common.UserInputReader;
import racingcar.factories.CarFactory;
import racingcar.factories.CarRecordFactory;
import racingcar.underhood.CarRecord;
import racingcar.underhood.ConsoleReader;
import racingcar.underhood.GameRule;
import racingcar.underhood.NumberOfRepetitions;
import racingcar.underhood.Race;

public class IOTest {

    GameRule rule;
    InputStream stdIn;
    UserInputReader userInputReader;

    @BeforeEach
    void init() {
        rule = new GameRule(0, 9);
        InputStream stdIn = System.in;
        userInputReader = new ConsoleReader(rule);
    }

    @AfterEach
    void clean() {
        userInputReader.close();
    }

    @Test
    void 정상적인_자동차_이름_입력() {
        // given
        String[] names = new String[] {"BMW", "pobi", "woni", "abcde"};
        CarRecord expectedNames = CarRecordFactory.createEmptyCarRecord(rule);
        for (int i = 0; i < names.length; i++) {
            expectedNames.register(CarFactory.car(rule, names[i]));
        }
        String rawInputString = String.join(",", names) + "\n";
        // when
        stdInWillRead(rawInputString);
        CarRecord actualNames = (CarRecord) userInputReader.readPureWords();
        // then
        assertThat(actualNames).isEqualTo(expectedNames);
        restoreStdIn();
   }

    /**
     * 자동차 이름은 대소문자 알파벳과 숫자의 조합만 가능하다고 가정
     */
    @Test
    void 비정상적인_자동차_이름_입력() {
        // given
        String[] names = new String[] {"abcdef", "aaa,abcdef"};
        for (int i = 0; i < names.length; i++) {
            // when
             System.setIn(new ByteArrayInputStream(names[i].getBytes()));
            // then
            Assertions.assertThatThrownBy(
                    () -> userInputReader.readPureWords())
                    .isInstanceOf(IllegalArgumentException.class);
            userInputReader.close();
        }
        restoreStdIn();
    }

   @Test
    void 정상적인_이동_횟수_입력() {
       // given
       String[] inputs = new String[] {"5", "50", "05", "010201", "    3     "};
       int[] numbers = new int[] {5, 50, 5, 10201, 3};
       for (int i = 0; i < inputs.length; i++) {
           // when
           stdInWillRead(inputs[i]);
           NumberOfRepetitions n = (NumberOfRepetitions) userInputReader.readPureNumber();
           // then
           assertThat(n).isEqualTo(new NumberOfRepetitions(rule, numbers[i]));
           userInputReader.close();
       }
       restoreStdIn();
   }

    @Test
    void 비정상적인_이동_횟수_입력() {
        // given
        String[] inputs = new String[] {"5k", "0", " k  3     ", "1   3"};
        int[] numbers = new int[] {5, 50, 5, 10201, 3};
        for (int i = 0; i < inputs.length; i++) {
            // when
            stdInWillRead(inputs[i]);
            // then
            Assertions.assertThatThrownBy(() -> userInputReader.readPureNumber())
                    .isInstanceOf(IllegalArgumentException.class);
            userInputReader.close();
        }
        System.setIn(stdIn);
    }

    @Test
    void 모든_자동차가_동일한_이동거리를_한_번_이동_후_현재_상태_출력() {
        // given
        Race race = new Race(rule);
        MockedStatic<RandomNumberGenerator> mocked = Mockito.mockStatic(RandomNumberGenerator.class);
        mocked.when(() -> RandomNumberGenerator.pickRandomNumber(rule))
                        .thenReturn(5);
        rule.setNumberOfRepetitions(new NumberOfRepetitions(rule, "1"));
        CarRecord racers = CarRecordFactory.createEmptyCarRecord(rule);
        racers.register(CarFactory.car(rule, "pobi"));
        racers.register(CarFactory.car(rule, "woni"));
        racers.register(CarFactory.car(rule, "jun"));
        race.registerRacers(racers);
        // when
        PrintStream stdOut = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        race.start();
        // then
        Assertions.assertThat(buffer.toString()).isEqualTo("pobi : -\nwoni : -\njun : -\n");
    }

    void stdInWillRead(String input) {
        ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
        System.setIn(bis);
    }

    void restoreStdIn() {
        System.setIn(stdIn);
    }
}
