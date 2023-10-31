package racingcar.utils.output;

import racingcar.domain.User;

public class RacingOutputManager implements OutputManager{
    private final User user;

    private RacingOutputManager(User user) {
        this.user = user;
    }

    public static RacingOutputManager of(User user) {
        return new RacingOutputManager(user);
    }

    @Override
    public void output() {
        System.out.println(user.getOutputMessage());
    }
}
