package racingcar;

import org.junit.jupiter.api.*;
import racingcar.player.Player;

import java.io.ByteArrayInputStream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerTest {

    private Player player;
    @BeforeEach()
    void setUp(){
        player = new Player();
    }

    @Test
    @Order(1)
    void 사용자의_입력을_받는다(){
        String expectedInput = "correct";
        System.setIn(new ByteArrayInputStream("correct".getBytes()));
        String playerInput = player.getPlayerInput();
        Assertions.assertEquals(expectedInput,playerInput);
    }
    @Test
    @Order(2)
    void 사용자가_입력하지_않으면_에러를_발생한다(){
        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class,()->
                    player.getPlayerInput()
        );
        Assertions.assertEquals("입력을 해주세요!",exception.getMessage());
    }
}