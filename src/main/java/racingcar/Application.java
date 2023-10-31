package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        createCars(Console.readLine().trim());
        System.out.println("시도할 회수는 몇회인가요?");
        saveTrialNumber(Console.readLine().trim());
    }

    private static void createDriveCarNum () {
        Integer driveNumber = isMoreThanFour(createRandomNum());
    }

    private static Integer createRandomNum() {
        Integer randomNum = Randoms.pickNumberInRange(0,9);;
        return randomNum;
    }
    private static Integer isMoreThanFour (Integer randomNum) {
        if (randomNum >= 4) {
            return randomNum;
        } else {
            return 0;
        }
    }


    private static void createCars(String carNames) {
        String[] carList = carNames.split(",");
        Integer carListLength = carList.length;
        isCorrectCarsInput(carList, carListLength);
    }
    private static void saveTrialNumber(String trialNumberInput) {
        try {
            Integer trialNumber = Integer.valueOf(trialNumberInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private static void isCorrectCarsInput(String[] carList, Integer carListLength) {
        for (int i = 0; i < carListLength; i++) {
            Integer carNameLength = carList[i].length();
            if ( carNameLength > 5) {
                throw new IllegalArgumentException("이름의 길이가 5자가 넘어갑니다. ");
            }
        }
        //구분문자가 쉼표가 아닌 경우 한 명만 들어오면 쉼표는 없는데..

    }


}
