package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println(GameMessage.INPUT_MESSAGE);
            String input = Console.readLine();
            CarInput carInput = CarInput.of(input);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
