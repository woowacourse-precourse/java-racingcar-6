package racingcar.model;

import java.util.List;

public record RacingCarPlayerListModel(List<RacingCarPlayerModel> players) {
    public int getMaxPosition() {
        return this.players.stream().mapToInt(RacingCarPlayerModel::getCurrentPosition).max().orElse(0);
    }

    public void movePlayers() {
        this.players.forEach(RacingCarPlayerModel::move);
    }

    public List<RacingCarPlayerModel> filterPlayersByPosition(int position) {
        return this.players.stream().filter(player -> player.getCurrentPosition() == position).toList();
    }
}
