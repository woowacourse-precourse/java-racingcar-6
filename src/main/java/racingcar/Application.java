package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
class Car {
    String name;
    int count;
}

class Game {
    public static int MOVES;
    List<String> name;
    public void getCarNames() {
        String input = Console.readLine();
        name = Arrays.asList(input.split(","));
    }
    public void getNumberOfMoves() {
        MOVES = Integer.parseInt(Console.readLine());
    }
}