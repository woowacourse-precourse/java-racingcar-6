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

    public void putResultOfMovement(List<Car> carList) throws IOException
    {
        for (Car car : carList)
        {
            System.out.print(car.getName() + " : ");
            putResultOfEachCar(car.getDistance());
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public List<String> getResultOfWinner(List<Car> carList)
    {
        if (carList.size()==0)    return new ArrayList<>();

        int biggestDis = -1;
        List<String> winnerList = new ArrayList<>();

        for (Car car : carList)
        {
            if (car.getDistance() > biggestDis)
            {
                winnerList = new ArrayList<>();
                winnerList.add(car.getName());
                biggestDis = car.getDistance();
            }
            else if (car.getDistance() == biggestDis)
            {
                winnerList.add(car.getName());
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
