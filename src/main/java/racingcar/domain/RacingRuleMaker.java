package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//- RacingRuleMaker
//        - [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
//            - [ ] 자동차에 이름 부여 - namingCar()
//                - [ ] 자동차의 이름을 입력받기 - Console 활용
//                - [ ] 입력받은 문자열을 리스트로 변환 - split() 활용
//            - [ ] n대의 자동차 리스트 - List<String> cars
//        - [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
//            - [ ] 몇번의 이동을 할것인가 입력 (주어진 횟수(게임세트수)) int roundCount
public class RacingRuleMaker {

    public List<String> cars = new ArrayList<>();
    public int roundCount;

    public RacingRuleMaker() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        namingCar();
        System.out.println("시도할 회수는 몇회인가요?");
        inputRacingRound();

    }

    public List<String> namingCar() {
        String carNames = Console.readLine();

        String[] carsNamesArray = carNames.split(",");
        cars = Arrays.asList(carsNamesArray);
        return cars;
    }

    public void inputRacingRound() {
        String inputRacingRound = Console.readLine();

        roundCount = Integer.parseInt(inputRacingRound);
    }


}
