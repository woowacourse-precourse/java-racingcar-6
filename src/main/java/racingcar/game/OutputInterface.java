package racingcar.game;

import game.Game;
import game.Output;
import java.util.List;
import racingcar.game.renderer.RacingCarGameRenderer;

public class OutputInterface implements Output {
    private Output out;
    private RacingCarGameRenderer renderer;

    public OutputInterface(Output out, RacingCarGameRenderer renderer) {
        this.out = out;
        this.renderer = renderer;
    }

    public void printStage(Game game) {
        out.println(game.render() + "\n");
    }

    public void printWinners(List<String> winners) {
        out.println(renderer.renderWinners(winners));
    }

    @Override
    public void println(String str) {
        out.println(str);
    }

}
