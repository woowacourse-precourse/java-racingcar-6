package racingcar;

public class Application {
    public static void main(String[] args) {
        GameServer gameServer = new GameServer(new RealRoulette());
        gameServer.run();
    }
}
