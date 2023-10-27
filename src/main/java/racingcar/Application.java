package racingcar;

public class Application {
    public static void main(String[] args) {
        Race race = new Race();
        if (race.init()) {
            race.play();
        }
    }
}
