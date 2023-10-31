package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static String[] carNameList;
    public static ArrayList<String> winner;
    public static Map<String, Car> carInfo;
    public static int tryCount;
    public static int maxScore = 0;

    public static void main(String[] args) {

        initVariables();
        inputCarNames();
        createCar();
        inputTryCount();
        startRacing();
    }

    public static void initVariables() {

        winner = new ArrayList<>();
        carInfo = new HashMap<>();
    }

    public static void startRacing() {

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {

            GoOrStop();
            printCurrentState();
        }

        getMaxScore();
        printWinner();
    }

    public static void GoOrStop() {

        for (String carName : carNameList) {

            int randomNumber = Randoms.pickNumberInRange(0, 9);
            checkRandomNumberAndUpdateCarScore(carName, randomNumber);
        }
    }

    private static void checkRandomNumberAndUpdateCarScore(String carName, int randomNumber) {
        if (randomNumber >= 4) {

            Car car = carInfo.get(carName);
            car.plusScore();
        }
    }

    public static void printCurrentState() {

        for (String carName : carNameList) {

            Car car = carInfo.get(carName);
            System.out.println(carName + " : " + "-".repeat(car.getScore()));
        }

        System.out.println();
    }

    public static void getMaxScore() {

        for (String carName : carNameList) {

            int carScore = carInfo.get(carName).getScore();
            updateMaxScore(carScore);
        }
    }

    public static void updateMaxScore(int carScore) {

        if (maxScore < carScore) {

            maxScore = carScore;
        }
    }

    public static void printWinner() {

        for (String carName : carNameList) {

            int carScore = carInfo.get(carName).getScore();
            updateWinner(carScore, carName);
        }

        System.out.print("최종 우승자 : " + String.join(", ", winner));
    }

    public static void updateWinner(int carScore, String carName) {

        if (maxScore == carScore) {

            winner.add(carName);
        }
    }

    public static void inputCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = Console.readLine();
        carNameList = carNames.split(",");
        exceptionInputCarNames();
    }

    public static void exceptionInputCarNames() {

        if (carNameList.length < 2) {

            throw new IllegalArgumentException("자동차 이름을 2개 이상 입력해주세요.");
        }

        for (String inputName : carNameList) {

            String carName = inputName.replaceAll("\\s", "");
            checkNameLength(carName);
        }
    }

    public static void checkNameLength(String carName) {

        if (carName.length() > 5 || carName.length() == 0) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하만 가능합니다.");
        }
    }

    public static void createCar() {

        for (String carName : carNameList) {
            carInfo.put(carName, new Car(carName));
        }
    }

    public static void inputTryCount() {

        System.out.println("시도할 회수는 몇회인가요?");
        tryCount = Integer.parseInt(Console.readLine());
    }
}
