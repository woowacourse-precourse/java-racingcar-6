package racingcar;

import racingcar.domain.Input;
import racingcar.domain.Movement;
import racingcar.domain.Race;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playRacingCar();
    }

    private static void playRacingCar() {

        Input input = new Input();
        Movement movement = new Movement();
        Race race = new Race();

        List<String> names = input.createNames(); // 이름 리스트
        int moveCount = input.moveCount(); // 총 이동 가능한 횟수
        List<Integer> movementList = movement.createMovement(names); // 누적 이동값 리스트

        System.out.println();
        System.out.println("실행 결과");
        while (true) {

            movement.eachRace(names, movementList);

            if (movementList.contains(moveCount)) break;
        }

        race.printWinner(names, movementList, moveCount);
    }
}
