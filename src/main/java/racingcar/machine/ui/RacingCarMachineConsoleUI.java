package racingcar.machine.ui;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarMachineConsoleUI implements RacingCarMachineUI {
    @Override
    public void displayRequestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public List<String> inputCarNames() {
        return Arrays.stream(readLine().split(",")).toList();
    }

    @Override
    public void displayRequestNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public int inputNumberOfAttempts() {
        return Integer.parseInt(readLine());
    }

    @Override
    public void displayRaceProgress(String carName, int position) {
        System.out.print(carName + " : ");
        for(int i=0; i<position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void displayFinalWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if(i != winners.size()) {
                System.out.print(",");
            }
        }
    }
}
