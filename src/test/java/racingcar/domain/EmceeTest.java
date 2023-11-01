package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmceeTest {
    private Emcee emcee;

    @BeforeEach
    void setUp() {
        emcee = new Emcee();
    }

    @Test
    void 자동차들의_현재_포지션_반환() {
        //given
        Map<String, Integer> carList = new HashMap<>();
        carList.put("Car1", 3);
        carList.put("Car2", 5);
        carList.put("Car3", 0);

        //w                             hen
        String result = emcee.returnCurrentPosition(carList);

        // Then
        assertThat(result).contains("Car1 : ---\n", "Car2 : -----\n", "Car3 : \n");
    }

    @Test
    void 우승자_목록_반환() {
        // Given
        List<String> winnerList = List.of("Car1", "Car3", "Car5");

        // When
        String result = emcee.returnWinner(winnerList);

        // Then
        assertThat(result).isEqualTo("Car1, Car3, Car5");
    }
}
