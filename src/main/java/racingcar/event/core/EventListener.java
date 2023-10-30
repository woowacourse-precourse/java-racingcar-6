package racingcar.event.core;

import java.util.function.Consumer;
import java.util.function.Function;
import racingcar.data.DataStore;

public record EventListener(DataStore dataStore) {

    /**
     * 결과와 파라미터가 없는 이벤트
     *
     * @param eventConstructor
     */
    public void listen(Function<DataStore, Event> eventConstructor) {
        eventConstructor.apply(dataStore).execute();
    }


    /**
     * 결과만 있는 이벤트
     *
     * @param eventConstructor
     * @param <R>
     * @return
     */
    public <R> R listenWithResult(Function<DataStore, ReturnEvent<R>> eventConstructor) {
        return eventConstructor.apply(dataStore).execute();
    }

    /**
     * 파라미터만 있는 이벤트
     *
     * @param eventConstructor
     * @param <T>
     * @return
     */
    public <T> Consumer<T> listenWithParameter(Function<DataStore, ParameterEvent<T>> eventConstructor) {
        return (input) -> eventConstructor.apply(dataStore).execute(input);

    }

    /**
     * 파라미터와 결과 모두 있는 이벤트
     *
     * @param eventConstructor
     * @param <T>
     * @param <R>
     * @return
     */
    public <T, R> Function<T, R> listenWithParameterAndResult(Function<DataStore, ParameterAndReturnEvent<T, R>> eventConstructor) {
        return (input) -> eventConstructor.apply(dataStore).execute(input);
    }


    public interface Event {
        void execute();
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
