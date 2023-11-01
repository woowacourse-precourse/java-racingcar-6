package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    @Test
    void 입력_값_확인(){
        Application.initializeRace("chae,heon,wooah");
        assertEquals(3, Application.race.size());
        assertTrue(Application.race.containsKey("chae"));
        assertTrue(Application.race.containsKey("heon"));
        assertTrue(Application.race.containsKey("wooah"));
    }

    @Test
    void 입력_값_예외_확인(){
        assertThatThrownBy(() -> Application.initializeRace("chaeheon,wooah"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Car name Error : chaeheon");
    }

    @Test
    void 승자_확인(){
        Application.race.put("chae", 5);
        Application.race.put("heon", 3);
        Application.race.put("wooah", 5);

        ArrayList<String> winners = new ArrayList<>();
        Application.getWinner(winners);

        assertTrue(winners.contains("chae"));
        assertTrue(winners.contains("wooah"));
        assertEquals(2, winners.size());
    }
}

