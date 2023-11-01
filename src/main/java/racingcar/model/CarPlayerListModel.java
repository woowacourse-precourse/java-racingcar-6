package racingcar.model;

import java.util.List;

public record CarPlayerListModel(List<CarPlayerModel> players) {
    public int getMaxPosition() {
        return this.players.stream().mapToInt(CarPlayerModel::getCurrentPosition).max().orElse(0);
    }

    public void movePlayers() {
        this.players.forEach(CarPlayerModel::move);
    }

    public List<CarPlayerModel> filterPlayersByPosition(int position) {
        return this.players.stream().filter(player -> player.getCurrentPosition() == position).toList();
    }
}
