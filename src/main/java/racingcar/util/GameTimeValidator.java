package racingcar.util;

public class GameTimeValidator {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 100;

    public static int validateGameTime(int gameTime){
        if (gameTime < MINIMUM || gameTime > MAXIMUM) {
            throw new IllegalArgumentException(String.format("이동 횟수는 %d 부터 %d 까지 가능합니다.",MINIMUM,MAXIMUM));
        }
        return gameTime;
    }
}
