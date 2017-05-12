package com.design.test.account;

/**
 * @author haichaow
 * @date 2017年5月10日
 * @description
 */
public class SimpleDemo3 {

}

// 通用接口
interface MediaPlayer {
	public void play(String audioType, String fileName);
}

// 特殊接口
interface AdvancedMediaPlayer {
	public void playMp4(String fileName);
}

// 特殊实现类
class Mp4Player implements AdvancedMediaPlayer {

	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file. Name: " + fileName);
	}
}

// 适配器
class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMusicPlayer = new Mp4Player();

	public void play(String audioType, String fileName) {
		advancedMusicPlayer.playMp4(fileName);
	}
}