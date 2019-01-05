package com.jobmanager.app.pattern.observer;

/**
 * Created by Kevin Tan 2019-01-03
 */
public interface Subject {
    void notifyObserver();
    void attach(Observer observer);
    void detach(Observer observer);
}
