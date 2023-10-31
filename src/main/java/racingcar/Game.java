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

    // 게임을 시작하고 결과를 출력
    public void start() {
        userInputCarName();
        userInputAttemptsNumber();

        System.out.println("실행 결과");

        while (currentRound < attemptsNumber) {
            playRound();
        }

        printResult();
    }

    // 사용자가 콘솔에서 입력 방법을 보고 입력 하도록함
    public void userInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInputCarNameString = Console.readLine(); // 유저에게서 콘솔로 입력 받기
        String[] userInputCarNameArray = stringToArrayByComma(userInputCarNameString); // 쉼표로 구분하여 String 배열 만들기
        new Validator().validateNameArray(userInputCarNameArray); // 이름 5자 이하 유효성 검사

        carList = new ArrayList<>();

        for (String userInputCarName : userInputCarNameArray) {
            carList.add(new Car(userInputCarName));
        }
    }

    // 시도할 횟수를 묻고 콘솔로 입력 받음
    public void userInputAttemptsNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        attemptsNumber = Integer.valueOf(Console.readLine());
    }

    // String 값을 쉼표로 구분하여 배열로 반환
    public String[] stringToArrayByComma(String userInputString) {
        return userInputString.split(",");
    }

    // 게임 한라운드를 진행
    public void playRound() {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            judgeMovingForward(car); // 앞으로 갈지말지 숫자를 생성해 판단하고 앞으로감
            printCarNameAndCurrentLocation(car); // 차의 이름과 현재 위치 출력
            setHighestLocation(car); // highestLocation을 갱신함
        }
        System.out.println();
        currentRound++;
    }

    // 랜덤한 숫자를 생성하고 4이상일때 앞으로 가도록함
    public void judgeMovingForward(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.movingForward();
        }
    }

    // [차 이름] : [현재 위치] 형식으로 출력
    private void printCarNameAndCurrentLocation(Car car) {
        System.out.print(car.getName() + " : ");
        car.printCurrentLocation();
    }

    // 최종 우승자들의 명단을 String.join을 사용하여 출력
    private void printResult() {
        List<Car> winners = getWinners(carList);
        List<String> winnersName = new ArrayList<>();

        for (Car car : winners) {
            winnersName.add(car.getName());
        }

        System.out.println("최종 우승자 : " + String.join(", ", winnersName));
    }

    // 최대 위치 값과 같은 현재 위치를 가진 차들(우승자들)을 반환하도록 함
    private List<Car> getWinners(List<Car> cars) {
        List<Car> winnerCarList = new ArrayList<>();

        for (Car car : cars) {
            if (car.getCurrentLocation().equals(highestLocation)) {
                winnerCarList.add(car);
            }
        }
        return winnerCarList;
    }

    // 게임 라운드를 진행할 때 마다 모든 car값의 위치를 넣어 높으면 highestLocation를 갱신한다
    private void setHighestLocation(Car car) {
        Integer carLocation = car.getCurrentLocation();

        if (highestLocation < carLocation) {
            highestLocation = carLocation;
        }
    }
}
