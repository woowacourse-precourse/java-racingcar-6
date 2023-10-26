package racingcar;

import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        var players = Input.inputPlayers();
        var phase = Input.inputGamePhase();

        var cars = players.stream().map(player -> new Car(
                player,
                new RandomizedCarEngine()
        )).collect(Collectors.toList());

        var game = new RacingCarGame(cars, phase);
        game.start();
        game.end();
    }
}
