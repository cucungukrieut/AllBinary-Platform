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
package allbinary.data.tables.user.commerce.inventory.item.options;

import abcs.logic.communication.log.LogFactory;
import abcs.logic.communication.log.LogUtil;

public class BasicOptionItemsEntityFactory
{
    private static final BasicOptionItemsEntityFactory instance =
            new BasicOptionItemsEntityFactory();

    /**
     * @return the instance
     */
    public static BasicOptionItemsEntityFactory getInstance() {
        return instance;
    }

   //private static final String CLASSNAME = "allbinary.data.tables.InventoryEntity";
   
   private BasicOptionItemsEntityFactory()
   {
   }
   
   public BasicOptionItemsEntity getBasicOptionItemsEntityInstance() //throws LicensingException
   {
      try
      {
         //Object object = AbeFactory.getInstance(CLASSNAME);
         //return (InventoryEntityInterface) InterfaceCastProxy.newInstance(object);
         return new allbinary.data.tables.user.commerce.inventory.item.options.BasicOptionItemsEntity();
      }
      /*
      catch(LicensingException e)
      {
         String error = "Failed to get instance";
         if(abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.ENTITYFACTORYERROR))
         {
            LogUtil.put(error,"InventoryEntityFactory","getInstance()",e);
         }
         throw e;
      }
      */
      catch(Exception e)
      {
         String error = "Failed to get instance";
         if(abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.ENTITYFACTORYERROR))
         {
            LogUtil.put(LogFactory.getInstance(error,"InventoryEntityFactory","getInstance",e));
         }
         return null;
      }
   }
   
}
