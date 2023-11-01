package racingcar;

import static racingcar.ErrorMessage.CAR_NAME_DUPLICATED;
import static racingcar.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER;
import static racingcar.PrintMessage.INPUT_NUMBER_OF_ATTEMPTS;
import static racingcar.PrintMessage.INPUT_RACING_CAR_NAME;
import static racingcar.PrintMessage.PRINT_GAME_RESULT;
import static racingcar.PrintMessage.WINNER_NAME_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class CarRacingGame {

    private static final String RACING_CAR_NAME_SEPARATOR = ",";
    private static final String WINNER_RACING_CAR_NAME_DELIMITER= ", ";

    public void run(){
        System.out.println(INPUT_RACING_CAR_NAME);
        String[] carNames = Console.readLine().split(RACING_CAR_NAME_SEPARATOR);
        validateCarNameDuplicate(carNames);
        RacingCars racingCars = RacingCars.from(carNames);
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        Integer numberOfAttempts = convertInputToInteger(Console.readLine());
        play(racingCars, numberOfAttempts);
    }

    private void play(RacingCars racingCars, Integer numberOfAttempts) {
        System.out.println(PRINT_GAME_RESULT);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfAttempts; i++) {
            racingCars.race();
            stringBuilder.append(racingCars).append(System.lineSeparator()).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
        List<String> winnerNames = racingCars.getWinnerNames();
        StringJoiner winnerNamesJoiner = new StringJoiner(WINNER_RACING_CAR_NAME_DELIMITER);
        winnerNames.stream().forEach(name -> winnerNamesJoiner.add(name));
        System.out.println(String.format(WINNER_NAME_FORMAT, winnerNamesJoiner));
    }


    private Integer convertInputToInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER);
        }
    }

    private void validateCarNameDuplicate(String[] carNames) {
        if(Arrays.stream(carNames).distinct().count()!= carNames.length){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED);
        }
    }

}
