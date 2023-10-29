package racingcar;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Racing rc = new Racing();
        try
        {
            rc.startRacing();
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }

    }
}
