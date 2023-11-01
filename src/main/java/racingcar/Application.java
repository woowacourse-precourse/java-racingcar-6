package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Movement;
import racingcar.domain.Winner;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputCarsName;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarsName = Console.readLine();

        Car cars = new Car();
        String[] carNameArr;
        carNameArr = cars.splitCarName(inputCarsName);
        cars.correctCarName(carNameArr);
        //각 자동차 이름과
        //각 자동차 전진횟수를 리스트로 선언 -> "-"를 담는 리스트와 회수 count 리스트를 별도로 생성
        List<String> carNameList = new ArrayList<>(Arrays.asList(carNameArr));

        List<String> forwardCountStr = new ArrayList<>();
        List<Integer> forwardCountInt = new ArrayList<>();
        //전진횟수를 모두 ""으로 초기화
        cars.forwardStrReset(forwardCountStr, carNameArr);
        //전진횟수를 모두 0으로 초기화
        cars.forwardIntReset(forwardCountInt, carNameArr);

        String attempt;
        System.out.println("시도할 회수는 몇회인가요?");
        attempt = Console.readLine();

        System.out.println("\n실행 결과");
        Movement moving = new Movement();
        moving.forwardOrStop(attempt, carNameList, forwardCountStr, forwardCountInt);

        System.out.print("최종 우승자 : ");
        List<String> winnerList;
        Winner finalWinner = new Winner();
        winnerList = finalWinner.gameResult(carNameList, forwardCountInt);

        String winners = finalWinner.insertSeparator(winnerList);
        System.out.println(winners);
    }
}
