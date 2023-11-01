package racingcar.race.decorator;

import racingcar.race.Handler;
import racingcar.vo.CarCollection;
import racingcar.vo.RacingInfo;

public class RacingPrintDecoratorHandler extends DecoratorHandler<RacingInfo, RacingInfo> {

    private static final String RACING_PERIOD_MESSAGE = "실행 결과";
    private static final String RACING_RESULT_MESSAGE = "최종 우승자 : %s";

    public RacingPrintDecoratorHandler(Handler<RacingInfo, RacingInfo> handler) {
        super(handler);
    }

    @Override
    public RacingInfo execute(RacingInfo racingInfo) {
        System.out.println(RACING_PERIOD_MESSAGE);
        final RacingInfo result = handler.execute(racingInfo);
        final CarCollection carCollection = result.getCarCollection();
        System.out.print(String.format(RACING_RESULT_MESSAGE, carCollection.getCarName()));
        return result;
    }
}
