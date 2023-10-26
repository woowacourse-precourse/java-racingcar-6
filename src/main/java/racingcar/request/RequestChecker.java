package racingcar.request;

import camp.nextstep.edu.missionutils.Console;
import racingcar.entity.car.Name;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static racingcar.constants.ErrorConstants.DUPLICATE_NAME_ERROR_MESSAGE;
import static racingcar.constants.ErrorConstants.NOT_DIGIT_ERROR_MESSAGE;

public class RequestChecker {

    public static Set<Name> requestNames(){
        String[] names = Console.readLine().split(",");
        return convertToName(names);
    }

    private static Set<Name> convertToName(String[] oldNames){
        Set<Name> names = Arrays.stream(oldNames)
                .map(Name::new)
                .collect(Collectors.toSet());

        if (!hasDuplicateCarName(oldNames.length,names.size())){
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }

        return names;
    }

    private static boolean hasDuplicateCarName(int oldNameSize, int nameSize){
        return oldNameSize == nameSize;
    }

    public static int getNumberOfMovementAttempts(){
        String movementAttempts = Console.readLine();
        return parseInt(movementAttempts);
    }

    private static int parseInt(String movementAttempts) {
        try {
            return Integer.parseInt(movementAttempts);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_DIGIT_ERROR_MESSAGE);
        }
    }
}
