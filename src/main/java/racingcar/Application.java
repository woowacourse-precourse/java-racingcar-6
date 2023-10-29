package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class Application {

    static String[] carNameList;
    static Map<String, Car> carInfo;
    static int tryCount;
    static int maxScore;

    public static void main(String[] args) {

        inputCarNames();
        createCar();
        inputCarNames();
        startRacing();
    }

    public static void startRacing() {

        for (int i = 0; i < tryCount ; i++) {

            checkRandomNumberAndUpdateCarScore();

        }
    }

    public static void checkRandomNumberAndUpdateCarScore() {

        for (String carName : carNameList) {

            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                Car car = carInfo.get(carName);
                car.plusScore();
            }
        }
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

            carInfo.put(carName, new Car(carName));
        }
    }

    public static void inputTryCount() {

        tryCount = Integer.parseInt(Console.readLine());
    }
}
