package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultDto {
    private final Map<Integer, SingleRoundResultDto> resultDtoByRound = new HashMap<>();
    private final int finalRound;
    private final List<String> finalWinners = new ArrayList<>();

    public ResultDto(int finalRound) {
        this.finalRound = finalRound;
    }

    public void addSingleRoundResult(int round, SingleRoundResultDto singleRoundResultDto) {
        resultDtoByRound.put(round, singleRoundResultDto);
    }

    public int getFinalRound() {
        return finalRound;
    }

    public SingleRoundResultDto getSingleRoundResultDto(int round) {
        return resultDtoByRound.get(round);
    }

    public void addFinalWinner(String winnerName) {
        finalWinners.add(winnerName);
    }

    public List<String> getFinalWinners() {
        return finalWinners;
    }
}