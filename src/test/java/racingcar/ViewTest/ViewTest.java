package racingcar.ViewTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.View.RequestMessage;

public class ViewTest {
    @Test
    public void setCarName(){
        RequestMessage.setCarName();
    }

    @Test
    public void setAttemptNum(){
        RequestMessage.setAttemptNum();
    }
}
