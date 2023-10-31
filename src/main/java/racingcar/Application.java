package racingcar;

import java.util.List;
import racingcar.domain.Generator;
import racingcar.domain.RaceCar;
import racingcar.domain.UserInput;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        RaceCar raceCar = new RaceCar(userInput.carName());
        int moveNumber = userInput.moveNumber();
        System.out.println();
        System.out.println("실행 결과");
        Generator generator = new Generator();
        while (moveNumber != 0) {
            List<Integer> randomNumbers = generator.createRandomNumbers(raceCar.names.size());
            raceCar.forward(randomNumbers);
            for (int i = 0; i < raceCar.names.size(); i++) {
                System.out.println(raceCar.names.get(i) + " : " + raceCar.moveDistance.get(i));
            }
            System.out.println();
            moveNumber--;
        }
        System.out.println("최종 우승자 : " + raceCar.winner());
    }
}
