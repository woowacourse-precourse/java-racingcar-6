package racingcar.domain.service;

import racingcar.domain.GameNumber;
import racingcar.domain.Names;
import racingcar.domain.Numbers;
import racingcar.global.utils.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class CreateListService {

    public List<List<Integer>> transposeAndDistanceList(Names names, GameNumber gameNumber) {

        Integer numberOfGames = gameNumber.getClientGameNumber().getNumberOfGames();
        Numbers numbers = createRandomNumbers(names, numberOfGames);
        List<List<Integer>> numberList = numbers.getNumbers().getRandomNumbers();


        List<List<Integer>> transposedList = new ArrayList<>(numberOfGames);

        for (int index = 0; index < numberOfGames; index++) {
            List<Integer> newRow = new ArrayList<>(names.getNameCount());
            transposedList.add(newRow);
        }

        for (int index2 = 0; index2 < names.getNameCount(); index2++) {
            int prevValue = 0;
            for (int index = 0; index < numberOfGames; index++) {
                int value = numberList.get(index2).get(index);
                int currentValue = prevValue + (value >= 4 ? 1 : 0);
                transposedList.get(index).add(currentValue);
                prevValue = currentValue;
            }
        }
        return transposedList;
    }


    private Numbers createRandomNumbers(Names names, Integer numberOfGames) {

        int nameCount = names.getNameCount();
        return new Numbers(new RandomNumberGenerator(), numberOfGames, nameCount);
    }
}
