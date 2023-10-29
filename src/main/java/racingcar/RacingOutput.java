package racingcar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingOutput {
    public void putNameInputStatement() throws IOException
    {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    public void putTryInputStatement() throws IOException
    {
        System.out.print("시도할 회수는 몇회인가요?\n");
    }

    public void putResultStatement() throws IOException
    {
        System.out.print("실행 결과\n");
    }

    public void putResultOfEachCar(int cnt) throws IOException
    {
        for (int i = 0 ; i<cnt; i++)
        {
            System.out.print("-");
        }
    }

    public void putResultOfMovement(int n, List<String> carNames, List<Integer> carDis) throws IOException
    {
        for (int i = 0 ; i<n ; i++)
        {
            System.out.print(carNames.get(i) + " : ");
            putResultOfEachCar(carDis.get(i));
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public List<String> getResultOfWinner(int n, List<String> carName, List<Integer> carDis) throws IOException
    {
        if (n==0)    return new ArrayList<>();

        int biggestDis = carDis.get(0);
        List<String> winnerList = new ArrayList<>(Collections.nCopies(1, carName.get(0)));

        for (int i = 1 ; i<n ; i++)
        {
            if (carDis.get(i) > biggestDis)
            {
                winnerList = new ArrayList<>(Collections.nCopies(1, carName.get(i)));
                biggestDis = carDis.get(i);
            }
            else if (carDis.get(i) == biggestDis)
            {
                winnerList.add(carName.get(i));
            }
        }

        return winnerList;
    }

    public void putResultOfWinner(List<String> winnerNames) throws IOException
    {
        System.out.print("최종 우승자 : ");
        String winners = String.join(", ", winnerNames);
        System.out.print(winners + '\n');
    }

}
