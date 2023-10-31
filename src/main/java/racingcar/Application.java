package racingcar;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        createCars(Console.readLine().trim());
        System.out.println("시도할 회수는 몇회인가요?");
        saveTrialNumber(Console.readLine().trim());





    }
    private static void createCars(String carNames) {
        String[] carList = carNames.split(",");
        Integer carListLength = carList.length;
    }
    private static void saveTrialNumber(String trialNumberInput) {
        Integer trialNumber = Integer.valueOf(trialNumberInput);
    }


}
