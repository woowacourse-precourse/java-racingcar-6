package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Inputs inputs;
    boolean hasWinners; // 우승자가 여러명인지 판별하는 변수 : true이면 우승자가 여러명

    //게임을 시작
    public void startGame() {
        inputs = new Inputs();
        inputs.splitCarNames(inputs.askCarNames());
        inputs.askRaceNumbers();
        List<Car> cars = new ArrayList<>();
        int index = 0;
        for (String carName : inputs.carNamesList) {
            cars.add(new Car(carName, inputs.raceNumbers));
            doRace(cars, index);
            index++;
        }
        List<Car> winners = this.selectWinner(cars);
        hasWinners = areWinners(winners);
        printResult(cars, winners);
    }

    // 자동차 경주를 실행
    private void doRace(List<Car> cars, int index) {
        for (int i = 0; i < inputs.raceNumbers; i++) {
            cars.get(index).createRandomNumber();
            cars.get(index).goOrStop();
        }
    }

    // 최대 전진 회수를 체크하는 함수
    private int checkMaxGoNumber(Car car, int maxGoNumber, List<Car> winners) {
        if (car.totalGoNumber > maxGoNumber) { // 현재 자동차의 전진 회수 > 기존 최고 전진 회수
            maxGoNumber = car.totalGoNumber; // 기존 최고 전진 회수 업데이트
            winners.clear(); // 기존 우승자 목록 초기화
            winners.add(car); // 우승자 목록에 현재 자동차 추가
        } else if (car.totalGoNumber == maxGoNumber) { // 현재 자동차의 전진 회수 == 기존 최고 전진 회수
            winners.add(car); // 우승자 목록에 현재 자동차 추가
        }
        return maxGoNumber;
    }

    //우승자가 여러명인지 확인하는 메서드
    public boolean areWinners(List<Car> winners) {
        return winners.size() > 1;
    }

    List<Car> selectWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxGoNumber = 0;
        for (Car car : cars) {
            // 경주 자동차들의 최대 전진 회수를 체크
            maxGoNumber = checkMaxGoNumber(car, maxGoNumber, winners);
        }
        return winners;
    }

    public void printResult(List<Car> cars, List<Car> winners) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < inputs.raceNumbers; i++) {
            printResultByRound(cars, i);
            System.out.println();
        }
        if (hasWinners) {
            printWinners(winners);
        } else printWinner(winners);
    }

    private void printResultByRound(List<Car> cars, int turn) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.carName, arrayToStringByTurn(car.result, turn));
        }
    }

    String arrayToStringByTurn(String[] arr, int turn) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= turn; i++) {
            result.append(arr[i]);
        }
        return result.toString();
    }

    // 우승자가 한명인 경우 출력하는 메서드
    public void printWinner(List<Car> cars) {
        System.out.printf("최종 우승자 : %s", cars.get(0).carName);
    }

    // 우승자가 여러명인 경우 출력하는 메서드
    public void printWinners(List<Car> cars) {
        System.out.print("최종 우승자 : ");
        int i = 0;
        for (Car car : cars) {
            System.out.print(car.carName);
            checkPrintComma(cars, car);
        }
    }

    // 우승자가 여러명인 경우 ,를 붙일지 결정하는 함수
    private void checkPrintComma(List<Car> cars, Car car) {
        if (cars.indexOf(car) < cars.size() - 1) {
            System.out.print(", ");
        }
    }
}
