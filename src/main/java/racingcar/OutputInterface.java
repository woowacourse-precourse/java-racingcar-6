package racingcar;

import java.util.List;

public class OutputInterface implements Output {
    private Output out;
    private RacingCarGameRenderer renderer;

    OutputInterface(Output out, RacingCarGameRenderer renderer) {
        this.out = out;
        this.renderer = renderer;
    }

    @Override
    public void println(String str) {
        out.println(str);
    }

    public void printStage(Game game) {
        out.println(game.render(renderer) + "\n");
    }

    public void printWinners(List<String> winners) {
        out.println(renderer.renderWinners(winners));
    }

}
