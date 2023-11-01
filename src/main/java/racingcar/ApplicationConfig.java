package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.InputViewValidator;
import racingcar.view.OutputView;

public class ApplicationConfig {

    public RacingController racingController(){
        return new RacingController(racingService());
    }

    public RacingService racingService(){
        return new RacingService(inputView(),outputView());
    }

    public InputView inputView(){
        return new InputView(inputViewValidator());
    }

    public OutputView outputView(){
        return new OutputView();
    }

    public InputViewValidator inputViewValidator(){
        return new InputViewValidator();
    }
}
