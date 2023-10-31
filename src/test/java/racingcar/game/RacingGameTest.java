package racingcar.game;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        String[] cars = {"poby", "woni", "jun"};
        int tryCount = 5;
        racingGame = new RacingGame(cars, tryCount);
    }

    @Test
    public void distance_객체_생성시_거리_모두_0으로_초기화() {
        try {
            Field initialDistance = RacingGame.class.getDeclaredField("INITIAL_DISTANCE");
            initialDistance.setAccessible(true);
            Field distanceField = RacingGame.class.getDeclaredField("distance");
            distanceField.setAccessible(true);

            int[] distances = (int[]) distanceField.get(racingGame);
            for (int d : distances) {
                assertEquals(initialDistance.get(racingGame), d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void canMove_4보다_큰수에_대하여_움직임_가능() {
        try {
            int number = 6;
            Method canMoveMethod = RacingGame.class.getDeclaredMethod("canMove", int.class);
            canMoveMethod.setAccessible(true);
            boolean result = (boolean) canMoveMethod.invoke(racingGame, number);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void canMove_4보다_작은수에_대하여_움직임_불가능() {
        try {
            int number = 2;
            Method canMoveMethod = RacingGame.class.getDeclaredMethod("canMove", int.class);
            canMoveMethod.setAccessible(true);
            boolean result = (boolean) canMoveMethod.invoke(racingGame, number);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void move_한칸_움직임_검증() {
        try {
            Field moveDistance = RacingGame.class.getDeclaredField("MOVE_DISTANCE");
            moveDistance.setAccessible(true);

            Method moveMethod = RacingGame.class.getDeclaredMethod("move", int.class);
            moveMethod.setAccessible(true);

            int carIndex = 0;
            moveMethod.invoke(racingGame, carIndex);

            Field distanceField = RacingGame.class.getDeclaredField("distance");
            distanceField.setAccessible(true);

            int[] distanceArray = (int[]) distanceField.get(racingGame);

            assertEquals(moveDistance.get(racingGame), distanceArray[carIndex]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getWinners_거리가_가장_긴_최종우승자_반환() {
        int[] specificDistances = {2, 3, 2};
        try {
            Field distanceField = RacingGame.class.getDeclaredField("distance");
            distanceField.setAccessible(true);
            distanceField.set(racingGame, specificDistances);

            Method getWinnersMethod = RacingGame.class.getDeclaredMethod("getWinners");
            getWinnersMethod.setAccessible(true);
            String winners = getWinnersMethod.invoke(racingGame).toString();

            assertEquals("[woni]", winners);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getWinners_최종우승자_모두_반환() {
        int[] specificDistances = {2, 3, 3};
        try {
            Field distanceField = RacingGame.class.getDeclaredField("distance");
            distanceField.setAccessible(true);
            distanceField.set(racingGame, specificDistances);

            Method getWinnersMethod = RacingGame.class.getDeclaredMethod("getWinners");
            getWinnersMethod.setAccessible(true);
            String winners = getWinnersMethod.invoke(racingGame).toString();

            assertEquals("[woni, jun]", winners);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}