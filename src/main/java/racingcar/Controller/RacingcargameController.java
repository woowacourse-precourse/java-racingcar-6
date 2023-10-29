package racingcar.Controller;

import racingcar.Exception.CarNameException;
import racingcar.Exception.TryCountNumberException;
import racingcar.Repository.CarRepository;
import racingcar.Service.GameFlowManagementService;
import racingcar.Util.StringToList;

public class RacingcargameController {
    private final GameFlowManagementService gameFlowManagementService;
    private final StringToList stringToList;
    private final CarNameException carNameException;
    private final TryCountNumberException tryCountNumberException;
    private final CarRepository carRepository;

    public RacingcargameController() {
        this.gameFlowManagementService = new GameFlowManagementService();
        this.stringToList = new StringToList();
        this.carNameException = new CarNameException();
        this.tryCountNumberException = new TryCountNumberException();
        this.carRepository = new CarRepository();
    }
}
