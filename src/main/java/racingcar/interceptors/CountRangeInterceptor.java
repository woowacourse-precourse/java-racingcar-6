package racingcar.interceptors;

public class CountRangeInterceptor implements Interceptor<Long, Long> {
    @Override
    public Long handling(Long targetObject) throws IllegalArgumentException {
        if (targetObject <= 0) {
            throw new IllegalArgumentException();
        }

        return targetObject;
    }
}
