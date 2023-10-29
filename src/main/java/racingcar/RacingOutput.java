package racingcar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class RacingOutput {
    private BufferedWriter bw;

    RacingOutput()
    {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private void putNameInputStatement() throws IOException
    {
        bw.write("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    private void putTryInputStatement() throws IOException
    {
        bw.write("시도할 회수는 몇회인가요?");
    }

    private void putResultOfEachCar(int cnt) throws IOException
    {
        for (int i = 0 ; i<cnt; i++)
        {
            bw.write("-");
        }
    }

    private void putResultOfMovement(int n, List<Integer> carNames, List<Integer> carDis) throws IOException
    {
        for (int i = 0 ; i<n ; i++)
        {
            bw.write(carNames.get(i) + " : ");
            putResultOfEachCar(carDis.get(i));
            bw.write("\n");
        }
        bw.write("\n");
    }

    private List<Integer> getResultOfWinner(int n, List<Integer> carNames, List<Integer> carDis) throws IOException
    {
        if (n==0)    return new ArrayList<>();

        int biggestDis = carDis.get(0);
        List<Integer> winnerList = List.of(0);

        for (int i = 1 ; i<n ; i++)
        {
            if (carDis.get(i) > biggestDis)
            {
                winnerList = List.of(i);
                biggestDis = carDis.get(i);
            }
            else if (carDis.get(i) == biggestDis)
            {
                winnerList.add(i);
            }
        }

        return winnerList;
    }
}
