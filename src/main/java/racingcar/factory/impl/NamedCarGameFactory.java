package racingcar.factory.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.car.impl.NamedCar;
import racingcar.factory.GameFactory;
import racingcar.game.Game;
import racingcar.game.impl.GameImpl;

public class NamedCarGameFactory implements GameFactory {
    private final String input;
    private final int iterNumber;

    public NamedCarGameFactory(String input, String iterNumber) {
        this.input = input;
        try {
            this.iterNumber = Integer.parseInt(iterNumber);
            String[] split = input.split(",");
            validate(split);
        }catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    private static void validate(String[] split) throws IllegalArgumentException {
        boolean isInvalid = Arrays.stream(split).anyMatch(token -> token.length() > 5);
        if (isInvalid) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Game createGame() throws IllegalArgumentException {
        String[] split = input.split(",");
        List<Car> cars = Arrays.stream(split)
                .map(name -> new NamedCar(name))
                .collect(Collectors.toList());
        return new GameImpl(cars, iterNumber);
    }
}
