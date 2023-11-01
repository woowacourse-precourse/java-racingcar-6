package racingcar;

import racingcar.control.ControlGame;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // GenerateRandomNumber generator = GenerateRandomNumber.create();

        // int randomNumber = generator.getRandomNumber();
        // System.out.println(randomNumber);

        // String test = "pobi,woni,jun";
        // List<String> testres = SplitPlayerName.splitPlayerName(test);

        // System.out.println(testres);
        // System.out.println(testres.get(0));

        // boolean testverify = VerifyRandomNumber.verifyRandomNumber(randomNumber);
        // System.out.println(testverify);

        // PrintMessage systemMessage = new PrintMessage();
        // System.out.println(test+systemMessage.printSymbolA());

        // for(int j=0;j<2;j++){
        //     System.out.print(systemMessage.printSymbolB());
        // }
        // System.out.println();

        // List<Integer> test2 = List.of(3,2,1);
        // List<Integer> test3 = CheckWinner.checkWinner(test2);
        // System.out.println(test3);

        ControlGame game = new ControlGame();
        game.StartGame();
        game.PlayGame();
        game.EndGame();

        
    }
}
