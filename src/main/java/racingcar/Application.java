package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        List<Car> carNameList = getCarNames();
        int tryingCount = getTryingNumber();

        playRacing(carNameList, tryingCount);

    }

    public static List<Car> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = readLine();

        return makeCarNameList(inputNames);

    }

    public static List<Car> makeCarNameList(String inputNames) {
        List<Car> carNameList = new ArrayList<>();
        List<String> splitArr = List.of(inputNames.split(","));
        //콤마만 있는 경우 검사
        checkInputValue(splitArr);

        for (String inputName : splitArr) {
            carNameList.add(new Car(inputName));
        }
        return carNameList;
    }

    public static void checkInputValue(List<String> splitList){
        if (splitList.size() <= 1){
            throw new IllegalArgumentException();
        }
    }

    public static int getTryingNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String tryingCount = readLine();
        int count = checkTryingNumber(tryingCount);

        return count;
    }

    public static int checkTryingNumber(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    public static void playRacing(List<Car> carNameList, int count) {

        for (int i = 0; i < count; i++) {
            forwardPlayer(carNameList);
        }
        System.out.println("최종 우승자 : " + findWinner(carNameList));

    }

    public static void forwardPlayer(List<Car> carNameList) {

        for (int i = 0; i < carNameList.size(); i++) {
            Car car = carNameList.get(i);
            if (isForward(makeRandomNumber())) {
                car.forwardDash += "-";
            }
            System.out.println(car.name + " : " + car.forwardDash);
        }
        System.out.println();

    }

    public static boolean isForward(int randomNum) {
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static String findWinner(List<Car> carNameList) {
        int winnerCount = 0;
        String winner = "";

        for (int i = 0; i < carNameList.size(); i++) {
            Car car = carNameList.get(i);
            String forwardDash = car.forwardDash;
            if (forwardDash.length() > winnerCount) {
                winner = car.name;
                winnerCount = forwardDash.length();
            } else if (forwardDash.length() == winnerCount) {
                winner += "," + car.name;
            }
        }
        return winner;
    }

}
