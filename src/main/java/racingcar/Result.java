package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Result {
    ArrayList<Car> userArray = new ArrayList<>();

    Result(ArrayList<Car> userArray) {
        this.userArray = userArray;
    }

    public String finalWinner() {
        List<Integer> countArray = userArray.stream()
                .map(Car::getCount)
                .toList();

        int maxNumber = Collections.max(countArray);

        List<Integer> result = IntStream.range(0, countArray.size())
                .filter(i -> countArray.get(i) == maxNumber)
                .boxed()
                .toList();

        List<String> finalWinnerList = result.stream()
                .map(i -> userArray.get(i).getName())
                .toList();

        String lastString = String.join(", ", finalWinnerList);
        return lastString;

    }


}