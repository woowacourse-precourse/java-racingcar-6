package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

import static racingcar.view.Message.*;

public class Play {
    private Map<String, Integer> racerInformation = new HashMap<>();
    private int gameTryNumber;



    public void playGame(){
        System.out.println(START_MESSAGE);
        //게임정보저장기능
        inputGameInformation();
        //게임결과메세지생성기능
        playResultMessage();
        //최종승자메세지생성기능
        championMessage();
    }

    public void inputGameInformation(){
        //자동차 이름 저장(inputCarNmaeInformation)
        String carName = Console.readLine();
        //자동차 이름 공백 예외 던지기
        varifyCarNameBlank(carName);
        // 자동차 이름 맵에 저장
        String[] carNameStringArray = carName.split(",");
        // 자동차 이름 5자 이상 예외처리
        varifyCarNameLength(carNameStringArray);
        //맵에 저장
        for (String carNameInformation : carNameStringArray) {
            racerInformation.put(carNameInformation, 0);
        }

        System.out.println(COUNT_MESSAGE);

        // 게임시도횟수 입력(inputTryNumberInformation)
        String checkGameTryNumber = Console.readLine();
        //공백 예외 던지기
        varifyCarNameBlank(checkGameTryNumber);
        //숫자가 아니면 예외 던지기
        varifyTryNumberIsNumeric(checkGameTryNumber);
        // 게임시도횟수 저장
        gameTryNumber = Integer.parseInt(checkGameTryNumber);
    }

    public void playResultMessage() {
        for (int i = 0; i < gameTryNumber; i++) {
            for (String carName : racerInformation.keySet()) {
                playOnce(carName);
            }
            System.out.println();
        }
    }

    public void playOnce(String carName){
        StringBuilder tempMessage = new StringBuilder();
        int diceNumber = Randoms.pickNumberInRange(0, 9);

        if(diceNumber >= 4){
            racerInformation.put(carName, racerInformation.get(carName) + 1);
        }
        System.out.println(creatResultMessage(tempMessage, carName));
    }

    public String creatResultMessage(StringBuilder tempMessage, String carName) {
        tempMessage.append(carName + " : ");
        for (int i = 0; i < racerInformation.get(carName); i++) {
            tempMessage.append(FOWARD_MESSAGE);
        }
        String resultMessage = tempMessage.toString();
        return resultMessage;
    }



    //예외처리
    public void varifyCarNameLength(String[] carNameStringArray){
        for (String charName : carNameStringArray) {
            if(charName.length() > 5){
                throw new IllegalArgumentException(wrongInputLength);
            }
        }
    }

    public void varifyCarNameBlank(String gameInformation){
        if(gameInformation.isBlank()){
            throw new IllegalArgumentException(wrongInputBlank);
        }
    }

    public void varifyTryNumberIsNumeric(String gameInformation){
        if(!gameInformation.matches("\\d+")){
            throw new IllegalArgumentException(wrongInputType);
        }
    }
}
