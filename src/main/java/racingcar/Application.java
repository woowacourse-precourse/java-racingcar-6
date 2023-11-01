package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Application {
    static List<Car> cars = new ArrayList<>();
    static ArrayList<String> winners = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        createCars(Console.readLine().trim());
        System.out.println("시도할 회수는 몇회인가요?");
        Integer trialNumber = saveTrialNumber(Console.readLine().trim());
        System.out.println("\n실행결과");
        drive(trialNumber);
        showWinner(decideWinner(getMaxScore()));
    }
    private static void drive(Integer saveTrialNumber) {
        for (int i = 0; i<saveTrialNumber; i++) {
            updateDriveNum();
            driveResult();
            System.out.println("");
        }
    }
    private static Integer createDriveCarNum () {
        Integer driveNumber = isMoreThanFour(createRandomNum());
        return driveNumber;
    }
    private static Integer createRandomNum() {
        Integer randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }
    private static Integer isMoreThanFour (Integer randomNum) {
        if (randomNum >= 4) {
            return 1;
        } else {
            return 0;
        }
    }
    private static void updateDriveNum() {
        for (Car car : cars) {
            Integer newDriveNum = createDriveCarNum();
            car.setDriveNum(newDriveNum);
        }
    }
    private static void createCars(String carNames) {
        isContainComma(carNames);
        createCar(carNames);
        Integer carsLength = cars.size();
    }
    private static void createCar(String carNames) {
        for (String carName : carNames.split(",")) {
            isCorrectNameLength(carName.trim());
            Car car = new Car(carName.trim(), 0);
            cars.add(car);
        }
    }
    private static String makeResultSign(int number) {
        String resultSign="";
        for (int i = 0; i<number; i++) {
            resultSign+="-";
        }
        return resultSign;
    }
    private static void driveResult() {
        for (Car car : cars ) {
            System.out.println(car.getName()+" : "+makeResultSign(car.getDriveNum()));
        }
    }
    private static int getMaxScore() {
        int max = 0;
        int countPerson = 0;
        for (Car car : cars) {
            max = setMaxScore(max,car.getDriveNum());
        }
        return max;
    }
    private static int setMaxScore(int max, int driveNum) {
        if (max < driveNum)
            max = driveNum;
        return max;
    }
    private static boolean decideWinner(int max) {
        boolean isSolo = true;
        int countPerson = 0;
        for (Car car : cars) {
            if (max == car.getDriveNum()) {
                winners.add(car.getName());
                countPerson++;
            }
        }
        if (countPerson > 1) isSolo = false;
        return isSolo;
    }

    private static void showWinner(boolean decideWinner) {
        if (decideWinner) {
            System.out.println("최종 우승자 : "+ winners.get(0));
        } else {
            String winnerNames = String.join(", ",winners);
            System.out.println("최종 우승자 : "+winnerNames);
        }
    }
    private static Integer saveTrialNumber(String trialNumberInput) {
        try {
            Integer trialNumber = Integer.valueOf(trialNumberInput);
            return trialNumber;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
    private static void isCorrectNameLength(String carName) {
        if ( carName.isEmpty() || carName.length() > 5 ) {
            throw new IllegalArgumentException("이름의 길이를 5자 이하로 설정해주세요");
        }
    }
    private static void isContainComma(String carNames) {
        if (!carNames.contains(",") ) {
            throw new IllegalArgumentException("여러 대의 자동차를 쉼표로 입력해주세요");
        }
    }
}