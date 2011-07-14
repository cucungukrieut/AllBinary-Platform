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
package allbinary.animation;

import allbinary.animation.special.SpecialAnimation;

public class NullSpecialAnimationFactory implements 
    AnimationInterfaceFactoryInterface, ProceduralAnimationInterfaceFactoryInterface
{
   private static NullSpecialAnimationFactory NULL_ANIMATION_FACTORY = new NullSpecialAnimationFactory();
   
   private NullSpecialAnimationFactory()
   {
   }

   public static NullSpecialAnimationFactory getFactoryInstance()
   {
       return NULL_ANIMATION_FACTORY;
   }

   public Animation getInstance() throws Exception
   {
	   return SpecialAnimation.getInstance();
   }
   
   public Animation getInstance(Animation animationInterface)
       throws Exception
   {
       return SpecialAnimation.getInstance();
   }
}