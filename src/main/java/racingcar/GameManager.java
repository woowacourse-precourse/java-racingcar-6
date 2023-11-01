package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameManager {

    /**
    게임을 시작하는 메소드입니다.

    사용자로부터 자동차 이름 및 시도 회수를 입력받습니다.
    RacingCarGame 클래스의 play 메소드를 호출하여 게임을 진행합니다.
     */
    public static void launch(){
        List<String> carNames = getCarNames();
        int tryCount = getTryCount();

        RacingCarGame.play(carNames, tryCount);
    }
    /**
    사용자로부터 자동차 이름을 입력받는 메소드입니다.

    입력받은 자동차의 이름을 쉼표로 구분하여 리스트로 반환합니다.
    또한, 각 자동차 이름에 대하여 Discriminator 클래스로부터 유효성 검증을 받습니다.
     */
    private static List<String> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        List<String> carNames = List.of(carNamesInput.split(","));
        carNames.forEach((Discriminator::validateCarName));
        Discriminator.validateCarNumber(carNames.size());
        return carNames;
    }
    /**
    사용자로부터 시도 회수를 입력받는 메소드입니다.

    입력값에 대하여 Discriminator 클래스로부터 유효성 검증을 받습니다.
    또한 이를 정수로 변환하여 반환받습니다.
     */
    private static int getTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCountInput = Console.readLine();
        Discriminator.validateTrialCount((tryCountInput));
        return Integer.parseInt(tryCountInput);
    }
}
