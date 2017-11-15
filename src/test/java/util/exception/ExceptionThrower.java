package util.exception;

@FunctionalInterface
public interface ExceptionThrower {
    void throwException() throws Throwable;
}
