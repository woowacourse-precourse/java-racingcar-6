package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class Application {

    static String[] carNameList;
    static Map<String, Integer> carInfo;

    public static void main(String[] args) {

        startRacing();
        inputCarNames();
    }

    public static void startRacing() {

        inputCarNames();
    }

    public static void inputCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");

        String carNames = Console.readLine();
        carNameList = carNames.split(",");

        if (carNameList.length < 2) {

            throw new IllegalArgumentException("자동차 이름을 2개 이상 입력해주세요.");
        }

        for (String inputName : carNameList) {

            String carName = inputName.replaceAll("\\s", "");
            if (carName.length() > 5 || carName.length() == 0) {
                throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하만 가능합니다.");
            }
        }
    }

    public static void createCar() {

        for (String carName : carNameList) {
            carInfo.put(carName, 0);
        }
    }
}
