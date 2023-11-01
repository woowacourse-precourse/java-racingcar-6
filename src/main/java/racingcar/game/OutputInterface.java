package racingcar.game;

import static racingcar.game.TextResourceManager.GAME_STAGE_VIEW_HEADER;
import static racingcar.game.TextResourceManager.GAME_WINNER_VIEW_TAG;

import game.Game;
import game.Output;
import java.util.List;
import racingcar.game.view.SimpleHeaderView;
import racingcar.game.view.SimpleTagView;
import racingcar.game.view.View;

public class OutputInterface implements Output {
    private Output out;
    private View gameStageView;
    private View gameWinnerView;

    public OutputInterface(Output out,View gameStageView,View gameWinnerView) {
        this.out = out;
        this.gameStageView = gameStageView ;
        this.gameWinnerView = gameWinnerView;
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
