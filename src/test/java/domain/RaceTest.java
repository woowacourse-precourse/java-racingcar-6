package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RaceTest {
    public static final int CAR_COUNT = 2;
    public static final int ROUND_COUNT = 5;
    private PrintStream originalSystemOut;
    private ByteArrayOutputStream mockOutput;
    private ArrayList<Car> carList;
    private Race race;

    @BeforeEach
    public void setUp() {
        originalSystemOut = System.out;
        carList = new ArrayList<>();

        Car carA = new Car("A");
        Car carB = new Car("B");

        carList.add(carA);
        carList.add(carB);

        race = new Race(carList);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalSystemOut);
        race = null;
        carList.clear();
    }

    @Test
    public void startRound_정상동작() {
        mockOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutput));

        race.startRound();

        String printedContent = mockOutput.toString();
        mockOutput.reset();

        for (Car car : carList) {
            System.out.print(car);
            String carStatus = mockOutput.toString();
            mockOutput.reset();

            assertThat(printedContent).contains(carStatus);
        }
    }

    @Test
    public void repeatRound_정상동작() {
        mockOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutput));

        race.repeatRound(ROUND_COUNT);

        String printedContent = mockOutput.toString();
        String[] contents = printedContent.split("\\r?\\n");
        int lineCount = contents.length;

        assertThat(lineCount)
                .isEqualTo(CAR_COUNT * ROUND_COUNT);
    }

    @Test
    public void getWinnerList_정상동작() {
        mockOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutput));
        race.repeatRound(ROUND_COUNT);

        Car carA = carList.get(CAR_COUNT - 1);
        Car carB = carList.get(0);

        mockOutput.reset();
        System.out.print(carA);
        String aPrinted = mockOutput.toString();
        mockOutput.reset();

        System.out.print(carB);
        String bPrinted = mockOutput.toString();
        mockOutput.reset();

        ArrayList<Car> result = race.getWinnerList();

        if (aPrinted.length() >= bPrinted.length()) {
            assertThat(result.contains(carA)).isEqualTo(true);
        }

        if (aPrinted.length() <= bPrinted.length()) {
            assertThat(result.contains(carB)).isEqualTo(true);
        }
    }
}
