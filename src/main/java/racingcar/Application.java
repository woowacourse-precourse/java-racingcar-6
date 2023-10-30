package racingcar;

import java.util.List;

import racingcar.control.ControlGame;
import racingcar.model.GenerateRandomNumber;
import racingcar.model.SplitPlayerName;
import racingcar.model.VerifyRandomNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GenerateRandomNumber generator = GenerateRandomNumber.create();

        int randomNumber = generator.getRandomNumber();
        System.out.println(randomNumber);

        String test = "pobi,woni,jun";
        List<String> testres = SplitPlayerName.splitPlayerName(test);

        System.out.println(testres);
        System.out.println(testres.get(0));

        boolean testverify = VerifyRandomNumber.verifyRandomNumber(randomNumber);
        System.out.println(testverify);

        ControlGame game = new ControlGame();
        game.StartGame();

        
    }
}
