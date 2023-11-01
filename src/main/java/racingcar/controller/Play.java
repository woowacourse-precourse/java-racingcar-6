package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

import static racingcar.view.Message.*;

public class Play {
    private Map<String, Integer> racerInformation = new HashMap<>();
    private int gameTryNumber;


    public void playGame() {
        System.out.println(START_MESSAGE);
        inputGameInformation();
        playResultMessage();
        championMessage();
    }

    public void inputGameInformation() {
        String carName = Console.readLine();
        varifyCarNameBlank(carName);
        String[] carNameStringArray = carName.split(",");
        varifyCarNameLength(carNameStringArray);
        for (String carNameInformation : carNameStringArray) {
            racerInformation.put(carNameInformation, 0);
        }
        System.out.println(COUNT_MESSAGE);
        String checkGameTryNumber = Console.readLine();
        varifyCarNameBlank(checkGameTryNumber);
        varifyTryNumberIsNumeric(checkGameTryNumber);
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

    public void playOnce(String carName) {
        StringBuilder tempMessage = new StringBuilder();
        int diceNumber = Randoms.pickNumberInRange(0, 9);
        if (diceNumber >= 4) {
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

    public void championMessage() {
        StringBuilder tempChampoinMessage = new StringBuilder();
        tempChampoinMessage.append(CHAMPION_MESSAGE);
        int champoinNumber = forwrdMax();
        findChampoin(tempChampoinMessage, champoinNumber);
        deleteEndSuplus(tempChampoinMessage);
        String champoinMessage = tempChampoinMessage.toString();
        System.out.println(champoinMessage);
    }

    public int forwrdMax() {
        int forwrdMax = Integer.MIN_VALUE;
        for (String carName : racerInformation.keySet()) {
            forwrdMax = Math.max(forwrdMax, racerInformation.get(carName));
        }
        return forwrdMax;
    }

    public void findChampoin(StringBuilder tempChampoinMessage, int champoinNumber) {
        for (String carName : racerInformation.keySet()) {
            if (racerInformation.get(carName) == champoinNumber) {
                tempChampoinMessage.append(carName);
                tempChampoinMessage.append(", ");
            }
        }
    }

    public void deleteEndSuplus(StringBuilder tempChampoinMessage) {
        tempChampoinMessage.delete(tempChampoinMessage.length() - 2, tempChampoinMessage.length());
    }


    //예외처리
    public void varifyCarNameLength(String[] carNameStringArray) {
        for (String charName : carNameStringArray) {
            if (charName.length() > 5) {
                throw new IllegalArgumentException(wrongInputLength);
            }
        }
    }

    public void varifyCarNameBlank(String gameInformation) {
        if (gameInformation.isBlank()) {
            throw new IllegalArgumentException(wrongInputBlank);
        }
    }

    public void varifyTryNumberIsNumeric(String gameInformation) {
        if (!gameInformation.matches("\\d+")) {
            throw new IllegalArgumentException(wrongInputType);
        }
    }
}
