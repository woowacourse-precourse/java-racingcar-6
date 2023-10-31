package racegame;

import camp.nextstep.edu.missionutils.Randoms;
import car.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private final List<Car> cars;
    private final int rounds;

    public RaceGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }
    // 경주 게임 시작
    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            moveCars();
            System.out.println();
        }
        printWinners();
    }
    //자동차가 직진 또는 정지를 결정하는 무작위값을 생성
    private void moveCars() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
            printCarPosition(car);
        }
    }
    // 자동차의 위치를 출력
    private void printCarPosition(Car car) {
        String positionString = new String(new char[car.getPosition()]).replace('\0', '-');
        System.out.println(car.getName() + " : " + positionString);
    }
    // 우승자 출력
    private void printWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
    // 가장 멀리간 자동차의 위치를 찾음
    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}