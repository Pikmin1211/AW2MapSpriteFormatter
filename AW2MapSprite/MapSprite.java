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

		int[] palette = { 0xFFC8C8C8, 0xFFF8F8F8, 0xFFF89868, 0xFFF8D880, 0xFFC00000, 0xFF800010, 0xFFF8B878, 0xFFF85800, 0xFFF00008, 0xFF000000, 0xFFD88050, 0xFFC8B8A8, 0xFF908880, 0xFFA8D8E0, 0xFFF800F8, 0xFF887870 };
		IndexColorModel cm = new IndexColorModel(8, palette.length, palette, 0, true, 0, DataBuffer.TYPE_BYTE);

		BufferedImage output = new BufferedImage(8,648,BufferedImage.TYPE_BYTE_BINARY, cm);

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