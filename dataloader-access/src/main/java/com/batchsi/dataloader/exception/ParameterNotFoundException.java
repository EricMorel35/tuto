package com.batchsi.dataloader.exception;

public class ParameterNotFoundException extends Exception {

    /** Serial Version UID. */
    private static final long serialVersionUID = 1L;

    public ParameterNotFoundException(String message) {
        super(message);
    }

    public ParameterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterNotFoundException(Throwable cause) {
        super(cause);
    }

}
