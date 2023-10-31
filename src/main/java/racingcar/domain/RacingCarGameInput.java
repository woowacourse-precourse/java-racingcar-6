package racingcar.domain;

import static racingcar.utils.RacingCarUtil.validateCarList;
import static racingcar.utils.RacingCarUtil.validateCarNamesInput;
import static racingcar.utils.RacingCarUtil.validateDuplication;
import static racingcar.utils.RacingCarUtil.validateMoveCount;
import static racingcar.utils.RacingCarUtil.validateNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.RacingCar;

public class RacingCarGameInput {

    public static List<RacingCar> readCarNames() {
        String input = Console.readLine();
        validateCarNamesInput(input);

        String[] arr = input.split(",");
        validateDuplication(arr);

        List<RacingCar> carList = Arrays.stream(arr)
                .map(RacingCar::new)
                .toList();
        validateCarList(carList);
        return carList;
    }

    public static int readMoveCount() {
        String input = Console.readLine();
        validateNumber(input);

        int moveCount = Integer.parseInt(input);
        validateMoveCount(moveCount);
        return moveCount;
    }


}
