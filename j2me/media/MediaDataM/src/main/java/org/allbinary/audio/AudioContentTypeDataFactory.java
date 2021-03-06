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
package org.allbinary.audio;

public class AudioContentTypeDataFactory
{
    private static final AudioContentTypeDataFactory instance = new AudioContentTypeDataFactory();

    public static AudioContentTypeDataFactory getInstance()
    {
        return instance;
    }

    public final AudioContentTypeData MIME_AUDIO_TONE = 
        new AudioContentTypeData("audio/x-tone-seq");
    
    public final AudioContentTypeData MIME_AUDIO_AMR = 
        new AudioContentTypeData("audio/amr");
    
    public final AudioContentTypeData MIME_AUDIO_AMR_WB = 
        new AudioContentTypeData("audio/amr-wb");
    
    public final AudioContentTypeData MIME_AUDIO_WAV = 
        new AudioContentTypeData("audio/x-wav");
    
    public final AudioContentTypeData MIME_AUDIO_MIDI = 
        new AudioContentTypeData("audio/midi");
    
    public final AudioContentTypeData MIME_AUDIO_SP_MIDI = 
        new AudioContentTypeData("audio/sp-midi");
    //         "audio/basic"
    //    "audio/mpeg"

    private AudioContentTypeDataFactory()
    {
        
    }
}
