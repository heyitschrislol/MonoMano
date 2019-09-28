package application.back.managers;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class AssetManager {

	public static final String GRASS = "/application/assets/grass768x512.png";
	public static final String SMTREETOP = "/application/assets/springtreeSM-top.png";
	public static final String SMTREETRUNK = "/application/assets/treeSM-bot.png";
	public static final String LGTREETOP = "/application/assets/springtreeLG-top.png";
	public static final String LGTREETRUNK = "/application/assets/treeLG-bot.png";
	public static final String SMBUSH = "/application/assets/bushSM-27x21.png";
	public static final String LGBUSH1 = "/application/assets/bushLG.png";
	public static final String LGBUSH2= "/application/assets/bushLG2.png";
	public static final String LGBUSH3 = "/application/assets/bushLG3.png";
	public static final String LGBUSH4 = "/application/assets/bushLG4.png";

	public static final String BLANKHOUSE = "/application/assets/blankhouse-248x498.png";
	public static final String HOUSENODOOR = "/application/assets/houseNODOOR.png";
	public static final String DOOR = "/application/assets/doorOPEN.png";
	public static final String WINOPEN = "/application/assets/winOPEN-38x85.png";
	public static final String WINCLOSED = "/application/assets/winCLOSED-32x85.png";
	
	public static final String INDOOR = "/application/assets/insidedoor.png";
	public static final String STONEFLOOR = "/application/assets/stonefloor-v2.png";
	public static final String BACKWALL = "/application/assets/backwall.png";
	public static final String LEFTWALL = "/application/assets/leftwall.png";
	public static final String RIGHTWALL = "/application/assets/rightwall.png";
	public static final String SMCRATE = "/application/assets/crateSM.png";
	public static final String LGCRATE = "/application/assets/crateLG.png";



	
//	public static final String TREES_1 = "/application/assets/trees01.png";
	public static final String MONUMENT = "/application/assets/rock_monument.png";
	public static final String ROCK = "/application/assets/rock.png";
	public static final String SIGN = "/application/assets/sign.png";
	public static final String DRIEDTREE = "/application/assets/tree-dried.png";


	public static final String PLAYER_0 = "/application/assets/player_0.png";
	public static final String PLAYER_1 = "/application/assets/player_1.png";
	public static final String PLAYER_2 = "/application/assets/player_2.png";
	public static final String PLAYER_3 = "/application/assets/player_3.png";
	public static final String PLAYER_4 = "/application/assets/player_4.png";
	public static final String PLAYER_5 = "/application/assets/player_5.png";
	public static final String PLAYER_6 = "/application/assets/player_6.png";
	public static final String PLAYER_7 = "/application/assets/player_7.png";
	public static final String PLAYER_8 = "/application/assets/player_8.png";
	public static final String PLAYER_9 = "/application/assets/player_9.png";
	public static final String PLAYER_10 = "/application/assets/player_10.png";
	public static final String PLAYER_11 = "/application/assets/player_11.png";
	public static final String PLAYER_12 = "/application/assets/player_12.png";
	public static final String PLAYER_13 = "/application/assets/player_13.png";
	public static final String PLAYER_14 = "/application/assets/player_14.png";
	public static final String PLAYER_15 = "/application/assets/player_15.png";

	public static final String FTEST1 = "/application/assets/man1.png";
	public static final String FTEST2 = "/application/assets/man2.png";
	public static final String FTEST3 = "/application/assets/man3.png";
	public static final String FTEST4 = "/application/assets/man4.png";
	public static final String FTEST5 = "/application/assets/man5.png";
	public static final String FTEST6 = "/application/assets/man6.png";
	public static final String FTEST7 = "/application/assets/man7.png";
	public static final String FTEST8 = "/application/assets/man8.png";
	public static final String FTEST9 = "/application/assets/man9-death.png";
	public static final String RTEST1 = "/application/assets/nuderman1.png";
	public static final String RTEST2 = "/application/assets/nuderman2.png";
	public static final String RTEST3 = "/application/assets/nuderman3.png";
	public static final String RTEST4 = "/application/assets/nuderman4.png";
	public static final String RTEST5 = "/application/assets/nuderman5.png";
	public static final String RTEST6 = "/application/assets/nuderman6.png";
	public static final String RTEST7 = "/application/assets/nuderman7.png";
	public static final String RTEST8 = "/application/assets/nuderman8.png";
//	public static final String RTEST9 = "/application/assets/nudeman9-death.png";


	public static PixelReader wholescene;
//	public static WritableImage cutscene;
	
	/*
	 * NOTE sliceWidth should be greater than slice height and should be evenly divisible into
	 * the size of the full image.
	 * 
	 * @param iv the imageview lets you slice the large background image into smaller parts
	 */
	public static Image[][] makeScene(Image sceneimage,  int sliceWidth, int sliceHeight) {

		wholescene = sceneimage.getPixelReader();
		
		double maxwidth = sceneimage.getWidth();
		double maxheight = sceneimage.getHeight();
		
		int countX = (int) maxwidth / sliceWidth;
		int countY = (int) maxheight / sliceHeight;

		WritableImage[][] cutscenes = new WritableImage[countX][countY];

		int i = 0;
		int j = 0;
		for (int x = 0; x < maxwidth; x += sliceWidth) {
			j = 0;
			for (int y = 0; y < maxheight; y += sliceHeight) {
				cutscenes[i][j] = new WritableImage(wholescene, x, y, sliceWidth, sliceHeight);
				j++;
			}
			i++;
		}
		return cutscenes;
	}
//	public static Image[] returnDown() {
//		Image downA = new Image(FUTEST2, 64.0, 64.0, true, true);
//		Image downB = new Image(FUTEST3, 64.0, 64.0, true, true);
//		Image downC = new Image(FUTEST4, 64.0, 64.0, true, true);
//		Image downD = new Image(FUTEST5, 64.0, 64.0, true, true);
//		Image downE = new Image(FUTEST6, 64.0, 64.0, true, true);
//		Image downF = new Image(FUTEST7, 64.0, 64.0, true, true);
//		Image[] movedown = new Image[6];
//		movedown[0] = downA;
//		movedown[1] = downB;
//		movedown[2] = downC;
//		movedown[3] = downD;
//		movedown[4] = downE;
//		movedown[5] = downF;
//		
//		return movedown;
//	}
	public static Image[] returnDown() {
		Image downA = new Image(PLAYER_1, 64.0, 64.0, true, true);
		Image downB = new Image(PLAYER_0, 64.0, 64.0, true, true);
		Image downC = new Image(PLAYER_2, 64.0, 64.0, true, true);
		Image[] movedown = new Image[3];
		movedown[0] = downA;
		movedown[1] = downB;
		movedown[2] = downC;
		
		return movedown;
	}
	public static Image[] returnUp() {
		Image upA = new Image(PLAYER_4, 64.0, 64.0, true, true);
		Image upB = new Image(PLAYER_3, 64.0, 64.0, true, true);
		Image upC = new Image(PLAYER_5, 64.0, 64.0, true, true);
		Image[] moveup = new Image[3];
		moveup[0] = upA;
		moveup[1] = upB;
		moveup[2] = upC;
		
		return moveup;
	}
	public static Image[] returnLeft() {
		Image leftA = new Image(PLAYER_7, 64.0, 64.0, true, true);
		Image leftB = new Image(PLAYER_8, 64.0, 64.0, true, true);
		Image leftC = new Image(PLAYER_9, 64.0, 64.0, true, true);
		Image leftD = new Image(PLAYER_10, 64.0, 64.0, true, true);
		Image[] moveleft = new Image[4];
		moveleft[0] = leftA;
		moveleft[1] = leftB;
		moveleft[2] = leftC;
		moveleft[3] = leftD;
		
		return moveleft;
	}
//	public static Image[] returnRight() {
//		Image rightA = new Image(FTEST2, 50.0, 64.0, true, true);
//		Image rightB = new Image(FTEST3, 50.0, 64.0, true, true);
//		Image rightC = new Image(FTEST6, 50.0, 64.0, true, true);
////		Image rightD = new Image(FTEST2, 50.0, 64.0, true, true);
//		Image[] moveright = new Image[3];
//		moveright[0] = rightA;
//		moveright[1] = rightB;
//		moveright[2] = rightC;
////		moveright[3] = rightD;
//		
//		return moveright;
//	}
	public static Image[] returnRight() {
		Image rightA = new Image(PLAYER_12, 64.0, 64.0, true, true);
		Image rightB = new Image(PLAYER_13, 64.0, 64.0, true, true);
		Image rightC = new Image(PLAYER_14, 64.0, 64.0, true, true);
		Image rightD = new Image(PLAYER_15, 64.0, 64.0, true, true);
		Image[] moveright = new Image[4];
		moveright[0] = rightA;
		moveright[1] = rightB;
		moveright[2] = rightC;
		moveright[3] = rightD;
		
		return moveright;
	}
	public static Image[] returnIdles() {
		Image[] idles = new Image[4];
		idles[0] = new Image(PLAYER_1, 64.0, 64.0, true, true);
		idles[1] = new Image(PLAYER_3, 64.0, 64.0, true, true);
		idles[2] = new Image(PLAYER_6, 64.0, 64.0, true, true);
		idles[3] = new Image(PLAYER_11, 64.0, 64.0, true, true);
		
		return idles;
	}
//	public static Image findIdle(String direction) {
//		Image idle;
//		if (direction.equals("DOWN")) {
//			idle = new Image(FTEST4, 50.0, 64.0, true, true);
//		} else if (direction.equals("UP")) {
//			idle = new Image(FTEST4, 50.0, 64.0, true, true);
//		} else if (direction.equals("LEFT")) {
//			idle = new Image(PLAYER_6, 64.0, 64.0, true, true);
//		} else if (direction.equals("RIGHT")) {
//			idle = new Image(FTEST4, 50.0, 64.0, true, true);
//		} else {
//			return null;
//		}
//		
//		
//		return idle;
//	}
	public static Image findIdle(String direction) {
		Image idle;
		if (direction.equals("DOWN")) {
			idle = new Image(PLAYER_1, 64.0, 64.0, true, true);
		} else if (direction.equals("UP")) {
			idle = new Image(PLAYER_3, 64.0, 64.0, true, true);
		} else if (direction.equals("LEFT")) {
			idle = new Image(PLAYER_6, 64.0, 64.0, true, true);
		} else if (direction.equals("RIGHT")) {
			idle = new Image(PLAYER_11, 64.0, 64.0, true, true);
		} else {
			return null;
		}
		
		
		return idle;
	}
	
//	public static EnvironmentObject createTree(int x, int y) {
//		EnvironmentObject item = new EnvironmentObject(x, y);
//		
//		return item;
//	}
}