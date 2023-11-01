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
        // 메세지 불러와, 입력 받아, 처리해
        // 메세지 불러와, 입력 받아
    }

    public void PlayGame() {

        systemMessage.printPlay();
        System.out.println();
        int countRound = 0;
        // List<Integer> scoreList=new ArrayList<>();

        GenerateRandomNumber generator = new GenerateRandomNumber();
        int randomNumber;

        boolean verify;

        while (countRound < roundNumber) {

            for (int i = 0; i < playerName.size(); i++) {
                scoreList.add(0);
            }

            for (int i = 0; i < playerName.size(); i++) {
                randomNumber = generator.generateRandomNumber();
                // System.out.println(randomNumber);
                verify = VerifyRandomNumber.verifyRandomNumber(randomNumber);
                // System.out.println(verify);
                if (verify) {
                    int currentScore = scoreList.get(i);
                    scoreList.set(i, currentScore + 1);
                }
            }

            for (int i = 0; i < playerName.size(); i++) {
                // String buffer = playerName.get(i) + systemMessage.printSymbolA();
                System.out.print(playerName.get(i) + systemMessage.printSymbolA());
                for (int j = 0; j < scoreList.get(i); j++) {
                    System.out.print(systemMessage.printSymbolB());
                }
                System.out.println();
            }
            System.out.println();

            countRound++;
        }

        // 이름 랭스만큼
        // 랜덤수 생성
        // 검증
        // 전진
        // 전진 값 저장
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
