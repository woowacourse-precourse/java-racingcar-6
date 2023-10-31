package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("a", 0);
    }

    @Test
    void move() {
        player.move();

        assertEquals(1, player.getLocation());

        player.move();

        assertEquals(2, player.getLocation());
    }
}