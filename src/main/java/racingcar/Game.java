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

    public void run() {
        createCar();
        getRound();
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


    void createCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        for (String name : names) {
            carRepository.add(new Car(name));
        }
    }

    void getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        round = Integer.valueOf(Console.readLine());
    }

}
