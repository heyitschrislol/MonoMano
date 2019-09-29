package application.back.managers;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public enum Asset {
	GRASS("/application/assets/grass768x512.png", 768, 512, 1, 0, 0), 
	SMTREETOP("/application/assets/springtreeSM-top.png",64, 112, 1, 0, 0),
	SMTREETRUNK("/application/assets/treeSM-bot.png", 21, 17, 1, 0, 0), 
	LGTREETOP("/application/assets/springtreeLG-top.png", 64, 112, 1, 0, 0),
	LGTREETRUNK("/application/assets/treeLG-bot.png", 21, 17, 1, 0, 0), 
	BLANKHOUSE("/application/assets/blankhouse-248x498.png", 248, 498, 1, 0, 0),
	DOOR("/application/assets/doorOPEN.png", 58, 58, 1, 0, 0), 
	WINOPEN("/application/assets/winOPEN-38x85.png", 38, 85, 1, 0, 0),
	WINCLOSED("/application/assets/winCLOSED-32x85.png", 32, 85, 1, 0, 0), 
	INDOOR("/application/assets/insidedoor.png", 98, 16, 1, 0, 0),
	STONEFLOOR("/application/assets/stonefloor-v2.png", 768, 512, 1, 0, 0), 
	BACKWALL("/application/assets/backwall.png", 768, 64, 1, 0, 0),
	LEFTWALL("/application/assets/leftwall.png", 16, 448, 1, 0, 0), 
	RIGHTWALL("/application/assets/rightwall.png", 16, 448, 1, 0, 0),
	SMCRATE("/application/assets/crateSM.png", 32, 37, 1, 0, 0), 
	LGCRATE("/application/assets/crateLG.png", 42, 47, 1, 0, 0),
	SIGN("/application/assets/sign.png", 50, 50, 1, 0, 0), 

	NUDEMAN("/application/assets/nudemansheet.png", 630, 64, 9, 13, 0),
	NPCS("/application/assets/walkcyclevarious.png", 768, 474, 12, 0, 0), 
	PLAYER_0("/application/assets/player_0.png", 64, 64, 1, 0, 0),
	PLAYER_1("/application/assets/player_1.png", 64, 64, 1, 0, 0), 
	PLAYER_2("/application/assets/player_2.png", 64, 64, 1, 0, 0),
	PLAYER_3("/application/assets/player_3.png", 64, 64, 1, 0, 0), 
	PLAYER_4("/application/assets/player_4.png", 64, 64, 1, 0, 0),
	PLAYER_5("/application/assets/player_5.png", 64, 64, 1, 0, 0), 
	PLAYER_6("/application/assets/player_6.png", 64, 64, 1, 0, 0),
	PLAYER_7("/application/assets/player_7.png", 64, 64, 1, 0, 0), 
	PLAYER_8("/application/assets/player_8.png", 64, 64, 1, 0, 0),
	PLAYER_9("/application/assets/player_9.png", 64, 64, 1, 0, 0), 
	PLAYER_10("/application/assets/player_10.png", 64, 64, 1, 0, 0),
	PLAYER_11("/application/assets/player_11.png", 64, 64, 1, 0, 0), 
	PLAYER_12("/application/assets/player_12.png", 64, 64, 1, 0, 0),
	PLAYER_13("/application/assets/player_13.png", 64, 64, 1, 0, 0), 
	PLAYER_14("/application/assets/player_14.png", 64, 64, 1, 0, 0),
	PLAYER_15("/application/assets/player_15.png", 64, 64, 1, 0, 0), 
	NUDEMAN1("/application/assets/nuderman1.png", 55, 64, 1, 0, 0),
	NUDEMAN2("/application/assets/nuderman2.png", 55, 64, 1, 0, 0), 
	NUDEMAN3("/application/assets/nuderman3.png", 55, 64, 1, 0, 0),
	NUDEMAN4("/application/assets/nuderman4.png", 55, 64, 1, 0, 0), 
	NUDEMAN5("/application/assets/nuderman5.png", 55, 64, 1, 0, 0),
	NUDEMAN6("/application/assets/nuderman6.png", 55, 64, 1, 0, 0), 
	NUDEMAN7("/application/assets/nuderman7.png", 55, 64, 1, 0, 0),
	NUDEMAN8("/application/assets/nuderman8.png", 55, 64, 1, 0, 0), 
	NUDEMAN9("/application/assets/nudeman9-death.png", 55, 64, 1, 0, 0);

	private String name;
	private int sheetWidth;
	private int sheetHeight;
	private int count;
	private int offsetX;
	private int offsetY;
	

	//#########---	C O N S T R U C T O R S	---#############################################
	private Asset() {
		
	}
	private Asset(String name, int sheetWidth, int sheetHeight, int count, int offsetX, int offsetY) {
		this.name = name;
		this.sheetWidth = sheetWidth;
		this.sheetHeight = sheetHeight;
		this.count = count;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}
	
	
	//#########---	M E T H O D S  ---#############################################

	public static String findURL(Asset asset) {
		return asset.name;
	}
	
	public static Asset findAsset(String name) {
		for (Asset a : Asset.values()) {
			if (a.toString().equals(name)) {
				return a;
			}
		}
		return null;
	}
	public static Image assetImage(Asset asset) {
		Image image = new Image(asset.name);
		return image;
	}

	public static Image assetImage(String name) {
		Image image;
		for (Asset a : Asset.values()) {
			if (a.toString().equals(name)) {
				image = new Image(a.name);
				return image;
			}
		}
		return null;
	}

	public static Image[] returnDown() {
		Image[] movedown = new Image[3];
		movedown[0] = assetImage(Asset.PLAYER_1);
		movedown[1] = assetImage(Asset.PLAYER_0);
		movedown[2] = assetImage(Asset.PLAYER_2);

		return movedown;
	}

	public static Image[] returnUp() {
		Image[] moveup = new Image[3];
		moveup[0] = assetImage(Asset.PLAYER_4);
		moveup[1] = assetImage(Asset.PLAYER_3);
		moveup[2] = assetImage(Asset.PLAYER_5);

		return moveup;
	}

	public static Image[] returnLeft() {
		Image[] moveleft = new Image[4];
		moveleft[0] = assetImage(Asset.PLAYER_7);
		moveleft[1] = assetImage(Asset.PLAYER_8);
		moveleft[2] = assetImage(Asset.PLAYER_9);
		moveleft[3] = assetImage(Asset.PLAYER_10);

		return moveleft;
	}

	public static Image[] returnRight() {
		Image[] moveright = new Image[4];
		moveright[0] = assetImage(Asset.PLAYER_12);
		moveright[1] = assetImage(Asset.PLAYER_13);
		moveright[2] = assetImage(Asset.PLAYER_14);
		moveright[3] = assetImage(Asset.PLAYER_15);

		return moveright;
	}

	public static Image[] returnIdles() {
		Image[] idles = new Image[4];
		idles[0] = assetImage(Asset.PLAYER_0);
		idles[1] = assetImage(Asset.PLAYER_3);
		idles[2] = assetImage(Asset.PLAYER_6);
		idles[3] = assetImage(Asset.PLAYER_11);

		return idles;
	}

	public static Image findIdle(String direction) {
		Image idle;
		if (direction.equals("DOWN")) {
			return idle = assetImage(Asset.PLAYER_0);
		} else if (direction.equals("UP")) {
			return idle = assetImage(Asset.PLAYER_3);
		} else if (direction.equals("LEFT")) {
			return idle = assetImage(Asset.PLAYER_6);
		} else if (direction.equals("RIGHT")) {
			return idle = assetImage(Asset.PLAYER_11);
		} else {
			return null;
		}

	}
	public static Image[][] makeScene(Image sceneimage,  int sliceWidth, int sliceHeight) {

		PixelReader wholescene = sceneimage.getPixelReader();
		
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


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the sheetWidth
	 */
	public int getSheetWidth() {
		return sheetWidth;
	}


	/**
	 * @return the sheetHeight
	 */
	public int getSheetHeight() {
		return sheetHeight;
	}


	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}


	/**
	 * @return the offsetX
	 */
	public int getOffsetX() {
		return offsetX;
	}


	/**
	 * @return the offsetY
	 */
	public int getOffsetY() {
		return offsetY;
	}
	
	
	
	
	
//#########---	G E T / S E T  ---#############################################

	
}
