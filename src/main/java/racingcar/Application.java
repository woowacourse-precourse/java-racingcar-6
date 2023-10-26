package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.drive.Drive;
import racingcar.race.Racing;
import racingcar.driver.Driver;

public class Application {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Drive drive = new Drive();
        Racing racing = new Racing();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String drivers = Console.readLine();
        System.out.println("시도활 회수는 몇 회 인가요?");
        String opportunity = Console.readLine();
        System.out.println("최종 우승자 : ");
    }
}
