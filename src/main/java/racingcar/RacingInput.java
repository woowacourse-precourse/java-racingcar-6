package racingcar;
import camp.nextstep.edu.missionutils.*;
import java.util.List;

public class RacingInput {
    private List<String> getNameOfCars() throws IllegalArgumentException
    {
        String carNames = Console.readLine();
        List<String> nameOfEachCars = List.of(carNames.split(","));

        int n = nameOfEachCars.size();
        for(String carName : nameOfEachCars)
        {
            if(carName.length() > 5)
            {
                throw new IllegalArgumentException("차의 이름이 5 초과입니다");
            }
        }

        return nameOfEachCars;
    }

    private long getCountOfTries() throws IllegalArgumentException
    {
        long cnt = 0;
        try
        {
            cnt = Long.parseLong(Console.readLine());
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException("시도 횟수를 입력받아 변환하는 중 문제가 생겼습니다.");
        }

        return cnt;
    }
}