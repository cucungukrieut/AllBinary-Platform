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
package allbinary.game.input.event;

import org.allbinary.util.BasicArrayList;

import abcs.logic.basic.string.CommonStrings;
import abcs.logic.communication.log.LogFactory;
import abcs.logic.communication.log.LogUtil;
import allbinary.game.input.PlayerGameInput;
import allbinary.logic.basic.util.event.AllBinaryEventObject;
import allbinary.logic.basic.util.event.EventListenerInterface;
import allbinary.logic.basic.util.event.handler.BasicEventHandler;

public class UpGameKeyEventHandlerBase extends BasicEventHandler
{
   private final BasicArrayList list = new BasicArrayList();
   
   protected UpGameKeyEventHandlerBase()
   {
   }
   
   public void addListener(PlayerGameInput playerGameInput)
   {
       if(!list.contains(playerGameInput))
       {
           list.add(playerGameInput);
       }
   }

   public void removeAllListeners()
   {
       this.list.clear();
       super.removeAllListeners();
   }

    public void removeListenerSingleThreaded(
            EventListenerInterface eventListenerInterface)
    {
        this.list.remove(eventListenerInterface);
        super.removeListenerSingleThreaded(eventListenerInterface);
    }
    
   public synchronized void removeListener(EventListenerInterface eventListenerInterface)
   {
       this.list.remove(eventListenerInterface);
       super.removeListener(eventListenerInterface);
   }

   public void fireEvent(AllBinaryEventObject eventObject) throws Exception
   {        
       for (int index = this.list.size(); --index >= 0;)
       {
           try
           {
        	 //Add deviceId
               PlayerGameInput playerGameInput = (PlayerGameInput) this.list.objectArray[index];
               playerGameInput.onUpGameKeyEvent((GameKeyEvent) eventObject);
           }
           catch (Exception e)
           {
               LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, "fireEvent", e));
           }
       }

       super.fireEvent(eventObject);
   }
   
   protected void process(AllBinaryEventObject eventObject,
           EventListenerInterface eventListenerInterface) throws Exception {

      ((UpGameKeyEventListenerInterface) eventListenerInterface).onUpGameKeyEvent(
              (GameKeyEvent) eventObject);
   }
   

    private static final String TOTAL_LISTENERS = " Total PlayerGameInput Listeners: ";
    private static final String LISTENER_LABEL = " PlayerGameInput Listener: ";
    
    public String toString()
    {
        final StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(super.toString());
        stringBuffer.append(TOTAL_LISTENERS);
        stringBuffer.append(this.list.size());

        for (int index = 0; index < this.list.size(); index++)
        {
            try
            {
                EventListenerInterface eventListenerInterface = (EventListenerInterface) // enumeration.nextElement();
                    this.list.get(index);

                stringBuffer.append(LISTENER_LABEL);
                stringBuffer.append(eventListenerInterface);
            }
            catch (Exception e)
            {
                LogUtil.put(LogFactory.getInstance(CommonStrings.getInstance().EXCEPTION, this, "toString", e));
            }
        }
        return stringBuffer.toString();
    }   
}
