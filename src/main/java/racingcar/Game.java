package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Game {

    private int round;  // 남은 회차 수
    private PriorityQueue<Car> carRepository;    // Car 저장소

    public Game() {
        carRepository = new PriorityQueue<>();
    }

    // 메인 흐름
    public void run() {
        // 조건들을 입력받는다.
        createCar();
        getRound();

        // 동작
        play();

    }

    void play() {
        System.out.println("실행 결과");
        while (round-- > 0) {
            roundProgress();
            printProgress();
        }
        printWinner();
    }

    // 우승자 안내 문구 출력
    void printWinner() {
        Car winner = carRepository.remove();
        System.out.print("최종 우승자 : "+winner.getName());
        for (Car car : carRepository) {
            if (car.getStatus() == winner.getStatus())
                System.out.println(", "+car.getName());
            else
                break;
        }
    }

    // 게임 진행 출력
    void printProgress() {
        for (Car car : carRepository) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getStatus()));
        }
    }


    // 한 회차를 진행한다
    void roundProgress() {
        for (Car car : carRepository) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) { // 이기는 경우
                car.go();
            }
        }
    }


    // 자동차 이름을 입력받는다
    void createCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateName(input);
        String[] names = input.split(",");
        for (String name : names) {
            carRepository.add(new Car(name));
        }
    }

    // 시도할 횟수를 입력받는다
    void getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        round = Integer.parseInt(input);
    }

    // 입력받은 자동차 이름 값 검증
    private void validateName(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > 5) {    // 이름은 5자 이하만 가능
                throw new IllegalArgumentException();
            }

        }
    }

}
