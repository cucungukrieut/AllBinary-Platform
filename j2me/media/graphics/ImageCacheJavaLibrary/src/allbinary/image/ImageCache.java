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
package allbinary.image;

import java.io.InputStream;
import java.util.Hashtable;

import javax.microedition.lcdui.Image;

import org.allbinary.util.BasicArrayList;

import abcs.logic.basic.string.CommonSeps;
import abcs.logic.basic.string.CommonStrings;
import abcs.logic.communication.log.LogFactory;
import abcs.logic.communication.log.LogUtil;
import allbinary.data.resource.ResourceUtil;
import allbinary.system.Memory;

public class ImageCache
{
    private final Hashtable hashtable = new Hashtable();

    private final int[] widths = new int[50];
    private final int[] heights = new int[50];
    
    private final BasicArrayList[] listOfList = 
        new BasicArrayList[50];
    private final BasicArrayList[] availableListOfList = 
        new BasicArrayList[50];

    private int volume = 0;
    private int nextIndex = 0;

    protected ImageCache()
    // CacheableInterfaceFactoryInterface cacheableInterfaceFactoryInterface)
    {
        // super(cacheableInterfaceFactoryInterface);

        for (int index = listOfList.length - 1; index >= 0; index--)
        {
            listOfList[index] = new BasicArrayList();
        }

        for (int index = availableListOfList.length - 1; index >= 0; index--)
        {
            availableListOfList[index] = new BasicArrayList();
        }
    }
    
    public void releaseAll()
    {
        for (int index = listOfList.length - 1; index >= 0; index--)
        {
            availableListOfList[index].clear();
            availableListOfList[index].addAll(listOfList[index]);            
        }
        LogUtil.put(LogFactory.getInstance("ImageCache: " + this.toString(), this, "releaseAll"));
    }

    private int getIndex(int width, int height)
    {
        int foundIndex = -1;
        
        int size = widths.length;
        
        for (int index = 0; index < size; index++)
        {
            if (widths[index] == width && heights[index] == height)
            {
                foundIndex = index;
                return foundIndex;
            }
        }
        
        return foundIndex;
    }
    
    private Image getFromAvailable(int foundIndex, int width, int height)
    {
        if (foundIndex != -1)
        {
            if (availableListOfList[foundIndex].size() > 0)
            {
                //.log("Returning Image From Cache");
                BasicArrayList list = availableListOfList[foundIndex];
                return (Image) list.remove(list.size() - 1);
            }
        }
        return null;
    }
    
    public Image get(Object object, int width, int height)
    throws Exception
    {
        return this.get(object.getClass().getName(), width, height);
    }
    
    public Image get(String caller, int width, int height)
    throws Exception
    {        
        int foundIndex = this.getIndex(width, height);
        Image image = this.getFromAvailable(foundIndex, width, height);

        if (image == null)
        {
            volume += width * height;
            if (volume > 32000)
            {
                //LogUtil.put(LogFactory.getInstance("Image for: " + caller, this, CommonStrings.getInstance().GET));
                System.gc();
                //System.gc();
                volume = 0;
                //LogUtil.put(LogFactory.getInstance(Memory.getInfo(), this, CommonStrings.getInstance().GET));
            }

            image = this.createImage(caller, width, height);

            if(foundIndex == -1)
            {
                foundIndex = nextIndex;
                
                widths[nextIndex] = width;
                heights[nextIndex] = height;

                nextIndex++;
            }

            listOfList[foundIndex].add(image);
            
        }

        return image;
    }
    
    public Image get(Object key) throws Exception
    {
        Image image = (Image) getHashtable().get(key);

        if (image == null)
        {
            InputStream inputStream = 
                ResourceUtil.getInstance().getResourceAsStream((String) key);
            try
            {
                LogUtil.put(LogFactory.getInstance(Memory.getInfo(), this, CommonStrings.getInstance().GET));
                image = this.createImage(key, inputStream);
            }
            catch(Exception e)
            {
                LogUtil.put(LogFactory.getInstance("Exception: Trying Again After GC", this, CommonStrings.getInstance().GET, e));
                
                LogUtil.put(LogFactory.getInstance("InputStream: " + inputStream, this, CommonStrings.getInstance().GET));
                System.gc();
                System.gc();
                LogUtil.put(LogFactory.getInstance(Memory.getInfo(), this, CommonStrings.getInstance().GET));
                Thread.sleep(100);
                image = this.createImage(key, inputStream);
            }
            inputStream.close();
            getHashtable().put(key, image);
        }

        return image;
    }

    protected Image createImage(String caller, int width, int height)
    throws Exception
    {
        return Image.createImage(width, height);
    }
    
    protected Image createImage(Object key, InputStream inputStream)
    throws Exception
    {
        return Image.createImage(inputStream);
    }
    
    public String toString()
    {   
        StringBuilder stringBuffer = new StringBuilder(); 
        for (int index = this.nextIndex - 1; index >= 0; index--)
        {
            int width = widths[index];
            int height = heights[index];

            int total = listOfList[index].size();
            
            int totalAvailable = availableListOfList[index].size();

            stringBuffer.append(" w: ");
            stringBuffer.append(width);
            stringBuffer.append(" h: ");
            stringBuffer.append(height);
            stringBuffer.append(CommonSeps.getInstance().SPACE);
            stringBuffer.append(CommonStrings.getInstance().TOTAL_LABEL);
            stringBuffer.append(total);
            stringBuffer.append(" available: ");
            stringBuffer.append(totalAvailable);
        }
        return stringBuffer.toString();
    }

    public Hashtable getHashtable()
    {
        return hashtable;
    }

}