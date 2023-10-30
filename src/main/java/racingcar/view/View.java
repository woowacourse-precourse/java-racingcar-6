package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.List;

public class View {

    public String startMeg(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int countMeg(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void resultMeg(){
        System.out.println("실행 결과");
    }

    public void raceResult(List<Car> cars) {

        for (Car car  : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void winnerCar(String winner){
        System.out.println("최종 우승자 : " + winner);
    }
}
