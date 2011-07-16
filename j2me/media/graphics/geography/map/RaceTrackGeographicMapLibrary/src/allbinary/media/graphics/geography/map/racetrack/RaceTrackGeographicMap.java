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
package allbinary.media.graphics.geography.map.racetrack;

import allbinary.media.graphics.geography.map.GeographicMapCellPositionBaseFactory;
import allbinary.media.graphics.geography.map.GeographicMapCellPositionFactoryInterface;

public class RaceTrackGeographicMap extends BaseRaceTrackGeographicMap
{
   public RaceTrackGeographicMap(
      RaceTrackInfo raceTrackInfo,
      RaceTrackData raceTrackData, 
      GeographicMapCellPositionFactoryInterface geographicMapCellPositionFactoryInterface,
      GeographicMapCellPositionBaseFactory geographicMapCellPositionBaseFactory)
      throws Exception
   {
      super(raceTrackInfo, raceTrackData, 
              new AllBinaryTiledLayerFactory().getInstance(raceTrackInfo, raceTrackData),
              new BasicGeographicMapFactory().getInstance(
                 raceTrackInfo, raceTrackData, geographicMapCellPositionFactoryInterface),
              geographicMapCellPositionFactoryInterface,
              geographicMapCellPositionBaseFactory);
   }   
}