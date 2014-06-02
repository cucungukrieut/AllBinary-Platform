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
package allbinary.input.motion.button;

import abcs.logic.system.os.OperatingSystemFactory;
import allbinary.animation.NullAnimationFactory;
import org.allbinary.game.resource.ResourceLoadingLevelFactory;
import org.allbinary.graphics.opengles.OpenGLFeatureFactory;

import allbinary.animation.image.sprite.OneRowSpriteIndexedAnimationFactory;
import allbinary.animation.resource.BaseResourceAnimationInterfaceFactoryInterfaceFactory;
import allbinary.game.configuration.feature.Features;
import allbinary.graphics.canvas.transition.progress.ProgressCanvas;
import allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory;
import allbinary.image.ImageCache;
import allbinary.image.ImageCacheFactory;
import javax.microedition.lcdui.Image;
import org.allbinary.media.image.ImageCompleteUtil;

public class TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory 
    extends BaseResourceAnimationInterfaceFactoryInterfaceFactory
{
    public TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory()
    {
        super("TouchButton Animations");
    }

    public TouchButtonResourceAnimationInterfaceFactoryInterfaceFactory(String name)
    {
        super(name);
    }
    
    public void init(int level) throws Exception
    {        
        this.init(ImageCacheFactory.getInstance(), level);
    }

    protected void init(ImageCache imageCache, int level) 
        throws Exception
    {
        if(this.isInitialized())
        {
            return;
        }
        
    // public static int add(
    // BaseResourceAnimationInterfaceFactoryInterfaceFactory
    // baseResourceAnimationInterfaceFactoryInterfaceFactory, int portion)
    // throws Exception
        final int portion = 140;

        // final String loadingString =
        // baseResourceAnimationInterfaceFactoryInterfaceFactory.toString() +
        // " Loading: ";
        final String loadingString = this.toString() + " Loading: ";

        int index = 0;

        ProgressCanvas progressCanvas = 
            ProgressCanvasFactory.getInstance();
        
        progressCanvas.addPortion(portion, loadingString, index++);
  
        TouchButtonResource touchButtonBlankResource = TouchButtonBlankResource.getInstance();
        TouchButtonResource touchButtonGenericActionResource = TouchButtonGenericActionResource.getInstance();
        TouchButtonResource touchButtonStartResource = TouchButtonStartResource.getInstance();
        TouchButtonResource touchButtonUpResource = TouchButtonUpResource.getInstance();
        TouchButtonResource touchButtonDownResource = TouchButtonDownResource.getInstance();
        TouchButtonResource touchButtonTurnLeftResource = TouchButtonTurnLeftResource.getInstance();
        TouchButtonResource touchButtonTurnRightResource = TouchButtonTurnRightResource.getInstance();
        TouchButtonResource touchButtonStrafeLeftResource = TouchButtonStrafeLeftResource.getInstance();
        TouchButtonResource touchButtonStrafeRightResource = TouchButtonStrafeRightResource.getInstance();
                                        
        Image touchButtonBlankResourceImage = imageCache.get(touchButtonBlankResource.RESOURCE);
        Image touchButtonGenericActionResourceImage = imageCache.get(touchButtonGenericActionResource.RESOURCE);
        Image touchButtonStartResourceImage = imageCache.get(touchButtonStartResource.RESOURCE);
        Image touchButtonUpResourceImage = imageCache.get(touchButtonUpResource.RESOURCE);
        Image touchButtonDownResourceImage = imageCache.get(touchButtonDownResource.RESOURCE);
        Image touchButtonTurnLeftResourceImage = imageCache.get(touchButtonTurnLeftResource.RESOURCE);
        Image touchButtonTurnRightResourceImage = imageCache.get(touchButtonTurnRightResource.RESOURCE);
        Image touchButtonStrafeLeftResourceImage = imageCache.get(touchButtonStrafeLeftResource.RESOURCE);
        Image touchButtonStrafeRightResourceImage = imageCache.get(touchButtonStrafeRightResource.RESOURCE);
        
        if(OperatingSystemFactory.getInstance().getOperatingSystemInstance().isOverScan())
        {
            imageCache.get(TouchButtonStartResource.getInstance().HINT);
        }

        progressCanvas.addPortion(portion, loadingString, index++);

        ImageCompleteUtil imageCompleteUtil = ImageCompleteUtil.getInstance();
        
        progressCanvas.addPortion(portion, loadingString, index++);

        imageCompleteUtil.waitFor(touchButtonBlankResourceImage, touchButtonBlankResource.RESOURCE);
        
        this.add(TouchButtonBlankResource.getInstance().RESOURCE, 
                new OneRowSpriteIndexedAnimationFactory(
                touchButtonBlankResourceImage));

        this.add(TouchButtonBlankResource.getInstance().HINT, 
                NullAnimationFactory.getFactoryInstance());

        progressCanvas.addPortion(portion, loadingString, index++);

        imageCompleteUtil.waitFor(touchButtonGenericActionResourceImage, touchButtonGenericActionResource.RESOURCE);
        
        this.add(TouchButtonGenericActionResource.getInstance().RESOURCE,
                new OneRowSpriteIndexedAnimationFactory(
                touchButtonGenericActionResourceImage));

        this.add(TouchButtonGenericActionResource.getInstance().HINT, 
                NullAnimationFactory.getFactoryInstance());
        
        progressCanvas.addPortion(portion, loadingString, index++);

        imageCompleteUtil.waitFor(touchButtonStartResourceImage, touchButtonStartResource.RESOURCE);
        
        this.add(TouchButtonStartResource.getInstance().RESOURCE,
                new OneRowSpriteIndexedAnimationFactory(
                touchButtonStartResourceImage));
        
        progressCanvas.addPortion(portion, loadingString, index++);

        imageCompleteUtil.waitFor(touchButtonUpResourceImage, touchButtonUpResource.RESOURCE);
        
        this.add(TouchButtonUpResource.getInstance().RESOURCE, 
                new OneRowSpriteIndexedAnimationFactory(
                touchButtonUpResourceImage));

        this.add(TouchButtonUpResource.getInstance().HINT, 
                NullAnimationFactory.getFactoryInstance());
        
        progressCanvas.addPortion(portion, loadingString, index++);

        imageCompleteUtil.waitFor(touchButtonDownResourceImage, touchButtonDownResource.RESOURCE);

        this.add(TouchButtonDownResource.getInstance().RESOURCE, 
                new OneRowSpriteIndexedAnimationFactory(
                touchButtonDownResourceImage));

        this.add(TouchButtonDownResource.getInstance().HINT, 
                NullAnimationFactory.getFactoryInstance());
        
        progressCanvas.addPortion(portion, loadingString, index++);

        imageCompleteUtil.waitFor(touchButtonTurnLeftResourceImage, touchButtonTurnLeftResource.RESOURCE);

        this.add(TouchButtonTurnLeftResource.getInstance().RESOURCE, 
                new OneRowSpriteIndexedAnimationFactory(
                touchButtonTurnLeftResourceImage));

        this.add(TouchButtonTurnLeftResource.getInstance().HINT, 
                NullAnimationFactory.getFactoryInstance());
        
        progressCanvas.addPortion(portion, loadingString, index++);

        imageCompleteUtil.waitFor(touchButtonTurnRightResourceImage, touchButtonTurnRightResource.RESOURCE);

        this.add(TouchButtonTurnRightResource.getInstance().RESOURCE, 
                new OneRowSpriteIndexedAnimationFactory(
                touchButtonTurnRightResourceImage));

        this.add(TouchButtonTurnRightResource.getInstance().HINT, 
                NullAnimationFactory.getFactoryInstance());
        
        progressCanvas.addPortion(portion, loadingString, index++);

        imageCompleteUtil.waitFor(touchButtonStrafeLeftResourceImage, touchButtonStrafeLeftResource.RESOURCE);
        
        this.add(TouchButtonStrafeLeftResource.getInstance().RESOURCE, 
                new OneRowSpriteIndexedAnimationFactory(
                touchButtonStrafeLeftResourceImage));

        this.add(TouchButtonStrafeLeftResource.getInstance().HINT, 
                NullAnimationFactory.getFactoryInstance());
        
        progressCanvas.addPortion(portion, loadingString, index++);

        imageCompleteUtil.waitFor(touchButtonStrafeRightResourceImage, touchButtonStrafeRightResource.RESOURCE);

        this.add(TouchButtonStrafeRightResource.getInstance().RESOURCE, 
                new OneRowSpriteIndexedAnimationFactory(
                touchButtonStrafeRightResourceImage));

        this.add(TouchButtonStrafeRightResource.getInstance().HINT, 
                NullAnimationFactory.getFactoryInstance());
        
        if(OperatingSystemFactory.getInstance().getOperatingSystemInstance().isOverScan())
        {
            Image touchButtonStartHintResource = imageCache.get(TouchButtonStartResource.getInstance().HINT);            

            this.add(TouchButtonStartResource.getInstance().HINT, 
                    new OneRowSpriteIndexedAnimationFactory(
                            touchButtonStartHintResource));
        }
        else
        {
            this.add(TouchButtonStartResource.getInstance().HINT, 
                    NullAnimationFactory.getFactoryInstance());
        }
        
        super.init(level);
    }

    public boolean isLoadingLevel(int level)
    {
        ResourceLoadingLevelFactory resourceLoadingLevelFactory = 
            ResourceLoadingLevelFactory.getInstance();
        
        if(level == resourceLoadingLevelFactory.LOAD_TOUCH.getLevel())
        {
            return true;
        }
        else
        {
            return super.isLoadingLevel(level);
        }
    }
    
    public boolean isFeature()
    {
        if (!Features.getInstance().isDefault(OpenGLFeatureFactory.getInstance().OPENGL))
        {
            return true;
        } else
        {
            return false;
        }
    }

}
