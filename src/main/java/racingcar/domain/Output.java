package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Output {
    static int randomNumber;
    static int[] gameResult = new int[StaticInputs.carNamesArray.length];


    public static int randomNumber() {
        randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
    public static String randomOutput(int randomNumber) {
        String str = "-";
        return str.repeat(randomNumber);
    }


    //시도할 회수 만큼 게임 진행
    public static void view() {
        for (int i = 0; i < StaticInputs.intCount; i++) {
            updateGameResult();
            System.out.println();
            System.out.println();
        }
    }

    //각각의 게임 진행
    public static int[] updateGameResult() {
        int tmp = 0;
        int[] go = new int[StaticInputs.carNamesArray.length];
        for (int i = 0; i < StaticInputs.carNamesArray.length; i++) {
            int randomNumber = randomNumber();
            System.out.println(StaticInputs.carNamesArray[i] + " : " + randomOutput(randomNumber));
            if (randomNumber >= 4) {
                gameResult[i] += 1;
                go[i] = 1;
            }
        }
        System.out.print("전진한 자동차 : ");
        for (int i = 0; i < StaticInputs.carNamesArray.length; i++) {
            if (go[i] == 1) {
                System.out.print(StaticInputs.carNamesArray[i]);
                tmp = i;
                break;
            }
        }
        for (int i = tmp + 1; i < StaticInputs.carNamesArray.length; i++) {
            if (go[i] == 1) {
                System.out.print(", " + StaticInputs.carNamesArray[i]);
            }
        }

        return gameResult;
    }
}
