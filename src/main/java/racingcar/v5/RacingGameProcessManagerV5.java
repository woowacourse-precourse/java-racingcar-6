package racingcar.v5;

import racingcar.v4.CreateCar;
import racingcar.v4.Forward;
import racingcar.v4.RacingGameResultReport;
import racingcar.v4.TryCount;

import java.util.List;
import java.util.Map;

public class RacingGameProcessManagerV5 {

    private final CreateCarV5 createCar;
    private final TryCountV5 tryCount;
    private final ForwardV5 forward;
    private final RacingGameResultReportV5 resultReport;

    public RacingGameProcessManagerV5(CreateCarV5 createCar, TryCountV5 tryCount, ForwardV5 forward, RacingGameResultReportV5 resultReport) {
        this.createCar = createCar;
        this.tryCount = tryCount;
        this.forward = forward;
        this.resultReport = resultReport;
    }

    public static void start() {
        try {
            CreateCarV5 createCar = new CreateCarV5();
            TryCountV5 tryCount = new TryCountV5();
            ForwardV5 forward = new ForwardV5();
            RacingGameResultReportV5 resultReport = new RacingGameResultReportV5();

            RacingGameProcessManagerV5 racingGameProcessManagerV5 = new RacingGameProcessManagerV5(createCar, tryCount, forward, resultReport);

            // 입력 받기
            String inputCarNames = racingGameProcessManagerV5.createCar.inputCarNames();
            List<String> trimmedCarNames = racingGameProcessManagerV5.createCar.validateCarNames(inputCarNames);
            int tryCountNumber = racingGameProcessManagerV5.tryCount.validateTryCount();

            // 경주 상태 초기화
            Map<String, Integer> racingStateMap = racingGameProcessManagerV5.createCar.racingStateMap(trimmedCarNames);

            // 경주 진행
            for (int i = 0; i < tryCountNumber; i++) {
                for (String carName : trimmedCarNames) {
                    racingGameProcessManagerV5.forward.updatePosition(racingStateMap, carName);
                }
            }

            // 결과 출력
            racingGameProcessManagerV5.resultReport.printResultTitle();
            racingGameProcessManagerV5.resultReport.printCarPositionWithName(racingStateMap);
            racingGameProcessManagerV5.resultReport.announceWinners(racingStateMap);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}

