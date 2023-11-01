package racingcar.domain.service;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.GameNumber;
import racingcar.domain.Names;
import racingcar.global.utils.generator.InputNamesGenerator;
import racingcar.global.utils.generator.InputNumberOfGames;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputServiceTest {

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    public void testTransposeAndDistanceList() {

//        given
        InputNamesGenerator inputNamesGenerator = new InputNamesGenerator();
        System.setIn(createUserInput("Alice,Bob"));
        Names names = new Names(inputNamesGenerator);

        Console.close();

        InputNumberOfGames inputNumberOfGames = new InputNumberOfGames();
        System.setIn(createUserInput("1"));
        GameNumber gameNumber = new GameNumber(inputNumberOfGames);

        CreateListService createListService = new CreateListService();
        OutputService outputService = new OutputService();

        List<List<Integer>> lists = createListService.transposeAndDistanceList(names, gameNumber);
        outputService.outputDistance(lists, names, gameNumber);
        outputService.outputWinner(lists, names, gameNumber);


//        when

//        then
    }

}