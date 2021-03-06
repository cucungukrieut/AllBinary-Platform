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

public class GameTypeFactory
{
    private static final GameTypeFactory instance = new GameTypeFactory();
    
    public static GameTypeFactory getInstance()
    {
        return instance;
    }

    public GameType SINGLE_PLAYER = new GameType("Single Player");
    public GameType MULTI_PLAYER = new GameType("Multi Player");
    public GameType BOT = new GameType("Artificial Player");
}
