package application.back.enums;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public enum Asset {
	
	
//		ASSET(NAME, URL, SHTWDT, SHTHGT, SPRITEWDT, SPRITEHGT, COUNT, ROWS, OFFSETX, OFFSETY)
//	 -------------------------------------------------------------------------------------------

/*
** 		********	S I N G L E		S P R I T E S	*****
*/
	GRASS("GRASS", "/application/assets/sprites/grass768x512.png", 768, 512, 768, 512, 1, 1, 0, 0),
	LGBUSH("LGBUSH", "application/assets/sprites/bushLG-50x43.png", 50, 43, 50, 43, 1, 1, 0, 0),
	SMBUSH("SMBUSH", "application/assets/sprites/bushSM-27x21.png", 27, 21, 27, 21, 1, 1, 0, 0),
	
	BLANKHOUSE("BLANKHOUSE", "/application/assets/sprites/blankhouse-248x498.png", 248, 498, 248, 498, 1, 1, 0, 0),
	DOOR("DOOR", "/application/assets/sprites/doorOPEN.png", 58, 58, 58, 58, 1, 1, 0, 0), 
	WINOPEN("WINOPEN", "/application/assets/sprites/winOPEN-38x85.png", 38, 85, 38, 85, 1, 1, 0, 0),
	WINCLOSED("WINCLOSED", "/application/assets/sprites/winCLOSED-32x85.png", 32, 85, 32, 85, 1, 1, 0, 0), 
	INDOOR("INDOOR", "/application/assets/sprites/insidedoor.png", 98, 16, 98, 16, 1, 1, 0, 0),
	STONEFLOOR("STONEFLOOR", "/application/assets/sprites/stonefloor-v2.png", 768, 512, 768, 512, 1, 1, 0, 0), 
	BACKWALL("BACKWALL", "/application/assets/sprites/backwall.png", 768, 64, 768, 64, 1, 1, 0, 0),
	LEFTWALL("LEFTWALL", "/application/assets/sprites/leftwall.png", 16, 448, 16, 448, 1, 1, 0, 0), 
	RIGHTWALL("RIGHTWALL", "/application/assets/sprites/rightwall.png", 16, 448, 16, 448, 1, 1, 0, 0),
	SMCRATE("SMCRATE", "/application/assets/sprites/crateSM.png", 32, 37, 37, 37, 1, 1, 0, 0), 
	LGCRATE("LGCRATE", "/application/assets/sprites/crateLG.png", 42, 47, 42, 47, 1, 1, 0, 0),
	SIGN("SIGN", "/application/assets/sprites/sign.png", 50, 50, 50, 50, 1, 1, 0, 0), 

	
/*
 * ********		S P R I T E 	S H E E T S 	*****
 */
	LGTREES("LGTREES", "/application/assets/sprites/treeLGsheet.png", 212, 111, 64, 101, 3, 1, 5, 5),
	SMTREES("SMTREES", "/application/assets/sprites/treeSMsheet.png", 173, 88, 51, 78, 3, 1, 5, 5),
	TREETRUNKS("TREETRUNKS", "/application/assets/sprites/treeTrunks.png", 53, 22, 19, 22, 2, 1, 5, 0),
	PLAYER("PLAYER", "/application/assets/sprites/playersheet.png", 1109, 64, 64, 64, 16, 1, 5, 0),
	NUDEMAN("NUDEMAN", "/application/assets/sprites/nudemansheet.png", 630, 64, 57, 64, 9, 1, 13, 0);
//	NPCS("NPCS", "/application/assets/sprites/walkcyclevarious.png", 768, 474, 12, 1, 0, 0),
//	PLAYER_0("PLAYER_0", "/application/assets/sprites/player_0.png", 64, 64, 64, 64, 1, 1, 0, 0),
//	PLAYER_1("PLAYER_1", "/application/assets/sprites/player_1.png", 64, 64, 64, 64, 1, 1, 0, 0), 
//	PLAYER_2("PLAYER_2", "/application/assets/sprites/player_2.png", 64, 64, 64, 64, 1, 1, 0, 0),
//	PLAYER_3("PLAYER_3", "/application/assets/sprites/player_3.png", 64, 64, 64, 64, 1, 1, 0, 0), 
//	PLAYER_4("PLAYER_4", "/application/assets/sprites/player_4.png", 64, 64, 64, 64, 1, 1, 0, 0),
//	PLAYER_5("PLAYER_5", "/application/assets/sprites/player_5.png", 64, 64, 64, 64, 1, 1, 0, 0), 
//	PLAYER_6("PLAYER_6", "/application/assets/sprites/player_6.png", 64, 64, 64, 64, 1, 1, 0, 0),
//	PLAYER_7("PLAYER_7", "/application/assets/sprites/player_7.png", 64, 64, 64, 64, 1, 1, 0, 0), 
//	PLAYER_8("PLAYER_8", "/application/assets/sprites/player_8.png", 64, 64, 64, 64, 1, 1, 0, 0),
//	PLAYER_9("PLAYER_9", "/application/assets/sprites/player_9.png", 64, 64, 64, 64, 1, 1, 0, 0), 
//	PLAYER_10("PLAYER_10", "/application/assets/sprites/player_10.png", 64, 64, 64, 64, 1, 1, 0, 0),
//	PLAYER_11("PLAYER_11", "/application/assets/sprites/player_11.png", 64, 64, 64, 64, 1, 1, 0, 0), 
//	PLAYER_12("PLAYER_12", "/application/assets/sprites/player_12.png", 64, 64, 64, 64, 1, 1, 0, 0),
//	PLAYER_13("PLAYER_13", "/application/assets/sprites/player_13.png", 64, 64, 64, 64, 1, 1, 0, 0), 
//	PLAYER_14("PLAYER_14", "/application/assets/sprites/player_14.png", 64, 64, 64, 64, 1, 1, 0, 0),
//	PLAYER_15("PLAYER_15", "/application/assets/sprites/player_15.png", 64, 64, 64, 64, 1, 1, 0, 0);

	public static final Image[] playersprites = spriteFrames("PLAYER");
	private String name;
	private String url;
	private int sheetWidth;
	private int sheetHeight;
	private int sliceX;
	private int sliceY;
	private int count;
	private int rows;
	private int offsetX;
	private int offsetY;
	

	//#########---	C O N S T R U C T O R S	---#############################################
	private Asset() {
		
	}
	private Asset(String name, String url, int sheetWidth, int sheetHeight, int sliceX, int sliceY, int count, int rows, int offsetX, int offsetY) {
		this.name = name;
		this.url = url;
		this.sheetWidth = sheetWidth;
		this.sheetHeight = sheetHeight;
		this.sliceX = sliceX;
		this.sliceY = sliceY;
		this.count = count;
		this.rows = rows;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}
	
	
	//#########---	M E T H O D S  ---#############################################

	/* 
	 * SIMPLE METHODS
	 */
	public static String findURL(Asset asset) {
		return asset.url;
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
		Image image = new Image(asset.url);
		return image;
	}

	public static Image assetImage(String name) {
		Image image;
		for (Asset a : Asset.values()) {
			if (a.toString().equals(name)) {
				image = new Image(a.url);
				return image;
			}
		}
		return null;
	}
	public static Image assetImage(String name, double requestedWidth, double requestedHeight, boolean preserveRatio, boolean smooth) {
		Image image;
		for (Asset a : Asset.values()) {
			if (a.toString().equals(name)) {
				image = new Image(a.url, requestedWidth, requestedHeight, preserveRatio, smooth);
				return image;
			}
		}
		return null;
	}
	
	
	/*
	 * BETTER METHODS
	 */
	public static Image[] spriteFrames(String name) {
		Asset asset = Asset.findAsset(name);
		if (asset != null) {
			int count = Asset.findAsset(name).count;
			Image[] sprites = new Image[count];
			Image wholeimage = new Image(asset.url);
			
			int offsetx = asset.offsetX;
			int offsety = asset.offsetY;
			
			int slicewidth = asset.sliceX;
			int sliceheight = asset.sliceY;
			int x = 0 + offsetx;
			int y = 0 + offsety;
			
			PixelReader reader = wholeimage.getPixelReader();
			WritableImage wimage;
			for (int i = 0; i < count; i++) {
				wimage = new WritableImage(reader, x, y, slicewidth, sliceheight);
				sprites[i] = wimage;
				x += (slicewidth + offsetx);
			}
			
			return sprites;
		}
		return null;
		
	}
//	public static Image[] spriteFrames(String name, int height, int row) {
//		Asset asset = Asset.findAsset(name);
//		int count = asset.getCount();
//		Image[] sprites = new Image[count];
//		Image wholeimage = new Image(asset.url);
//		
//		int sheetwidth = asset.sheetWidth;
//		int offsetx = asset.offsetX;
//		int offsety = asset.offsetY;
//		
//		int slicewidth = (sheetwidth - (offsetx * count)) / count;
//		int sliceheight = height;
//		int x = 0 + offsetx;
//		int y = offsety + (offsety * row) + (height * row);
//		
//		PixelReader reader = wholeimage.getPixelReader();
//		WritableImage wimage;
//		for (int i = 0; i < count; i++) {
//			wimage = new WritableImage(reader, x, y, slicewidth, sliceheight);
//			sprites[i] = wimage;
//			x += (slicewidth + offsetx);
//		}
//		
//		return sprites;
//	}
//	public static Image[] spriteFrames(String name, int rowstart, int count, int slicewidth, int sliceheight) {
//		Asset asset = Asset.findAsset(name);
//		Image[] sprites = new Image[count];
//		String url = asset.getUrl();
//		Image wholeimage = new Image(url);
//		
//		int offsetx = asset.offsetX;
//		int offsety = asset.offsetY;		
//		
//		int x = 0 + offsetx;
//		int y = offsety + rowstart;
//		
//		PixelReader reader = wholeimage.getPixelReader();
//		WritableImage wimage;
//		for (int i = 0; i < count; i++) {
//			wimage = new WritableImage(reader, x, y, slicewidth, sliceheight);
//			sprites[i] = wimage;
//			x += (slicewidth + offsetx);
//		}
//		
//		return sprites;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * OLD METHODS THAT NEED TO BE REPLACED
	 */
	public static Image[] returnDown() {
//		playersprites = spriteFrames("PLAYER");
		Image[] movedown = new Image[3];
		movedown[0] = playersprites[1];
		movedown[1] = playersprites[0];
		movedown[2] = playersprites[2];
//
		return movedown;
	}

	public static Image[] returnUp() {
//		Image[] playersprites = spriteFrames("PLAYER");
		Image[] moveup = new Image[3];
		moveup[0] = playersprites[4];
		moveup[1] = playersprites[3];
		moveup[2] = playersprites[5];

		return moveup;
	}

	public static Image[] returnLeft() {
//		Image[] playersprites = spriteFrames("PLAYER");
		Image[] moveleft = new Image[4];
		moveleft[0] = playersprites[7];
		moveleft[1] = playersprites[8];
		moveleft[2] = playersprites[9];
		moveleft[3] = playersprites[10];

		return moveleft;
	}

	public static Image[] returnRight() {
//		Image[] playersprites = spriteFrames("PLAYER");
		Image[] moveright = new Image[4];
		moveright[0] = playersprites[12];
		moveright[1] = playersprites[13];
		moveright[2] = playersprites[14];
		moveright[3] = playersprites[15];

		return moveright;
	}

	public static Image[] returnIdles() {
		Image[] idles = new Image[4];
		idles[0] = playersprites[0];
		idles[1] = playersprites[3];
		idles[2] = playersprites[6];
		idles[3] = playersprites[11];

		return idles;
	}

	public static Image findIdle(String direction) {
		Image idle;
		if (direction.equals("DOWN")) {
			return idle = playersprites[0];
		} else if (direction.equals("UP")) {
			return idle = playersprites[3];
		} else if (direction.equals("LEFT")) {
			return idle = playersprites[6];
		} else if (direction.equals("RIGHT")) {
			return idle = playersprites[11];
		} else {
			return null;
		}

	}
	


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the name
	 */
	public String getUrl() {
		return url;
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
	 * @return the rows
	 */
	public int getRows() {
		return rows;
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
