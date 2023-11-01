package racingcar.domain.service;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.ClientGameNumber;
import racingcar.domain.GameNumber;
import racingcar.domain.Names;
import racingcar.global.utils.generator.InputNamesGenerator;
import racingcar.global.utils.generator.InputNumberOfGames;
import racingcar.global.utils.generator.NumberOfGamesGenerator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;

class CreateListServiceTest {

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
        System.setIn(createUserInput("Alice,Bob,Char"));
        Names names = new Names(inputNamesGenerator);

        Console.close();

        InputNumberOfGames inputNumberOfGames = new InputNumberOfGames();
        System.setIn(createUserInput("4"));
        GameNumber gameNumber = new GameNumber(inputNumberOfGames);

        CreateListService createListService = new CreateListService();

        List<List<Integer>> lists = createListService.transposeAndDistanceList(names, gameNumber);


//        when

//        then
    }
}