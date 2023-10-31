package racingcar.interceptors;

public class CountFinalizeInterceptor implements Interceptor<Long, Long> {
    @Override
    public Long handling(Long targetObject) throws IllegalArgumentException {
        return targetObject;
    }
}
