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
package allbinary.game.midlet;

import allbinary.logic.basic.util.event.AllBinaryEventObject;
import allbinary.logic.basic.util.event.EventListenerInterface;
import allbinary.logic.basic.util.event.handler.BasicEventHandler;

public class GameMidletEventHandler extends BasicEventHandler
{
   private static final GameMidletEventHandler gameKeyEventHandler = 
      new GameMidletEventHandler();

   private GameMidletEventHandler()
   {
   }

   public static GameMidletEventHandler getInstance()
   {
      return GameMidletEventHandler.gameKeyEventHandler;
   }
   
   protected void process(AllBinaryEventObject eventObject,
           EventListenerInterface eventListenerInterface) throws Exception {

      ((GameMidletEventListener) eventListenerInterface).onGameEnd(eventObject);
   }   
}
