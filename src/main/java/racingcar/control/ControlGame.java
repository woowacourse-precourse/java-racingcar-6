package racingcar.control;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.SplitPlayerName;
import racingcar.model.StringToInt;
import racingcar.view.PrintMessage;

public class ControlGame {
    PrintMessage systemMessage = new PrintMessage();
    List<String> playerName;
    int roundNumber;


    public void StartGame(){
        systemMessage.printStart();
        String inputPlayerName = Console.readLine();
        playerName = SplitPlayerName.splitPlayerName(inputPlayerName);

        systemMessage.printRound();
        String inputRoundNumber = Console.readLine();
        roundNumber = StringToInt.stringToInt(inputRoundNumber);
        
        //메세지 불러와, 입력 받아, 처리해
        //메세지 불러와, 입력 받아
    }
    
    void PlayGame(){
        //이름 랭스만큼
        //랜덤수 생성
        //검증
        //전진
        //전진 값 저장
    }
    
    void EndGame(){

    }
}
