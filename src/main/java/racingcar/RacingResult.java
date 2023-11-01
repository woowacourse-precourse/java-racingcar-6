package racingcar;

public class RacingResult {

    public static void LastWinner(int carsNum) {

        int max = 0;

        String[][] checkWinner = RacingProgress.getCarResult();

        for (int i = 0; i < carsNum; i++)
        {
            if (checkWinner[i][1].length() > max)
                max = checkWinner[i][1].length();
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < carsNum; i++)
        {
            if (checkWinner[i][1].length() == max)
                result.append(checkWinner[i][0]).append(", ");
        }

        result.deleteCharAt(result.length() - 2);

        System.out.println("최종 우승자 : " + result);
    }
}
