package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
        final String INPUT_CAR_NAMES_COMMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        final String INPUT_TRY_COUNT_COMMENT = "시도할 회수는 몇회인가요?";
        final String EXECUTION_RESULT_COMMENT = "실행 결과";
        final String TRYCOUNT_RANGE_EXCEPTION_COMMENT = "시도 가능한 회수의 범위를 넘어섰습니다.";

        List<RacingCar> racingCars = new ArrayList<>();
        Referee referee = new Referee();

        System.out.println(INPUT_CAR_NAMES_COMMENT);
        String unsplitNames = Console.readLine();
        List<String> participantNames = referee.splitCarName(unsplitNames);
        referee.checkNameNotExceed5Characters(participantNames);

      for (String participantName : participantNames) {
        RacingCar racingCar = new RacingCar(participantName);
        racingCars.add(racingCar);
      }

        System.out.println(INPUT_TRY_COUNT_COMMENT);
        long tryCount = Long.parseLong(Console.readLine());
        if(tryCount < 1 || tryCount > Integer.MAX_VALUE) {
          throw new IllegalArgumentException(TRYCOUNT_RANGE_EXCEPTION_COMMENT);
        }

        System.out.println(EXECUTION_RESULT_COMMENT);
        while(tryCount-- > 0) {
          for (RacingCar racingCar : racingCars) {
            racingCar.decideMovePosition();
            racingCar.printNameAndPosition();
          }
            System.out.println();
        }

        System.out.println("최종 우승자 : " + referee.findFinalWinner(racingCars));
    }
}