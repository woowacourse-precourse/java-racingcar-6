package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private static final Input input = new Input();
    private static final Referee referee = new Referee();
    private static final String RESULT_MESSAGE =  "실행 결과";
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        // 사용자 입력 - 입력 객체는 입력을 받는 책임만을 가질 뿐 검증 책임은 다른 곳에서 가진다.
        String[] carsName = input.askCarsName();
        String tryNumString = input.askTryNum();
        int tryNum = Converter.convertStringToInt(tryNumString);
        InputValidator.validateTryNum(tryNum);

        // 자동차 생성
        for (String name : carsName) {
            cars.add(new Car(name));
        }

        startRace(cars, tryNum);

        // 각 자동차의 총 전진 횟수 담기
        List<Integer> totalMoveList = new ArrayList<>();
        cars.forEach(car -> {
            totalMoveList.add(car.getTotalMoveLen());
        });
        int max = Calculator.calculateMaxMove(totalMoveList);
        List<String> winners = referee.judgeWinners(cars, max);

        printWinners(winners);

        // 정상 종료 시 혹은 에러 발생에 의한 종료 시 close (필수적인 부분인지?)
        Console.close();
    }

    public static void runRound(List<Car> cars) {
        cars.forEach(car -> {
            int randomNumber = NumberGenerator.createRandomNumber();
            boolean isMove = referee.judgeMoveOrStop(randomNumber);
            car.moveOrStop(isMove);
        });
    }

    public static void printWinners(List<String> winners) {
        System.out.print(WINNERS_MESSAGE);
        String winnerList = String.join(", ", winners);
        System.out.println(winnerList);
    }

    public static void startRace(List<Car> cars, int tryNum) {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < tryNum; i++) {
            runRound(cars);
            System.out.println();
        }
    }

}
