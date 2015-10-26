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
package org.allbinary.content;

import javax.microedition.lcdui.Command;

import org.allbinary.data.resource.ResourceUtil;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import org.allbinary.android.AndroidInfoFactory;

public class NotificationUtil
{
    private static final NotificationUtil SINGLETON = new NotificationUtil();
    
    private NotificationManager notificationManager = (NotificationManager) 
        ResourceUtil.getInstance().getContext().getSystemService(Context.NOTIFICATION_SERVICE); 
    
    public static NotificationUtil getInstance()
    {
        return SINGLETON;
    }
    
    public void notify(Command command, String resource, String message)
    {
        Context context = ResourceUtil.getInstance().getContext();
        
        Intent intent = CommandUriAction.getInstance().getIntent(command);

        //Load a new activity Intent
        //Intent intent = new Intent(Intent.ACTION_MAIN);
        //intent.setClass(context, context.getClass());
        //intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        /*
            intent.putExtra( "data", "test data");
       */

        Integer integer = ResourceUtil.getInstance().getResourceId(resource);
        
        Notification notification = null;

        int SDK_VERSION = AndroidInfoFactory.getInstance().getVersion();

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        
        if(SDK_VERSION > 22)
        {
            //int icon, java.lang.CharSequence tickerText, long when
            notification = new Notification.Builder(context)
                    .setSmallIcon(integer.intValue())
                    .setTicker(message)
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle(command.getLabel())
                    .setContentText(message)
                    .setContentIntent(pendingIntent)
                    .build();
        }
        else
        {
            notification = new Notification(
                    integer.intValue(), message, System.currentTimeMillis());

            notification.setLatestEventInfo(
                    context, command.getLabel(), message, pendingIntent);
        }
        
        notificationManager.notify(command.hashCode(), notification);

        //context.startActivity(intent);
    }
}
