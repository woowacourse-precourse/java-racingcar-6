package racingcar.initializer;

import racingcar.domain.system.reader.CarNameReader;
import racingcar.domain.system.reader.ConsoleCarNameReader;
import racingcar.domain.system.reader.ConsoleTryCountReader;
import racingcar.domain.system.reader.TryCountReader;
import racingcar.domain.system.viewer.ConsoleViewer;
import racingcar.domain.system.viewer.Viewer;

public class ConsoleGameFactory implements GameFactory {

    @Override
    public Viewer getViewer() {
        return new ConsoleViewer();
    }

    @Override
    public CarNameReader getCarNameReader() {
        return new ConsoleCarNameReader();
    }

    @Override
    public TryCountReader getTryCountReader() {
        return new ConsoleTryCountReader();
    }
}
