package racingcar;

import racingcar.common.Validator;
import racingcar.common.Viewer;
import racingcar.engine.RacingCarGame;
import racingcar.engine.manager.Referee;
import racingcar.engine.mapper.RacingCarMapper;
import racingcar.view.RacingCarViewer;
import racingcar.view.RacingCarViewerMapper;
import racingcar.view.dto.RacingCarUserInputDto;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        RacingCarViewerMapper racingCarViewerMapper = new RacingCarViewerMapper();
        Viewer<RacingCarUserInputDto> viewer = new RacingCarViewer(validator, racingCarViewerMapper);
        RacingCarMapper racingCarMapper = new RacingCarMapper();
        Referee referee = new Referee();
        RacingCarGame game = new RacingCarGame(viewer, referee, racingCarMapper);

        game.start();
    }
}
