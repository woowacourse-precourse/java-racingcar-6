package racingcar;
import camp.nextstep.edu.missionutils.Console;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import java.util.NoSuchElementException;

public class PlayerTest {
    private Player player;
    @BeforeEach()
    void setUp(){
        player = new Player();
    }
    @Test
    void 사용자의_입력을_받는다(){
        String expectedInput = "correct";
        System.setIn(new ByteArrayInputStream("correct".getBytes()));
        String playerInput = player.getPlayerInput();
        Assertions.assertEquals(expectedInput,playerInput);
    }
    @Test
    void 사용자가_입력하지_않으면_에러를_발생한다(){
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            try{
                player.getPlayerInput();
            }catch (NoSuchElementException e){
                throw new IllegalArgumentException("입력을 해주세요!");
            }
        });
        Assertions.assertEquals("입력을 해주세요!",exception.getMessage());
    }
}