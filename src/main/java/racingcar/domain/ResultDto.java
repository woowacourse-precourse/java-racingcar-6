package racingcar.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultDto {
    private final Map<BigInteger, SingleRoundResultDto> resultDtoByRound = new HashMap<>();
    private final BigInteger finalRound;
    private final List<String> finalWinners = new ArrayList<>();

    public ResultDto(BigInteger finalRound) {
        this.finalRound = finalRound;
    }

    public void addSingleRoundResult(BigInteger round, SingleRoundResultDto singleRoundResultDto) {
        resultDtoByRound.put(round, singleRoundResultDto);
    }

    public BigInteger getFinalRound() {
        return finalRound;
    }

    public SingleRoundResultDto getSingleRoundResultDto(BigInteger round) {
        return resultDtoByRound.get(round);
    }

    public void addFinalWinner(String winnerName) {
        finalWinners.add(winnerName);
    }

    public List<String> getFinalWinners() {
        return finalWinners;
    }
}
