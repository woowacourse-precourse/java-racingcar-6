package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import view.OutputView;

public class RaceWinnerPrinter {

    private final OutputView outputView = new OutputView();

    public void print(RaceDto raceDto) {
        List<Integer> AdvanceIntList = convertAdvanceStringToInt(raceDto);
        int maxAdvance = calculateMaxAdvance(AdvanceIntList);
        List<String> winnerList = findWinner(maxAdvance, raceDto);
        String winnerString = format(winnerList);
        outputView.printWinner(winnerString);
    }

    private int calculateMaxAdvance(List<Integer> advanceList) {
        int maxAdvance = 0;
        for (int advance : advanceList) {
            maxAdvance = Math.max(maxAdvance, advance);
        }
        return maxAdvance;
    }

    private List<Integer> convertAdvanceStringToInt(RaceDto raceDto) {
        List<String> carNameList = raceDto.getCarNameList();
        List<Integer> carAdvanceList = new ArrayList<>();
        for (String carName : carNameList) {
            carAdvanceList.add(raceDto.getCarNameToAdvanceMap().get(carName).length());
        }
        return carAdvanceList;
    }

    private List<String> findWinner(int maxAdvance, RaceDto raceDto) {
        Map<String, String> carNameToAdvanceMap = raceDto.getCarNameToAdvanceMap();
        Set<String> carNames = raceDto.getCarNameToAdvanceMap().keySet();
        List<String> winnerNames = new ArrayList<>();
        for (String carName : carNames) {
            if (carNameToAdvanceMap.get(carName).length() == maxAdvance) {
                winnerNames.add(carName);
            }
        }
        return winnerNames;
    }

    private String format(List<String> winnerNames){
        return String.join(", ", winnerNames);
    }
}
