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
        DriveProcedure.drive(trialNumber);
        showWinner(decideWinner(getMaxScore()));
    }
    private static void createCars(String carNames) {
        InputException.isContainComma(carNames);
        createCar(carNames);
        Integer carsLength = cars.size();
    }

    private static void createCar(String carNames) {
        for (String carName : carNames.split(",")) {
            InputException.isCorrectNameLength(carName.trim());
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

}