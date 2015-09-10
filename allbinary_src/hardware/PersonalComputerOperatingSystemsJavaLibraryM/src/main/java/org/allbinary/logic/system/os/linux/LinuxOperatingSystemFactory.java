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
package org.allbinary.logic.system.os.linux;

import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.communication.log.config.type.LogConfigType;
import org.allbinary.logic.communication.log.config.type.LogConfigTypes;
import org.allbinary.logic.system.os.NoOperatingSystem;
import org.allbinary.logic.system.os.OperatingSystemInterface;
import org.allbinary.logic.system.os.OperatingSystems;
import org.allbinary.logic.system.os.SystemProperties;

public class LinuxOperatingSystemFactory
{
    private static final LinuxOperatingSystemFactory instance = new LinuxOperatingSystemFactory();
    
    public static LinuxOperatingSystemFactory getInstance()
    {
        return instance;
    }

    private LinuxOperatingSystemFactory()
    {
    }

    public OperatingSystemInterface getOperatingSystemInstance()
    {
        try
        {
            final OperatingSystems operatingSystems = OperatingSystems.getInstance();
            final String osName = SystemProperties.getName();
            OperatingSystemInterface operatingSystemInterface;
            
            if(osName.compareTo(operatingSystems.LINUX)==0)
            {
                operatingSystemInterface =
                    (OperatingSystemInterface) new Linux();
            }
            else
            {
                if(operatingSystems.isUnknownSpecificOSAllowed())
                {
                    operatingSystemInterface =
                        (OperatingSystemInterface) new Linux();
                }
                else
                {
                    throw new Exception("Specific Linux OS Not Supported: " + osName);
                }
            }
            
            return operatingSystemInterface;
        }
        catch(Exception e)
        {
            if(LogConfigTypes.LOGGING.contains(LogConfigType.FACTORYERROR))
            {
                String error = "Failed to get instance";
                LogUtil.put(LogFactory.getInstance(error, this, "getOperatingSystemInstance()", e));
            }
            return new NoOperatingSystem();
        }
    }
}
