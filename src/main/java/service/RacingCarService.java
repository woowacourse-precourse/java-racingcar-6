package service;

import domain.Players;
import domain.RacingCar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCarService {

    private Players players;

    private static final String COMMA_WITH_WHITESPACE = ", ";
    private static final String FINAL_WINNERS = "최종 우승자";
    private static final String COLON_WITH_WHITESPACE = " : ";

    public int generateRacingCar(Set<String> carNameSet) {
        players = new Players(generate(carNameSet));
        return players.size();
    }

    private static List<RacingCar> generate(Set<String> carNameSet) {
        return carNameSet.stream().map(carName -> new RacingCar(carName))
                                  .collect(Collectors.toList());
    }

    public String racing(int cycle) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < cycle; i++) {
            builder.append(players.processRacing());
        }

        return builder.toString();
    }

    public String judgeWinners() {
        return String.join(COLON_WITH_WHITESPACE, FINAL_WINNERS,
                String.join(COMMA_WITH_WHITESPACE, players.findWinners()));
    }

}
