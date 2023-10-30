package racingcar;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {

    List<String> getCarNames() {
        String input = null;
        try {
            input = Console.readLine();
        }catch (RuntimeException e){
            throw new IllegalArgumentException();
        }

        if (!input.contains(",")) {
            throw new IllegalArgumentException();
        }
        List<String> carList = List.of(input.split(","));
        return carList;
    }

    int getTurn() {
        String turn = Console.readLine();
        int intTurn = 0;
        try {
            intTurn = parseInt(turn);
        } catch (RuntimeException e) {
            System.out.println();
        }
        return intTurn;
    }

}
