package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.validator.InputValidator;

public class Cars {
    private static final int ZERO_POSITION = 0;
    private static final int MIN_MOVE_NUMBER = 4;
    private static final String NAME_POSITION_DIVIDER = " : ";
    private static final String POSITION_STRING = "-";

    private final Map<Name, Integer> cars;

    public Cars(String names) {
        InputValidator.validateCarNames(names);
        cars = generateCars(names);
    }

    private Map<Name, Integer> generateCars(String names) {
        Map<Name, Integer> carMap = new HashMap<>();
        String[] carNamesArray = names.split(",");
        for (String carName : carNamesArray) {
            carMap.put(new Name(carName), ZERO_POSITION);
        }
        return carMap;
    }

    public void decideToMove() {
        cars.forEach((name, position) -> {
            if (Randoms.pickNumberInRange(1, 9) >= MIN_MOVE_NUMBER) {
                cars.put(name, position + 1);
            }
        });
    }

    public String generateRoundResultString() {
        StringBuilder sb = new StringBuilder();
        cars.forEach((name, position) -> {
            sb.append(name.getName());
            sb.append(NAME_POSITION_DIVIDER);
            sb.append(POSITION_STRING.repeat(position));
            sb.append("\n");
        });
        return sb.toString();
    }

    public int getMaxPosition() {
        return Collections.max(cars.values());
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        cars.forEach((name, position) -> {
            if (cars.get(name) == maxPosition) {
                winners.add(name.getName());
            }
        });
        return winners;
    }

}
