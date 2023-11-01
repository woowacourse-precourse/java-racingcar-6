package racingcar.domain.service;

import racingcar.domain.GameNumber;
import racingcar.domain.Names;
import racingcar.global.utils.ConsoleUtil;

import java.util.ArrayList;
import java.util.List;

public class OutputService {

    public void outputWinner(List<List<Integer>> transposeAndDistanceList, Names names, GameNumber gameNumber) {
        List<String> nameList = names.getNameList().getNames();

        Integer numberOfGames = gameNumber.getClientGameNumber().getNumberOfGames();

        List<Integer> finalList = transposeAndDistanceList.get(numberOfGames-1);
        int max = Integer.MIN_VALUE;
        List<Integer> maxIndices = new ArrayList<>();

        for (int index = 0; index < finalList.size(); index++) {
            int value = finalList.get(index);

            if (value > max) {
                max = value;
                maxIndices.clear();
                maxIndices.add(index);
            } else if (value == max) {
                maxIndices.add(index);
            }
        }
        ConsoleUtil.excutionResultOutput(maxIndices, nameList);
    }

    public void outputDistance(List<List<Integer>> transposeAndDistanceList, Names names, GameNumber gameNumber) {
        List<String> nameList = names.getNameList().getNames();
        Integer numberOfGames = gameNumber.getClientGameNumber().getNumberOfGames();
        ConsoleUtil.resultTitleOutput();

        for (int index = 0; index < numberOfGames; index++) {
            List<Integer> distanceList = transposeAndDistanceList.get(index);
            ConsoleUtil.distanceOutput(nameList, distanceList);
            ConsoleUtil.lineOutput();
        }
    }
}
