package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    // 객체 생성 (의존성 주입?)
    private static final NumberGenerator numberGenerator = new NumberGenerator();
    private static final Input input = new Input();
    private static final String RESULT_MESSAGE =  "실행 결과";

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        // 사용자 입력 - 입력 객체는 입력을 받는 책임만을 가질 뿐 검증 책임은 다른 곳에서 가진다.
        String[] carsName = input.askCarsName();
        int tryNum = input.askTryNum();

        // 자동차 생성
        for (String name : carsName) {
            cars.add(new Car(name));
        }

        // round 시작
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < tryNum; i++) {
            runRound(cars);
            System.out.println();
        }

        // 각 자동차의 총 전진 횟수 담기
        List<Integer> totalMoveList = new ArrayList<>();
        cars.forEach(car -> {
            totalMoveList.add(car.getTotalMove());
        });

        int max = Calculator.calculateMax(totalMoveList);
        List<String> winners = Referee.judgeWinner(cars, max);

        // 우승자 출력
        printWinners(winners);

        // 정상 종료 시 혹은 에러 발생에 의한 종료 시 close (필수적인 부분인지?)
        Console.close();
    }

    public static void runRound(List<Car> cars) {
        cars.forEach(car -> {
            int randomNumber = numberGenerator.createRandomNumber();
            boolean isMove = Referee.judgeMoveOrStop(randomNumber);
            car.moveOrStop(isMove);
        });
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i + 1 != winners.size())
                System.out.print(", ");
        }
        System.out.println();
    }
}
