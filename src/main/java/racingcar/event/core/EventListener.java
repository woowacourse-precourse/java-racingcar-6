package racingcar.event.core;

import java.util.function.Consumer;
import java.util.function.Function;
import racingcar.data.RacingCarRepository;

public record EventListener(RacingCarRepository racingCarRepository) {


    /**
     * 결과만 있는 이벤트
     *
     * @param eventConstructor
     * @param <R>
     * @return
     */
    public <R> R listenWithResult(Function<RacingCarRepository, ReturnEvent<R>> eventConstructor) {
        return eventConstructor.apply(racingCarRepository).execute();
    }

    /**
     * 파라미터만 있는 이벤트
     *
     * @param eventConstructor
     * @param <T>
     * @return
     */
    public <T> Consumer<T> listenWithParameter(Function<RacingCarRepository, ParameterEvent<T>> eventConstructor) {
        return (input) -> eventConstructor.apply(racingCarRepository).execute(input);

    }

    /**
     * 파라미터와 결과 모두 있는 이벤트
     *
     * @param eventConstructor
     * @param <T>
     * @param <R>
     * @return
     */
    public <T, R> Function<T, R> listenWithParameterAndResult(Function<RacingCarRepository, ParameterAndReturnEvent<T, R>> eventConstructor) {
        return (input) -> eventConstructor.apply(racingCarRepository).execute(input);
    }


    public interface ParameterEvent<T> {
        void execute(T input);
    }

    public interface ReturnEvent<R> {
        R execute();
    }

    public interface ParameterAndReturnEvent<T, R> {
        R execute(T input);
    }
}
