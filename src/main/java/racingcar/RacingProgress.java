package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingProgress {

    private static String[][] carResult;

    public static void start(String console, String[] carList) {

        int cycle = Validation.attemptValueCheck(console);

        System.out.println("carList = " + carList.length);

        carResult = new String[carList.length][2];
        for (int i = 0; i < carList.length; i++) {
            carResult[i][0] = carList[i];
            carResult[i][1] = "";
        }

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < cycle; i++)
        {
            for (int j = 0; j < carList.length; j++) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    carResult[j][1] += "-";
                }
                System.out.println(carResult[j][0] + " : " + carResult[j][1]);
            }

            System.out.println();
        }
    }

    public static String[][] getCarResult() {
        return carResult;
    }
}
