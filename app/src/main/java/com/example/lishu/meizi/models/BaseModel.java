package com.example.lishu.meizi.models;

import java.util.List;

/**
 * Created by lishu on 2018/10/7.
 */

public class BaseModel<T> {
    public String error;
    public T results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
