package racingcar.model.service;

import static racingcar.constants.Rule.MOVE_FORWARD;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.domain.Car;
import racingcar.model.domain.Game;
import racingcar.utils.Generator;

public class RacingCarServiceImp implements RacingCarService {
    @Override
    public void moveCars(Game game) {
        game.getCars().forEach(car -> {
            if (isCarMove()) {
                car.move();
            }
        });
        increaseTrial(game);
    }

    @Override
    public List<String> getWinner(Game game) {
        int maxLocation = getMaxLocation(game);
        return game.getCars().stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int getMaxLocation(Game game) {
        return game.getCars().stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

    private static boolean isCarMove() {
        return Generator.generateRandomNumber() >= MOVE_FORWARD.getValue();
    }

    private static void increaseTrial(Game game) {
        game.increaseTrial();
    }
}
