package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class CarManagementTest {
    private final int rangeStart = 0;
    private final int rangeEnd = 9;
    private final int limitNumber = 4;
    private CarManagement carManagement;
    private Map<String, Car> customLinkedHashMap;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        carManagement = new CarManagement();
        customLinkedHashMap = new LinkedHashMap<>();
        Car carA = new Car("carA");
        carA.setCarLocation(4);
        customLinkedHashMap.put("carA", carA);
        carManagement.setCarLinkedHashMap(customLinkedHashMap);
    }

    @Test
    void isCarExistTest() {
        assertTrue(carManagement.isCarExist("carA"));
        assertFalse(carManagement.isCarExist("carB"));
    }

    @Test
    void addCarTest() {
        carManagement.addCar("carB");
        assertTrue(carManagement.getCarLinkedHashMap().containsKey("carB"));
        assertThrows(IllegalArgumentException.class, () -> {
            carManagement.addCar("carA");
        });
    }

    @Test
    void getCarTest() {
        assertEquals(carManagement.getCar("carA").getCarName(), "carA");
        assertNull(carManagement.getCar("carB"));
    }

    @Test
    void showCarLocationTest() {
        System.setOut(new PrintStream(outputStreamCaptor));
        carManagement.showCarLocation("carA");
        String output = outputStreamCaptor.toString().trim();
        String expectedOutput = "carA : ----";
        assertEquals(expectedOutput, output);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    @Test
    void playRoundTest() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4);
            for (int i = 1; i < 5; i++) {
                carManagement.playRound(rangeStart, rangeEnd, limitNumber);
                assertEquals(4 + i, carManagement.getCarLinkedHashMap().get("carA").getCarLocation());
            }
        }
    }

    @Test
    void printWinnerTest() {
        System.setOut(new PrintStream(outputStreamCaptor));
        Car carB = new Car("carB");
        carB.setCarLocation(6);
        customLinkedHashMap.put("carB", carB);

        carManagement.printWinner();
        String output = outputStreamCaptor.toString().trim();
        String expectedOutput = "최종 우승자 : carB";
        assertEquals(expectedOutput, output);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
}
