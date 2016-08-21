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
package org.allbinary.animation.image.sprite;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.allbinary.animation.Animation;
import org.allbinary.animation.ProceduralAnimationInterfaceFactoryInterface;
import org.allbinary.animation.image.BaseImageAnimationFactory;

public class AllBinarySpriteRotationAnimationFactory
    extends BaseImageAnimationFactory
    implements ProceduralAnimationInterfaceFactoryInterface
{
   protected int dx;
   protected int dy;

   public AllBinarySpriteRotationAnimationFactory(Image image, int dx, int dy)
           throws Exception {
      this(image);

      this.dx = dx;
      this.dy = dy;
   }

   public AllBinarySpriteRotationAnimationFactory(Image image)
           throws Exception {
      //90 degrees per row with 4 rows
      //Future imp may include Control fidelity for non square frames
       super(image, (image.getHeight() >> 2), (image.getHeight() >> 2));
      //int frameSize = (image.getHeight() >> 2);
      //this.width = frameSize;
      //this.height = frameSize;
   }

   public AllBinarySpriteRotationAnimationFactory(Image image, String nullish)
           throws Exception {
      //90 degrees per row with 4 rows
      //Future imp may include Control fidelity for non square frames
       super(image, (image.getHeight()), (image.getHeight()));
      //int frameSize = (image.getHeight() >> 2);
      //this.width = frameSize;
      //this.height = frameSize;
   }
   
   public Animation getInstance()
      throws Exception 
   {
      Sprite sprite = new Sprite(this.getImage(), this.width, this.height);

      if (dx != 0 || dy != 0)
      {
         return new AllBinaryAdjustedSpriteRotationAnimation(sprite, dx, dy);
      } else 
      {
         return new AllBinarySpriteRotationAnimation(sprite);
      }
   }

    public Animation getInstance(Animation animationInterface) throws Exception
    {
        return this.getInstance();
    }
}
