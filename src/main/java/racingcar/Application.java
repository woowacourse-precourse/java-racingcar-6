package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static GameRandom random;

    private static GameRandom getRandom() {
        if (random == null) {
            random = new MissionUtilsGameRandom();
        }
        return random;
    }

    public static void setRandom(GameRandom newRandom) {
        random = newRandom;
    }

    public static void main(String[] args) {
        RacingCarGameRenderer renderer = new SimpleRacingCarGameRenderer();
        InputInterface in = new InputInterface(Console::readLine, System.out::println);
        OutputInterface out = new OutputInterface(System.out::println, renderer);
        RacingCarGame game = new RacingCarGame(in.getNames(), in.getTrial(), getRandom());
        GameExecutor gameExecutor = new GameExecutor(game, in, out);
        gameExecutor.run();
    }
}
