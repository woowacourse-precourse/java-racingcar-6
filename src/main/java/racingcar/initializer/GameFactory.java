package racingcar.initializer;

import racingcar.domain.system.reader.CarNameReader;
import racingcar.domain.system.reader.TryCountReader;
import racingcar.domain.system.viewer.Viewer;

public interface GameFactory {

    Viewer getViewer();

    CarNameReader getCarNameReader();

    TryCountReader getTryCountReader();
}
