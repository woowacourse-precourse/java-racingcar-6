package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Integer attemptsNumber;
    private Integer currentRound;
    private Integer highestLocation;
    private List<Car> carList;


    public Game() {
        this.currentRound = 0;
        this.highestLocation = 0;
    }

    public void start() {
        userInputCarName();
        userInputAttemptsNumber();

        System.out.println("실행 결과");

        while (currentRound < attemptsNumber) {
            playRound();
        }

        System.out.println("끝");
    }

    public void userInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInputCarNameString = Console.readLine();
        String[] userInputCarNameArray = stringToArrayByComma(userInputCarNameString);

        carList = new ArrayList<>();

        for (String userInputCarName : userInputCarNameArray) {
            carList.add(new Car(userInputCarName));
        }
    }

    public void userInputAttemptsNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        attemptsNumber = Integer.valueOf(Console.readLine());
    }

    public String[] stringToArrayByComma(String userInputString) {
        return userInputString.split(",");
    }

    public void playRound() {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            judgeMovingForward(car); // 차가 앞으로 갈지 판단
            printCarNameAndCurrentLocation(car); // 차의 이름과 현재 위치 출력
            setHighestLocation(car); // highestLocation을 갱신함
        }
        System.out.println();
        currentRound++;
    }

    public void judgeMovingForward(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.movingForward();
        }
    }

    private void printCarNameAndCurrentLocation(Car car) {
        System.out.print(car.getName() + " : ");
        car.printCurrentLocation();
    }

    private void printResult() {

    }

    // 게임 라운드를 진행할 때 마다 모든 car값의 위치를 넣어 높으면 highestLocation를 갱신한다
    private void setHighestLocation(Car car) {
        Integer carLocation = car.getCurrentLocation();

        if (highestLocation < carLocation) {
            highestLocation = carLocation;
        }
    }
}
