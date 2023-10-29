package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.IntStream;

import static racingcar.RacingGameController.createRacingCars;

public class RacingGame {
    public RacingGame(){

    }

    public void play(){
        Cars userCars = createCars();
        Integer repeat = repeatCount();
        System.out.println("실행 결과");
        IntStream.range(0, repeat).forEach(j -> {
            IntStream.range(0, userCars.getCarsLength()).mapToObj(i ->
                    userCars.getCars().get(i)).forEach(RacingGameController::randomDice);
            displayGameProcessing(userCars);
        });
        displayGameResult(userCars);
    }

    public Cars createCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return createRacingCars();
    }

    public Integer repeatCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine().trim());
    }

    public void displayGameProcessing(Cars cars){
        System.out.println(cars.toString());
    }

    public void displayGameResult(Cars cars){
        List<String> winners = RacingGameController.getWinner(cars);
        System.out.println("최종 우승자 : "+String.join(", ", winners));
    }
}
