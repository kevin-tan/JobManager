package com.jobmanager.app.manager.classes;

/**
 * Enum holding all the names of every job possible in the application.
 */
public enum Jobs {

    /**
     * Add all classes here.
     */
    TEST_JOB("TestJob");

    private String className;

    Jobs(String className){
        this.className = className;
    }

    public String getClassName(){
        return className;
    }
}
