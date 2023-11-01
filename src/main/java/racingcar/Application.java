package racingcar;

import racingcar.domain.Race;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        Race race = Race.create();
        race.start();
    }

}
