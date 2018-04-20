
package javaapplication;

public class Session{
    
    public String name;
    public int startTime;
    public int finishTime;
    public int flag ; 
    
    public Session(String name, int startTime, int finishTime)
    {
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
        int flag =0 ; //0 means that Session is not taken by any room
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getStartTime()
    {
        return startTime;
    }
    
    public int getFinishTime()
    {
        return finishTime;
    }
public int getFlag()
    {
        return flag;
    }
}

