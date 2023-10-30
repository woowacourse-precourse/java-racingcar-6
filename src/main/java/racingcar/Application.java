package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Race;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        Race race = Generator.makeRace(inputNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumberString = Console.readLine();
        int number = Generator.stringToInteger(inputNumberString);
        System.out.println();

        System.out.println("실행 결과");
        for (int count = 0; count < number; count++) {
            race.phase();
            View.showPhase(race.getCarList());
        }

        System.out.print("최종 우승자 : ");
        View.showResult(race.checkWinner());
    }
}
