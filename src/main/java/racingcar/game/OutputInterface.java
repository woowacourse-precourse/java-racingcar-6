package racingcar.game;

import game.Game;
import game.Output;
import java.util.List;
import racingcar.game.renderer.RacingCarGameRenderer;
import racingcar.game.view.SimpleHeaderView;
import racingcar.game.view.SimpleTagView;
import racingcar.game.view.View;

public class OutputInterface implements Output {
    private Output out;
    private View gameStageView;
    private View gameWinnerView;

    public OutputInterface(Output out) {
        this.out = out;
        gameStageView = new SimpleHeaderView(out, "실행 결과");
        gameWinnerView = new SimpleTagView(out, "최종 우승자");
    }

    public void printStage(Game game) {
        gameStageView.render(game.render() );
    }

    public void printWinners(List<String> winners) {
        gameWinnerView.render(String.join(", ", winners));
    }

    @Override
    public void println(String str) {
        out.println(str);
    }

}
