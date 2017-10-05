package com.buzzec.loggger;

import com.buzzec.loggger.exceptions.*;

public enum LogLevel{
    DEBUG(1), INFO(2), WARNING(3), ERROR(4), FATAL(5);
    
    private int level;
    
    LogLevel(int level){
        this.level = level;
    }
    
    public int get(){
        return level;
    }
    
    public static LogLevel getLevel(int x){
        switch(x){
            case 1:
                return DEBUG;
            case 2:
                return INFO;
            case 3:
                return WARNING;
            case 4:
                return ERROR;
            case 5:
                return FATAL;
            default:
                throw new InvalidLogLevel(x);
        }
    }
}
