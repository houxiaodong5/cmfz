package com.baizhi.util;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018/6/4.
 */
public class AudioUtil {
    public static String  getAudioLength(File file) throws TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        //File file = new File("E:\\CloudMusic\\a.mp3");
        String length=null;
        try {
            //MP3File f = (MP3File) AudioFileIO.read(file);
            AudioFile audioFile = AudioFileIO.read(file);
            //MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
            AudioHeader audioHeader1 = audioFile.getAudioHeader();
            length=audioHeader1.getTrackLength()/60+"分"+audioHeader1.getTrackLength()%60+"秒";
            //System.out.println(audioHeader.getTrackLength()/60+"分"+audioHeader.getTrackLength()%60+"秒");

        } catch(Exception e) {
            e.printStackTrace();
        }
        return  length;
    }
}
