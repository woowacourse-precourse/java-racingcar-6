package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Vector;

public class Game {
    Player player;
    Car[] cars;
    int rounds;
    int firstPosition;
    Vector<String> winners;

    public Game() { // Game의 생성자, 게임 시작을 위한 초기 세팅
        winners = new Vector<>();
        firstPosition = 0;
        player = new Player();
        rounds = player.rounds;
        cars = new Car[player.cars.length]; // 자동차 n개의 배열을 위한 메모리 할당
        for (int i = 0; i < player.cars.length; i++) { // n개의 car 인스턴스 생성
            cars[i] = new Car(player.cars[i]);
        }
    }

    public void playGame() { // 입력 횟수만큼 반복
        for (int i = 0; i < rounds; i++) {
            startRound();
            printProgress();
        }
        getWinners();
        finishGame();
    }

    public void startRound() {
        for (Car car : cars) {
            if (moveForward(Randoms.pickNumberInRange(0, 9))) { // 난수 생성 및 4보다 큰지 판단
                car.moveForward();
            }
        }
    }

    public boolean moveForward(int randomNumber) {
        return randomNumber >= 4;
    }

    public void printProgress() {
        for (Car car : cars) {
            String name = car.getName();
            int position = car.getPosition();
            System.out.print(name + " : ");
            for (int j = 0; j < position; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getFirstPosition() {
        int firstPosition = 0;
        for (Car car : cars) {
            int tmp = car.getPosition();
            if (tmp < firstPosition) {
                continue;
            }
            firstPosition = tmp;
        }

        return firstPosition;
    }

    public void getWinners() {
        int firstPosition = getFirstPosition();
        for (Car car : cars) {
            int tmp = car.getPosition();
            if (tmp == firstPosition) {
                winners.add(car.getName());
            }
        }
    }

    public void finishGame() {
        String result = String.join(", ", winners);
        System.out.print("최종 우승자 : " + result);
    }
}
