package racingcar.IO;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class IOServiceTest {

    private static MockedStatic<Console> console;

    @BeforeAll
    public static void beforeAll() {
        console = mockStatic(Console.class);
    }

    @AfterAll
    public static void afterAll() {
        console.close();
    }

    @Test
    public void test1() {
        when(Console.readLine()).thenReturn("good,name,fin");
        String result=IOService.inputCreate();

        assertEquals(result,"good,name,fin");
    }
    @Test
    public void test() {
        when(Console.readLine()).thenReturn("longname,fin");
        assertThrows(IllegalArgumentException.class, () -> {
            IOService.inputCreate();
        });
    }

    @Test
    public void test2() {
        when(Console.readLine()).thenReturn(" blan,k,fin");
        assertThrows(IllegalArgumentException.class, () -> {
            IOService.inputCreate();
        });
    }

    @Test
    public void test4() {
        when(Console.readLine()).thenReturn("2");
        String result=IOService.inputCount();

        assertEquals(result,"2");
    }
    @Test
    public void test3() {
        when(Console.readLine()).thenReturn("a");
        assertThrows(IllegalArgumentException.class, () -> {
            IOService.inputCount();
        });
    }


}