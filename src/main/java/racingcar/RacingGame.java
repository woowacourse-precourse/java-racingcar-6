package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.GameStatus;

import java.util.HashMap;
import java.util.Map;

public class RacingGame {

    private GameStatus status;

    public RacingGame(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public void start(int moveCount) {
        System.out.println("게임 시작");
        status = GameStatus.PLAYING;

        String carNames = Console.readLine();
        if (!isValidCarNames(carNames)) {
            status = GameStatus.INVALID_USER_INPUT;
        }

        if (status == GameStatus.PLAYING) {
            String[] carNameArray = carNames.split(GameDetail.CAR_SEPARATOR);
        }
    }

    /**
     * 자동차 이름 입력값이 유효한지 검증
     * @param carNames 자동차 이름 입력값
     * @return 유효하면 true, 그렇지 않으면 false
     */
    public boolean isValidCarNames(String carNames) {
        String[] carNameArray = carNames.split(GameDetail.CAR_SEPARATOR);

        if (isLessThanMinParticipatingCarCount(carNameArray)) {
            throw new IllegalArgumentException(String.format("%d대 이하의 자동차 입력값 포함 = %s", GameDetail.MIN_CAR_COUNT, carNames));
        }

        if (isContainInvalidSizeCarName(carNameArray)) {
            throw new IllegalArgumentException(String.format("%d~%d자가 아닌 자동차이름 입력값 포함 = %s", GameDetail.CAR_NAME_MIN_LENGTH, GameDetail.CAR_NAME_MAX_LENGTH, carNames));
        }

        if (isContainSpecialCharactersOnlyCarName(carNameArray)) {
            throw new IllegalArgumentException(String.format("특수문자로만 구성된 자동차이름 입력값 포함 = %s", carNames));
        }

        if (isContainDuplicateCarName(carNameArray)) {
            throw new IllegalArgumentException(String.format("중복된 자동차이름 입력값 포함 = %s", carNames));
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

}
