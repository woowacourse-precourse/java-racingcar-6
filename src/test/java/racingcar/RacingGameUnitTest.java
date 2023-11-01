package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RacingGameUnitTest {

    private final PrintStream standardOut = System.out;
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void addParticipant_게임_참가자_추가() {
        RacingGame testGame = new RacingGame(3);
        try {
            Field participants = testGame.getClass().getDeclaredField("participants");
            participants.setAccessible(true);
            ArrayList<Car> participantsList = (ArrayList<Car>) participants.get(testGame);

            testGame.addParticipant(new Car("test1"));
            testGame.addParticipant(new Car("test2"));

            assertThat(participantsList).extracting("name").containsOnly("test1", "test2");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void game_게임_후_자동차_위치_검증() {
        RacingGame testGame = new RacingGame(2);
        Car testCar1 = new Car("test1");
        Car testCar2 = new Car("test2");
        testCar1.setCurrentLocation(3);
        testGame.addParticipant(testCar1);
        testGame.addParticipant(testCar2);

        testGame.game();

        assertThat(testCar1.getCurrentLocation() > testCar2.getCurrentLocation()).isTrue();
    }

    @Test
    void getResult_중복된_우승자에_대한_최종_결과_반환() {
        RacingGame testGame = new RacingGame(2);
        Car testCar1 = new Car("test1");
        Car testCar2 = new Car("test2");
        Car testCar3 = new Car("test3");
        testGame.addParticipant(testCar1);
        testGame.addParticipant(testCar2);
        testGame.addParticipant(testCar3);

        testCar1.setCurrentLocation(5);
        testCar2.setCurrentLocation(3);
        testCar3.setCurrentLocation(5);
        String testResult = testGame.getResult();

        assertThat(testResult).isEqualTo("최종 우승자 : test1, test3");
    }

    @Test
    void getResult_단일_우승자에_대한_최종_결과_반환() {
        RacingGame testGame = new RacingGame(2);
        Car testCar1 = new Car("test1");
        Car testCar2 = new Car("test2");
        Car testCar3 = new Car("test3");
        testGame.addParticipant(testCar1);
        testGame.addParticipant(testCar2);
        testGame.addParticipant(testCar3);

        testCar1.setCurrentLocation(2);
        testCar2.setCurrentLocation(3);
        testCar3.setCurrentLocation(5);
        String testResult = testGame.getResult();

        assertThat(testResult).isEqualTo("최종 우승자 : test3");
    }
}
