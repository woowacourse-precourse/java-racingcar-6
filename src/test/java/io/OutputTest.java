package io;

import domain.Car;
import domain.Race;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OutputTest {
    public static final String ROUND_MESSAGE = "실행 결과";
    public static final String RESULT_MESSAGE = "최종 우승자";
    private PrintStream originalSystemOut;
    private ByteArrayOutputStream mockOutPut;
    private ArrayList<Car> carList;
    private Race race;

    @BeforeEach
    public void setUp() {
        originalSystemOut = System.out;
        carList = new ArrayList<>(List.of(new Car("A"), new Car("B")));
        race = new Race(carList);
        userOutput = new Output();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalSystemOut);
        mockOutPut.reset();
        userOutput = null;
    }

    @Test
    void printRoundResult_기능동작() {
        mockOutPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutPut));

        userOutput.printRoundResult(race);
        String printedContent = mockOutPut.toString();

        assertThat(printedContent).contains(ROUND_MESSAGE);
        assertThat(printedContent).contains("A");
        assertThat(printedContent).contains("B");
    }

    @Test
    void printWinnerList_기능동작() {
        mockOutPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutPut));

        ArrayList<Car> result = race.getWinnerList();

        userOutput.printWinnerList(result);
        String printedContent = mockOutPut.toString();

        long spliterCount = printedContent
                .chars()
                .filter(c -> c == ',')
                .count();

        assertThat(printedContent).contains(RESULT_MESSAGE);
        assertThat(spliterCount + 1).isEqualTo(result.size());
    }
}
