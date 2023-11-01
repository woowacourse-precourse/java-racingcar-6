package racingcar.race.decorator;

import racingcar.race.Handler;

public abstract class DecoratorHandler<T,R> implements Handler<T, R> {
    protected final Handler<T,R> handler;

    public DecoratorHandler(Handler<T,R> handler) {
        this.handler = handler;
    }
}
