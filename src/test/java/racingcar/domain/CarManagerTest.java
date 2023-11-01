package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {
    private CarManager carManager;

    @BeforeEach
    void setUp() {
        carManager = new CarManager();
    }

    @Test
    void giveName_입력값_리스트로_반환() {
        String input = "andy,pobi,woni,joy";
        List<String> cars = carManager.giveName(input);

        assertThat(cars).containsExactly("andy", "pobi", "woni", "joy");
        assertThat(cars).isInstanceOf(List.class);
    }

    @Test
    void giveName_입력한_이름이_5자를_초과하면_예외_발생() {
        String input = "andy,pobi,woni,sadness";

        assertThatThrownBy(() -> carManager.giveName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void giveName_입력한_이름에_중복값_있으면_예외_발생() {
        String input = "andy,pobi,woni,pobi";

        assertThatThrownBy(() -> carManager.giveName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}