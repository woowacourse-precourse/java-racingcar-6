package racingcar.interceptors;

public class CountInitInterceptor implements Interceptor<String, Long> {
    @Override
    public Long handling(String targetObject) throws IllegalArgumentException {
        long result = 0L;
        try {
            result = Long.parseLong(targetObject);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return result;
    }
}
