package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.GameStatus;
import racingcar.exception.CarExceptionMessage;
import racingcar.exception.MoveCountExceptionMessage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(GameStatus.PLAYING);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        if (!isValidCarNames(carNames)) {
            racingGame.setStatus(GameStatus.INVALID_USER_INPUT);
            return;
        }

        racingGame.setParticipants(changeToRacingCarList(carNames));

        System.out.println("시도할 회수는 몇회인가요?");
        String inputMoveCountString = Console.readLine();

        if (!isValidMoveCount(inputMoveCountString)) {
            racingGame.setStatus(GameStatus.INVALID_USER_INPUT);
        } else {
            int moveCount = Integer.parseInt(inputMoveCountString);
            racingGame.start(moveCount);
        }
    }

    /**
     * 입력받은 자동차이름들로 RacingCar 객체를 만들어 List로 반환한다.
     * @param carNames 입력받은 자동차 이름
     * @return RacingCar 객체로 변환된 List
     */
    private static List<RacingCar> changeToRacingCarList(String carNames) {
        String[] carNameArray = carNames.split(GameDetail.CAR_SEPARATOR);
        List<RacingCar> racingCars = Arrays.stream(carNameArray).map(RacingCar::new).collect(Collectors.toList());
        return racingCars;
    }

    /**
     * 자동차 이름 입력값이 유효한지 검증
     * @param carNames 자동차 이름 입력값
     * @return 유효하면 true, 그렇지 않으면 false
     */
    public static boolean isValidCarNames(String carNames) {
        String[] carNameArray = carNames.split(GameDetail.CAR_SEPARATOR);

        if (isLessThanMinParticipatingCarCount(carNameArray)) {
            throw new IllegalArgumentException(String.format("%s = %s", CarExceptionMessage.UNDER_MIN_CAR_COUNT, carNames));
        }

        if (isContainInvalidSizeCarName(carNameArray)) {
            throw new IllegalArgumentException(String.format("%s = %s", CarExceptionMessage.OVERSIZE_CAR_NAME, carNames));
        }

        if (isContainSpecialCharactersOnlyCarName(carNameArray)) {
            throw new IllegalArgumentException(String.format("%s = %s", CarExceptionMessage.ONLY_SPECIAL_CHARACTER_CAR_NAME, carNames));
        }

        if (isContainDuplicateCarName(carNameArray)) {
            throw new IllegalArgumentException(String.format("%s = %s", CarExceptionMessage.DUPLICATE_CAR_NAME, carNames));
        }
        return true;
    }

    /**
     * 자동차 이름 입력값이 최소 참여 자동차 수 이상인지 검증
     * @param carNameArray 자동차 이름 입력값의 array
     * @return 최소 참여 자동차 수 이상이면 true, 그렇지 않으면 false
     */
    private static boolean isLessThanMinParticipatingCarCount(String[] carNameArray) {
        return carNameArray.length <= GameDetail.MIN_CAR_COUNT;
    }

    /**
     * 자동차 이름 입력값 중 유효하지 않은 길이의 자동차 이름이 있는지 검증
     * @param carNameArray 자동차 이름 입력값의 array
     * @return 유효하지 않은 길이의 자동차 이름이 있으면 true, 그렇지 않으면 false
     */
    private static boolean isContainInvalidSizeCarName(String[] carNameArray) {
        for (String carName : carNameArray) {
            if (carName.length() < GameDetail.CAR_NAME_MIN_LENGTH || carName.length() > GameDetail.CAR_NAME_MAX_LENGTH) {
                return true;
            }
        }
        return false;
    }

    /**
     * 자동차 이름 입력값 중 특수문자로만 이루어진 값이 있는지 검증
     * @param carNameArray 자동차 이름 입력값의 array
     * @return 특수문자로만 이루어진 값이 있으면 true, 그렇지 않으면 false
     */
    private static boolean isContainSpecialCharactersOnlyCarName(String[] carNameArray) {
        for (String carName : carNameArray) {
            if (!GameDetail.CAR_NAME_PATTERN.matcher(carName).matches()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 자동차 이름 입력값에 중복된 자동차 이름이 있는지 검증
     * @param carNameArray 자동차 이름 입력값의 array
     * @return 중복된 자동차 이름이 있으면 true, 그렇지 않으면 false
     */
    private static boolean isContainDuplicateCarName(String[] carNameArray) {
        HashMap<String, Integer> carNameCount = new HashMap<>();
        for (String carName : carNameArray) {
            carNameCount.put(carName, carNameCount.getOrDefault(carName, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : carNameCount.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 이동 횟수 입력이 유효한지 검증
     * @param inputString 이동 횟수로 입력받은 값
     * @return 유효하면 true, 그렇지 않으면 false
     */
    private static boolean isValidMoveCount(String inputString) {
        if (!isPositiveNumber(inputString)) {
            throw new IllegalArgumentException(String.format("%s = %s", MoveCountExceptionMessage.NOT_POSITIVE_NUMBER, inputString));
        }
        return true;
    }

    /**
     * 입력값이 양수인지 검증
     * @param input 입력값
     * @return 양수이면 true, 그렇지 않으면 false
     */
    private static boolean isPositiveNumber(String input) {
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return num > 0;
    }

}
