package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println(Output.START.getText());
        String names = Console.readLine();

        System.out.println(Output.TIME.getText());
        String time = Console.readLine();

        Race race = new Race(names);
        System.out.println(Output.RESULT.getText());
        race.playGame(time);

        System.out.print(Output.WINNER.getText());
        System.out.println(race.checkWinner());
    }
}
