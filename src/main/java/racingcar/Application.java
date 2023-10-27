package racingcar;


import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        try {
            String names = Console.readLine();
            CarRegistration.input(names);

            String line = Console.readLine();
            MoveCount moveCount = new MoveCount(line);
        } catch (IllegalArgumentException e) {
            Console.close();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
