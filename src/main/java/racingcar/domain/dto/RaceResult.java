package racingcar.domain.dto;

import racingcar.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public record RaceResult (
        List<RoundResult> roundResultList
){
    public static RaceResult of(List<RoundResult> roundResultList) {
        return new RaceResult(roundResultList);
    }

    @Override
    public String toString() {
        return roundResultList.stream()
                .map(RoundResult::toString)
                .collect(Collectors.joining("\n\n")) +
                "\n" +
                "최종 우승자 : " +
                getWinnerToString();
    }

    private List<Name> getRaceWinner() {
        return roundResultList.get(roundResultList.size() - 1).getWinner();
    }

    private String getWinnerToString() {
        return getRaceWinner().stream()
                .map(Name::toString)
                .collect(Collectors.joining(", "));
    }
}
