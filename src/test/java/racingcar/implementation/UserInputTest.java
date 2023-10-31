package racingcar.implementation;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInputTest {

    private static UserInput userInput;

    @BeforeEach
    void before() {
        userInput = new UserInput();
    }

    protected void systemIn(String input) throws IOException {
        userInput.sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 리스트_일치_여부() throws IOException {
        String carNames = "pobi,woni,jun,alice,david,grace,emma,ryan";
        List<String> carList = Arrays.asList("pobi : ","woni : ","jun : ","alice : ","david : ","grace : ","emma : ","ryan : ");

        systemIn(carNames);

        Assertions.assertIterableEquals(carList, userInput.getCarList());
    }

    @Test
    void 자동차_이름_예외_반환_여부() throws IOException {
        String carNames = "pobi,woni,jun,alice1,david,grace,emma,ryan";

        systemIn(carNames);

        Assertions.assertThrows(IllegalArgumentException.class,() -> userInput.getCarList());
    }

    @Test
    void 시도_회수_예외_반환_여부() throws IOException {
        String numberOfTry = "사장님";

        systemIn(numberOfTry);

        Assertions.assertThrows(IllegalArgumentException.class,() -> userInput.getNumberOfTry());
    }
}
