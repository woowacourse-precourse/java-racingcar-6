package game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    @Test
    public void testAddPerson(){
        Game game = new Game();

        List<String> result = game.addPerson("user1,user2");

        assertThat(result).containsExactly("user1", "user2");
    }
}
