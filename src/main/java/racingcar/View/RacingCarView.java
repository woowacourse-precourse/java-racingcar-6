package racingcar.View;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.RacingCar;

public class RacingCarView {

    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int getRoundsInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = Integer.parseInt(Console.readLine());
        System.out.println("실행 결과");
        return rounds;
    }

    public void printRaceResult(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            String dashes = "";
            for (int i = 0; i < racingCar.getPosition(); i++) {
                dashes += "-";
            }
            System.out.println(racingCar.getName() + " : " + dashes);
        }
    }

    public void printWinners(List<String> winners) {
        StringBuilder winnerNames = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i));
            if (i < winners.size() - 1) { // 마지막 요소가 아니면 쉼표와 공백을 추가
                winnerNames.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + winnerNames.toString());
    }

}
