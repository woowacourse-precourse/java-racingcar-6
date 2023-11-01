package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MainGameTest {

    @Test
    public void judgementTest() {

        MainGame mainGame = new MainGame();
        List<Car> cars = Arrays.asList(
                new Car("car1", 3),
                new Car("car2", 2),
                new Car("car3", 3)
        );
        List<String> winners = mainGame.judgement(cars);

        assertEquals(2, winners.size());
        assertEquals("car1", winners.get(0));
        assertEquals("car3", winners.get(1));
    }
}
