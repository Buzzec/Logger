package com.buzzec.loggger.exceptions;

public class InvalidLogLevel extends RuntimeException{
    private int level;
    
    public InvalidLogLevel(int level){
        this.level = level;
    }
    
    @Override
    public String toString(){
        return "Invalid Log Level: " + level;
    }
}
