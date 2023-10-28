package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = Console.readLine().split(",");
        ArrayList<Car> carList = new ArrayList<>();
        for(String name : input) {
            if(name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이내로 작성해주세요.");
            }
            carList.add(new Car(name, 0));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int N = Integer.parseInt(Console.readLine());

        // 주행 결과 출력
        System.out.println("실행 결과");
        for(int i=0; i<N; i++) {
            for(Car car : carList) {
                System.out.print(car.getName() + " : ");
                for(int j=0; j<car.getCount(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }

    }
}
