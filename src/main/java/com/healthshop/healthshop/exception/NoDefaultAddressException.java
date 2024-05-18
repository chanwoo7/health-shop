package com.healthshop.healthshop.exception;

public class NoDefaultAddressException extends RuntimeException {
    public NoDefaultAddressException() {
        super();
    }

    public NoDefaultAddressException(String message) {
        super(message);
    }

    public NoDefaultAddressException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDefaultAddressException(Throwable cause) {
        super(cause);
    }
}
