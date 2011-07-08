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
package admin.taghelpers;

import java.util.HashMap;

import javax.servlet.jsp.PageContext;

import abcs.business.installer.Portion;
import abcs.logic.communication.log.LogFactory;
import abcs.logic.communication.log.LogUtil;
import allbinary.data.tables.user.commerce.inventory.item.InventoryEntityFactory;

public class InventoryHelper implements BasicTableInterface
{

    private final Portion portion;

    public InventoryHelper(HashMap hashMap, PageContext pageContext)
    {
        this.portion = new Portion(hashMap);
    }

    public String drop()
    {
        try
        {
            String success = InventoryEntityFactory.getInstance().getInventoryEntityInstance().dropTable();

            if (abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.SQLTAGS))
            {
                LogUtil.put(LogFactory.getInstance(success, this, "drop()"));
            }
            return success;
        } catch (Exception e)
        {
            String error = "Failed to drop inventory table";
            if (abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.SQLTAGSERROR))
            {
                LogUtil.put(LogFactory.getInstance(error, this, "drop()", e));
            }
            return error;
        }

    }

    public String create()
    {

        try
        {
            String success = InventoryEntityFactory.getInstance().getInventoryEntityInstance().createTable();

            if (abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.SQLTAGS))
            {
                LogUtil.put(LogFactory.getInstance(success, this, "create()"));
            }
            return success;
        } catch (Exception e)
        {
            String error = "Failed to create new inventory table";
            if (abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.SQLTAGSERROR))
            {
                LogUtil.put(LogFactory.getInstance(error, this, "create()", e));
            }
            return error;
        }
    }

    public String restore()
    {
        try
        {
            String success = "Restore Successful";

            String result = InventoryEntityFactory.getInstance().getInventoryEntityInstance().restoreTable(this.portion);

            if (abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.SQLTAGS))
            {
                LogUtil.put(LogFactory.getInstance(success, this, "restore()"));
            }
            return result;
        } catch (Exception e)
        {
            String error = "Failed to restore backup";

            if (abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.SQLTAGSERROR))
            {
                LogUtil.put(LogFactory.getInstance(error, this, "restore()", e));
            }
            return error;
        }
    }

    public String backup()
    {
        try
        {
            String success = "Backup Successful";

            String result = InventoryEntityFactory.getInstance().getInventoryEntityInstance().backupTable();

            if (abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.SQLTAGS))
            {
                LogUtil.put(LogFactory.getInstance(success, this, "backup()"));
            }
            return result;
        } catch (Exception e)
        {
            String error = "Failed to make backup";

            if (abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.SQLTAGSERROR))
            {
                LogUtil.put(LogFactory.getInstance(error, this, "backup()", e));
            }
            return error;
        }
    }
}
