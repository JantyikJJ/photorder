package com.nyomorultak.spring.api;

public class ApiResponse<T> {
    public T data;
    public boolean error;

    public ApiResponse(T data, boolean error) {
        this.data = data;
        this.error = error;
    }
    public ApiResponse() {

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
