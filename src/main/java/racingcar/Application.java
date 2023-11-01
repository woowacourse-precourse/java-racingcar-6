package racingcar;

import racingcar.domain.Race;

public class Application {
    Application(Race race) {
        this.race = race;
    }
    private final Race race;
    public static void main(String[] args) {
        Race race = Race.create();
        Application application = new Application(race);
        application.run();
    }

    public void run() {
        race.start();
    }
    
}
