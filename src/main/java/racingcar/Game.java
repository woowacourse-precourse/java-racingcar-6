package racingcar;

public class Game {
    public void start() {
        Input input = new Input();
        input.inputPlayer();
        input.inputRound();
        Racing racing = new Racing(input);
        racing.setPlayerResult();
        Output output = new Output();
        for (int i = 0; i < input.getRound(); i++) {
            for (int j = 0; j < input.getPlayerName().size(); j++) {
                racing.startRacing(j);
            }
            output.printRound(input.getPlayerName(), racing.getPlayerResult());
        }
        output.goal(input.getPlayerName(), racing.goalPlayer());
    }
}
