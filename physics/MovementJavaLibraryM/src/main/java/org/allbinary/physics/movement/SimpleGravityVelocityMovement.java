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
package org.allbinary.physics.movement;

import org.allbinary.game.layer.AllBinaryGameLayer;
import org.allbinary.game.physics.acceleration.GravityUtil;
import org.allbinary.game.physics.velocity.VelocityProperties;
import org.allbinary.logic.math.BasicDecimal;

/**
 *
 * @author user
 */
public class SimpleGravityVelocityMovement
   extends BasicConstantVelocityMovement
{
   public SimpleGravityVelocityMovement(BasicDecimal speedBasicDecimal)
   {
       super(speedBasicDecimal, new VelocityProperties(
               (int) speedBasicDecimal.getUnscaled(), 
               (int) speedBasicDecimal.getUnscaled()
       ));
   }
   
   private final GravityUtil gravityUtil = GravityUtil.getInstance();
   
   public void process(AllBinaryGameLayer layer)
   throws Exception
   {
      gravityUtil.process(this.getVelocityProperties());
      super.process(layer);
   }
}
