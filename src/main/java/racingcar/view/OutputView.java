package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;

public class OutputView {
    public void printRacingCarNameInputMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printNumberOfTryInputMessage(){
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void printResult(){
        System.out.println("실행 결과");
    }

    public void printRacingResult(List<RacingCar> racingCars){
        for(RacingCar racingCar : racingCars){
            System.out.println(racingCar + " : " + "-".repeat(racingCar.getMoveNumber()));
        }

        System.out.println();
    }

    public void printWinner(List<RacingCar> winners){
        System.out.print("최종 우승자 : ");

        String result = winners
                .stream()
                .map(RacingCar::toString)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
