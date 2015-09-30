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
package org.allbinary.game;

public class GameInfoData {

    private static final GameInfoData instance =
            new GameInfoData();

    public static GameInfoData getInstance() {
        return instance;
    }

    private GameInfoData() {
    }
        
    public final String GAME_TYPE = "GAME_TYPE";
    public final String GAME_MODE = "GAME_MODE";
    public final String PLAYER_TYPE = "PLAYER_TYPE";
    public final String HIGHEST_LEVEL = "HIGHEST_LEVEL";
    public final String CURRENT_LEVEL = "CURRENT_LEVEL";

    public final String SOFTWARE_INFORMATION = "SOFTWARE_INFORMATION";
}
