package racingcar;

import racingcar.router.RacingGameRouter;

public class Application {
    public static void main(final String[] args) {
        final RacingGameRouter racingGameRouter = new RacingGameRouter();
        racingGameRouter.invoke();
    }
}
