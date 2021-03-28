package AW2MapSprite;

import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import javax.swing.*;

public class Source{

	public static void main(String args[]) throws IOException{

		JFileChooser getFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGE FILES", "png", "bmp");
		getFile.setFileFilter(filter);

		int gf = getFile.showOpenDialog(null);
		if (gf == JFileChooser.APPROVE_OPTION){
			File inputFile = getFile.getSelectedFile();
			MapSprite mapSprite = new MapSprite();
			try {
				BufferedImage output = mapSprite.processImageFile(inputFile);
				if (output != null){
					gf = getFile.showSaveDialog(null);
					if (gf == JFileChooser.APPROVE_OPTION){
						File outputFile = getFile.getSelectedFile();
						ImageIO.write(output, "png", outputFile);
					}
				}
			}
			catch(IOException e){}
		}

		System.exit(0);
		
	}

}