package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.driver.Driver;
import racingcar.judge.Judge;
import racingcar.opportunityvalidator.OpportunityValidator;
import racingcar.race.RaceSimulator;

import java.util.Map;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Driver driver = new Driver();
        String drivers = Console.readLine();
        Map<String, String> driverMap = driver.makeDriverRoster(drivers);
        driver.validateDriverRoster(driverMap);

        System.out.println("시도할 회수는 몇 회인가요?");
        String opportunity = Console.readLine();
        OpportunityValidator opportunityValidator = new OpportunityValidator();
        opportunityValidator.validateOpportunity(opportunity);

        System.out.println();
        System.out.println("실행 결과");
        RaceSimulator raceSimulator = new RaceSimulator();
        raceSimulator.simulateRace(driverMap, Integer.parseInt(opportunity));

        Judge judge = new Judge();
        String winners = judge.calculateWinners(driverMap);
        System.out.println("최종 우승자 : " + winners);
    }
}
