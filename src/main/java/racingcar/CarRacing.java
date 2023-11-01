package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.CarNumberHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class CarRacing {
    private static final String PROMPT_ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT_ENTER_COUNT = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String ERROR_NO_INPUT = "[error] 값을 입력하세요.";
    private static final String ERROR_WRONG_INPUT = "[error] 숫자나 영어로 이루어진 자동차 이름을 입력하세요.";
    private static final String ERROR_WRONG_FORMAT = "[error] 잘못된 형식의 입력입니다.";
    private static final String ERROR_DUPLICATE_CAR_NAME = "[error] 자동차 이름이 중복되었습니다.";
    private static final String ERROR_CAR_NAME_LENGTH = "[error] 자동차 이름의 길이는 1이상 5이하 이어야 합니다.";
    private static final String ERROR_WRONG_COUNT = "[error] 시도 횟수는 자연수 이어야 합니다.";

    private static final int STANDARD_LENGTH = 5;


    private String carNames;
    private List<String> carNamesArray = new ArrayList<>();
    private List<Car> carArray = new ArrayList<>();
    private int userCount;


    public CarRacing() {
    }

    public void start() {
        System.out.println(PROMPT_ENTER_CAR_NAME);
        requestCarNames();
        getCarArray();

        System.out.println(PROMPT_ENTER_COUNT);
        requestUserCount();

        System.out.println(RESULT_MESSAGE);
        getRacingResult();
        printOutWinners();
    }

    public void requestCarNames() {
        carNames = Console.readLine();
        validateCarNames(carNames);
    }

    public void validateCarNames(String carNames) {
        isInputEmpty(carNames);
        isCarNameValid(carNames);
        isCarNameStringValid(carNames);
    }

    public void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NO_INPUT);
        }
    }

    public void isCarNameValid(String carNames) {
        for (int i = 0; i < carNames.length(); i++) {
            if (carNames.charAt(i) >= 'a' && carNames.charAt(i) <= 'z') {
                continue;
            } else if (carNames.charAt(i) >= 'A' && carNames.charAt(i) <= 'Z') {
                continue;
            } else if (carNames.charAt(i) >= '0' && carNames.charAt(i) <= '9') {
                continue;
            } else if (carNames.charAt(i) == ',') {
                continue;
            } else {
                throw new IllegalArgumentException(ERROR_WRONG_INPUT);
            }
        }
    }

    public void isCarNameStringValid(String carNames) {
        int carNameStringLength = carNames.length();
        if (carNames.charAt(0) == ',' || carNames.charAt(carNameStringLength - 1) == ',') {
            throw new IllegalArgumentException(ERROR_WRONG_FORMAT);
        }
    }

    public List<String> getCarNamesArray(String carNames) {
        String[] carNamesStringArray = carNames.split(",");
        carNamesArray = Arrays.asList(carNamesStringArray);
        validateCarNamesArray(carNamesArray);
        return carNamesArray;
    }

    public void validateCarNamesArray(List<String> carNamesArray) {
        isCarNameDuplicate(carNamesArray);
        isCarNameValidLength(carNamesArray);
    }

    public void isCarNameDuplicate(List<String> carNamesArray) {
        Set<String> set = new HashSet<>();
        for (String carName : carNamesArray) {
            if (!set.add(carName)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_CAR_NAME);
            }
        }
    }

    public void isCarNameValidLength(List<String> carNamesArray) {
        for (String carName : carNamesArray) {
            if (carName.isEmpty() || carName.length() > STANDARD_LENGTH) {
                throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
            }
        }
    }

    public void requestUserCount() {
        String stringCount = Console.readLine();
        validateUserCount(stringCount);
        userCount = Integer.parseInt(stringCount);
    }

    public void validateUserCount(String stringCount) {
        isInputEmpty(stringCount);
        if (stringCount.charAt(0) == '0' || !(stringCount.charAt(0) >= '0' && stringCount.charAt(0) <= '9')) {
            throw new IllegalArgumentException(ERROR_WRONG_COUNT);
        }
        for (int i = 1; i < stringCount.length(); i++) {
            if (!(stringCount.charAt(i) >= '0' && stringCount.charAt(i) <= '9')) {
                throw new IllegalArgumentException(ERROR_WRONG_COUNT);
            }
        }
    }

    public void getCarArray() {
        getCarNamesArray(carNames);
        for (String carName : carNamesArray) {
            Car car = new Car(carName);
            carArray.add(car);
        }
    }

    public void getRacingResult() {
        for (int i = 0; i < userCount; i++) {
            CarNumberHandler.moveCars(carArray);
            printOutResult();
        }
    }


    public void printOutResult() {
        for (Car car : carArray) {
            String carName = car.getCarName();
            System.out.println(carName + " : " + carMoveState(car));
        }
        System.out.println();
    }

    public String carMoveState(Car car) {
        StringBuilder carState = new StringBuilder();
        int carMoveCount = car.getMoveCount();
        for (int i = 0; i < carMoveCount; i++) {
            carState.append("-");
        }
        return carState.toString();
    }

    public void printOutWinners() {
        System.out.print("최종 우승자 : " + getWinners());
    }

    public String getWinners() {
        List<String> Winners = new ArrayList<>();
        int maxCount = getMaxCount();
        for (Car car : carArray) {
            int carMoveCount = car.getMoveCount();
            String carName = car.getCarName();
            if (carMoveCount == maxCount) {
                Winners.add(carName);
            }
        }
        return String.join(", ", Winners);
    }

    public int getMaxCount() {
        int maxCount = 0;
        for (Car car : carArray) {
            int carMoveCount = car.getMoveCount();
            if (carMoveCount > maxCount) {
                maxCount = carMoveCount;
            }
        }
        return maxCount;
    }
}
