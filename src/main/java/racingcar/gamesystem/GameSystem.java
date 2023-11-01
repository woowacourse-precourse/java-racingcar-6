package racingcar.gamesystem;

import camp.nextstep.edu.missionutils.Console;
import racingcar.broadcaster.Broadcaster;
import racingcar.car.WoowahanRandomNumberGenerator;
import racingcar.race.Race;

import java.util.Arrays;
import java.util.List;

public class GameSystem {
    public static void start(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Arrays.asList(Console.readLine().split(","));
        validateCarNames(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        String userInputRoundNumber = Console.readLine();
        validateRoundNumber(userInputRoundNumber);
        int roundNumber = Integer.parseInt(userInputRoundNumber);

        Race race = new Race();
        WoowahanRandomNumberGenerator woowahanRandomNumberGenerator = new WoowahanRandomNumberGenerator();
        race.addCars(carNames, woowahanRandomNumberGenerator);

        System.out.println();
        System.out.println("실행 결과");
        for(int i = 0; i < roundNumber; i++){
            race.moveCars();
            Broadcaster.printCurrentRace(race.getEachCarNameAndLocation());
        }

        Broadcaster.printWinner(race.getFastestCarNames());
    }
    private static void validateCarNames(List<String> carNames){
        for(String carName : carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException("최대로 입력 가능한 글자 수는 5개입니다.");
            }
        }
    }
    private static void validateRoundNumber(String roundNumber){
        if(!roundNumber.matches("\\d+")){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
