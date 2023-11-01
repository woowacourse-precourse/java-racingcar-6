package racingcar;

import static racingcar.InputHandler.createRacerFromInput;
import static racingcar.InputHandler.setAttemptCountFromInput;
import static racingcar.OutputFormatter.printCurrentStateOfRace;
import static racingcar.OutputFormatter.printNamesOfRacers;
import static racingcar.RaceLogic.attemptAllRacer;
import static racingcar.RaceLogic.findWinner;

public class Application {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Racer[] racers = createRacerFromInput();

        System.out.println("시도할 회수는 몇회인가요?");
        int attemptCount = setAttemptCountFromInput();

        System.out.println("실행 결과");
        for(int i=0; i<attemptCount; i++){
            attemptAllRacer(racers);
            printCurrentStateOfRace(racers);
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        printNamesOfRacers(findWinner(racers));

    }
}
