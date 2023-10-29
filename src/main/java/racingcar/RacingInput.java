package racingcar;
import camp.nextstep.edu.missionutils.*;
import java.util.List;

public class RacingInput {
    private List<String> getNameOfCars() throws IllegalArgumentException
    {
        String carNames = Console.readLine();
        List<String> nameOfEachCars = List.of(carNames.split(","));

        int n = nameOfEachCars.size();
        for(int i = 0 ; i<n ; i++)
        {
            if(nameOfEachCars.get(i).length() > 5)
            {
                throw new IllegalArgumentException("차의 이름이 5 초과입니다");
            }
        }

        return nameOfEachCars;
    }
}