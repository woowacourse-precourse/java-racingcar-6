package Service;

import Service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameServiceTest {
    private ByteArrayInputStream mockInput;

    @BeforeEach
    void setUp() {
        mockInput = new ByteArrayInputStream("pobi,woni,jun".getBytes());
    }

    @Test
    void testGetCarName() {
        System.setIn(mockInput);

        GameService gameService = new GameService();
        String[] carNames = gameService.getCarName();
        
        assertEquals("pobi", carNames[0]);
        assertEquals("woni", carNames[1]);
        assertEquals("jun", carNames[2]);
    }
}
