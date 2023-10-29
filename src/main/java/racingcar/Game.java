package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    final int COUNT_MINIMUM_CAR = 2;
    final String SEPARATOR_CAR_NAME = ",";
    final String MESSAGE_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    final String MESSAGE_ASK_TRY = "시도할 회수는 몇회인가요?\n";
    final String MESSAGE_RACE_RESULT = "실행 결과\n";
    public List<Car> carList;
    public int roundNumber;

    public Game() {
        this.carList = new ArrayList<Car>();
        this.roundNumber = 0;
    }

    public void startGame() {
        System.out.print(MESSAGE_START);
        inputCarsName();

        System.out.print(MESSAGE_ASK_TRY);
        inputRoundNumber();
        
        System.out.print(MESSAGE_RACE_RESULT);
        proceedEachRound();
    }

    public void inputCarsName() {
        String inputNames = Console.readLine();

        if (inputNames == null) {
            throw new IllegalArgumentException(String.format("%d대 이상의 이름을 입력해야 합니다", COUNT_MINIMUM_CAR));
        }

        String[] arrayNames = inputNames.split(SEPARATOR_CAR_NAME);
        List<String> carNameList = Arrays.asList(arrayNames);

        if (!validateCarNamesLength(carNameList)) {
            throw new IllegalArgumentException(String.format("%d대 이상의 이름을 입력해야 합니다", COUNT_MINIMUM_CAR));
        }
        if (!validateCarNameDuplication(carNameList)) {
            throw new IllegalArgumentException("중복되는 이름이 있습니다.");
        }

        createCarList(carNameList);
    }

    public void inputRoundNumber() {
        String inputRoundNumber = Console.readLine();

        validateIsOnlyNumber(inputRoundNumber);
        validateIsGraterZero(inputRoundNumber);
    }

    private void createCarList(List<String> carNameList) {
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    public void proceedEachRound() {
        for (int i = 0; i < roundNumber; i++) {
            for (Car car : carList) {
                car.runCar();
            }

            System.out.println();
        }
    }

    public boolean validateCarNameDuplication(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);

        if (nameSet.size() == nameList.size()) {
            return true;
        }

        return false;
    }

    public boolean validateCarNamesLength(List<String> nameList) {
        if (nameList.size() >= COUNT_MINIMUM_CAR) {
            return true;
        }

        return false;
    }

    public void validateIsOnlyNumber(String inputNumber) {
        try {
            roundNumber = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private void validateIsGraterZero(String inputNumber) {
        if (inputNumber == null) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요");
        }

        int resultNumber = Integer.parseInt(inputNumber);

        if (resultNumber <= 0) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요");
        }

        roundNumber = resultNumber;
    }
}
