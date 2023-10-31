package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.repository.MemoryRacingcarRepository;
import racingcar.service.RacingcarService;
import racingcar.service.RacingcarServiceImpl;
import racingcar.view.ResultView;

public class AppConfig {
    // 의존관계 주입을 위해 사용
    // 객체지향의 5원칙 중 DIP(Dependency Injection Principle) 만족을 위해!
    // >> DIP : 상위 모듈은 하위 모듈에 의존해서는 안 되고 추상화에 의존해야 된다는 내용

    private static MemoryRacingcarRepository racingcarRepository() {
        return new MemoryRacingcarRepository();
    }

    public RacingcarService racingcarService() {
        return new RacingcarServiceImpl(racingcarRepository());
    }

    private static ResultView resultView() {
        return new ResultView();
    }

    public RacingcarController racingcarController() {
        return new RacingcarController(racingcarService(), resultView());
    }

}
