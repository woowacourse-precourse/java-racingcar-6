package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    int playRound = 0;
    GenerateNumber generateNumber = new GenerateNumber();
    PlayController playController = new PlayController();
    ValidatorCheck validatorCheck = new ValidatorCheck();

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> players = playController.generateRacingCarName();
        validatorCheck.namingRacingCar_lengthCheck(players);
        //System.out.println(players.toString());
        System.out.println("플레이 할 횟수를 적어주세요.");
        playRound = Integer.parseInt(Console.readLine());

        //players 위치 설정 (초깃값 0)
        List<Integer> positions = new ArrayList<>(Collections.nCopies(players.size(), 0));

        for(int i=0; i<playRound; i++){
            List<Integer> randomNumbers = generateNumber.GenerateRandomNumber(players);
            playController.movingCar(players,randomNumbers,positions);

            printPlayerPositions(players, positions);
        }

        //우승자
        String winnerPlayers = playController.winPlayers(players,positions);
        System.out.println(winnerPlayers);
    }

    private void printPlayerPositions(List<String> players, List<Integer> positions) {
        for (int i = 0; i < players.size(); i++) {
            System.out.print(players.get(i) + " : ");
            for (int j = 0; j < positions.get(i); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        }
}