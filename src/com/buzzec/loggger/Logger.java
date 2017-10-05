package com.buzzec.loggger;

import java.io.*;
import java.time.*;

public class Logger{
    private String logFileName;
    private LogLevel logLevel;
    
    public Logger(LogLevel logLevel){
        this("logs", logLevel);
    }
    
    public Logger(String logFileFolder, LogLevel logLevel){
        this(logFileFolder, LocalDateTime.now().toString().replace(':', '.') + ".txt", logLevel);
    }
    
    public Logger(String logFileFolder, String name, LogLevel logLevel){
        this.logLevel = logLevel;
        setLogFileName(logFileFolder + "\\" + name);
        new File(logFileFolder).mkdirs();
    }
    
    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }
    
    public void log(String string, LogLevel level){
        if(level.get() >= logLevel.get()){
            BufferedWriter bw = null;
            FileWriter fw = null;
            try{
                fw = new FileWriter(logFileName, true);
                bw = new BufferedWriter(fw);
                bw.write("[" + LocalDateTime.now() + "] [" + level + "] " + string + "\n");
            }
            catch(IOException e){
                e.printStackTrace();
            }
            finally{
                try{
                    if(bw != null){
                        bw.close();
                    }
                    if(fw != null){
                        fw.close();
                    }
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void log(Object input, LogLevel level){
        log(input.toString(), level);
    }
}
