package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Judgement;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String unCheckedCarNames = Console.readLine();
        List<String> carNames = Judgement.getNamesFromUser(unCheckedCarNames);

        List<Car> participatingCars = new ArrayList<>();
        for(String carName : carNames){
            participatingCars.add(new Car(carName, 0));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String unParsedPlayCount = Console.readLine();
        int playCount = Judgement.getPlayCountFromUser(unParsedPlayCount);

        System.out.println();
        System.out.println("실행결과");
        for(int i = 0;  i < playCount; i++){
            for(Car currentCar : participatingCars){
                currentCar.move(Randoms.pickNumberInRange(0,9));
                System.out.println(currentCar.showCarPosition());
            }
            System.out.println();
        }

        System.out.print("최종 우승자 : "+Judgement.judgeWinners(participatingCars));

    }
}
