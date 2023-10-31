package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String cars;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = Console.readLine();
        //이름이 5자 이하인지 확인

        //각 자동차 이름과
        //각 자동차 전진횟수를 리스트로 선언
        List<String> carName = new ArrayList<>(Arrays.asList(car));
        List<Integer> forwardCount = new ArrayList<>();

        /*
        String attempt;
        System.out.println("시도할 회수는 몇회인가요?");
        attempt = Console.readLine();
        System.out.println("실행 결과");
        */
    }
}
