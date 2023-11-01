package racingcar.control;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CheckWinner;
import racingcar.model.GenerateRandomNumber;
import racingcar.model.SplitPlayerName;
import racingcar.model.StringToInt;
import racingcar.model.VerifyRandomNumber;
import racingcar.view.PrintMessage;

public class ControlGame {
    PrintMessage systemMessage = new PrintMessage();
    List<String> playerName;
    int roundNumber;
    List<Integer> scoreList = new ArrayList<>();

    public void StartGame() {
        systemMessage.printStart();

        String inputPlayerName = Console.readLine();
        playerName = SplitPlayerName.splitPlayerName(inputPlayerName);

        systemMessage.printRound();
        String inputRoundNumber = Console.readLine();
        roundNumber = StringToInt.stringToInt(inputRoundNumber);
    }

    public void PlayGame() {
        systemMessage.printPlay();
        System.out.println();
        int countRound = 0;

        GenerateRandomNumber generator = new GenerateRandomNumber();
        int randomNumber;

        boolean verify;

        while (countRound < roundNumber) {
            for (int i = 0; i < playerName.size(); i++) {
                scoreList.add(0);
            }

            for (int i = 0; i < playerName.size(); i++) {
                randomNumber = generator.generateRandomNumber();
                verify = VerifyRandomNumber.verifyRandomNumber(randomNumber);
                if (verify) {
                    int currentScore = scoreList.get(i);
                    scoreList.set(i, currentScore + 1);
                }
            }

            for (int i = 0; i < playerName.size(); i++) {
                System.out.print(playerName.get(i) + systemMessage.printSymbolA());
                for (int j = 0; j < scoreList.get(i); j++) {
                    System.out.print(systemMessage.printSymbolB());
                }
                System.out.println();
            }
            System.out.println();

            countRound++;
        }
    }

    public void EndGame() {
        List<Integer> winnerIndex = CheckWinner.checkWinner(scoreList);

        System.out.print(systemMessage.printEnd());
        System.out.print(systemMessage.printSymbolA());
        String winner = new String();

        for (int i = 0; i < winnerIndex.size(); i++) {
            int index = winnerIndex.get(i);
            winner = winner + playerName.get(index) + ", ";
        }

        winner = winner.substring(0, winner.length() - 2);
        System.out.println(winner);
    }
}
