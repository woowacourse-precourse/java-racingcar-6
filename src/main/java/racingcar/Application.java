package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.BasicController;
import racingcar.response.ProcessMessage;
import racingcar.validation.InputValidation;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(ProcessMessage.REQUIRE_CAR_NAME_MESSAGE.getMsg());
        String carInput = Console.readLine();

        System.out.println(ProcessMessage.REQUIRE_TRY_NUMBER_MESSAGE.getMsg());
        String tryInput = Console.readLine();
        Integer tryNum = Integer.parseInt(tryInput);

        BasicController controller = new BasicController(carInput, tryNum);

        if(!InputValidation.validateInput(carInput)) {
            throw new IllegalArgumentException();
        }

        while(tryNum > 0){
            controller.tryOneGame();
            tryNum--;
        }
    }
}
