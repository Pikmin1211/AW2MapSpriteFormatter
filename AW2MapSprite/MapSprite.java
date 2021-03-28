package AW2MapSprite;

import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class MapSprite{

	private static final int tile = 8;

	public MapSprite(){}

	public BufferedImage processImageFile(File imageFile) throws IOException{
		BufferedImage sprite = null;

		try{
			sprite = ImageIO.read(imageFile);
		} catch (IOException e) {return null;}

		BufferedImage output = new BufferedImage(8,648,BufferedImage.TYPE_INT_RGB);

		int width = sprite.getWidth();
		int tileWidth = width/8;
		int height = sprite.getHeight();
		int tileHeight = height/8;

		Graphics2D working = output.createGraphics();

		for (int i = 0; i < tileHeight*3; i++){
			int currXtile = i%3;
			int currYtile = i/3;
			
			int offset = 8-(i%9) + ((i/9)*9);

			BufferedImage spritePart = sprite.getSubimage((currXtile*tile),(currYtile*tile),tile,tile);
			working.drawImage(spritePart,0,offset*tile,null);
		}

		return output;
	}



}