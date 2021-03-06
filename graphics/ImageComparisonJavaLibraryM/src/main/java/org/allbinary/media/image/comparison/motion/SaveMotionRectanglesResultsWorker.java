/*
* AllBinary Open License Version 1
* Copyright (c) 2011 AllBinary
* 
* By agreeing to this license you and any business entity you represent are
* legally bound to the AllBinary Open License Version 1 legal agreement.
* 
* You may obtain the AllBinary Open License Version 1 legal agreement from
* AllBinary or the root directory of AllBinary's AllBinary Platform repository.
* 
* Created By: Travis Berthelot
* 
*/
package org.allbinary.media.image.comparison.motion;

import java.util.Vector;

import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.basic.util.event.AllBinaryEventObject;
import org.allbinary.logic.communication.log.LogFactory;

import org.allbinary.time.TimeDelayHelper;

public class SaveMotionRectanglesResultsWorker
    implements MotionRectanglesResultsListener
{
    private boolean running;
    
    private Vector motionRectanglesVector;
    
    public SaveMotionRectanglesResultsWorker()
    {
        this.motionRectanglesVector = new Vector();
    }

    public Vector getMotionRectanglesVector()
    {
        return this.motionRectanglesVector;
    }
    
    public void onMotionRectanglesImageComparisonResultsEvent(
        MotionRectanglesResultsEvent motionRectanglesResultsEvent)
    {
        this.getMotionRectanglesVector().add(
            motionRectanglesResultsEvent);
        
        this.run();
    }
    
    public void onEvent(AllBinaryEventObject allBinaryEventObject)
    {
        this.onMotionRectanglesImageComparisonResultsEvent(
            (MotionRectanglesResultsEvent)
            allBinaryEventObject);
    }
    
    public synchronized boolean isRunning()
    {
        return running;
    }
    
    public synchronized void setRunning(boolean running)
    {
        this.running = running;
    }
    
    public void run()
    {
        try
        {
            LogUtil.put(LogFactory.getInstance("Start", this, "run"));
            
            this.setRunning(true);
            
            TimeDelayHelper timeHelper = new TimeDelayHelper(1000);
            
            timeHelper.setStartTime();

            MotionRectanglesResultsEvent motionRectanglesResultsEvent = 
                (MotionRectanglesResultsEvent) 
                this.getMotionRectanglesVector().get(0);
            
            MotionRectangles motionRectangles = 
                motionRectanglesResultsEvent.getMotionRectangles();

            new MotionRectanglesImageInputOutput().save(motionRectangles, 
                motionRectanglesResultsEvent.getFrame());
            
            this.getMotionRectanglesVector().remove(motionRectangles);
            
            LogUtil.put(LogFactory.getInstance(
                "Time Elapsed: " + timeHelper.getElapsed(), this, "run"));
            
            LogUtil.put(LogFactory.getInstance("End", this, "run"));
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance("Exception", this, "run", e));
        }
    }
    
}
