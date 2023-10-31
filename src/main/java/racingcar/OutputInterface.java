package racingcar;

import java.util.List;

public class OutputInterface {
    private Output out;
    private RacingCarGameRenderer renderer;

    OutputInterface(Output out, RacingCarGameRenderer renderer) {
        this.out = out;
        this.renderer = renderer;
    }

    public void println(String str) {
        out.println(str);
    }

    public void printStage(RacingCarGame game) {
        out.println(game.render(renderer) + "\n");
    }

    public void printWinners(List<String> winners) {
        out.println(renderer.renderWinners(winners));
    }

}
