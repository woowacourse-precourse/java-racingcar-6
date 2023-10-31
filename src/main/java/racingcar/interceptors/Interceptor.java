package racingcar.interceptors;

public interface Interceptor<I, O> {
    O handling(I targetObject) throws IllegalArgumentException;
}
