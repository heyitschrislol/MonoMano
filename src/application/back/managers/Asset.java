package application.back.managers;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public enum Asset {
	//	ASSET(NAME, URL, WDT, HGT, COUNT, ROWS, OFFSETX, OFFSETY)
	// -------------------------------------------------------
	
	GRASS("GRASS", "/application/assets/grass768x512.png", 768, 512, 768, 512, 1, 1, 0, 0),
	LGTREES("LGTREES", "/application/assets/treeLGsheet.png", 212, 111, 64, 101, 3, 1, 5, 5),
	SMTREES("SMTREES", "/application/assets/treeSMsheet.png", 173, 88, 51, 78, 3, 1, 5, 5),
	TREETRUNKS("TREETRUNKS", "/application/assets/treeTrunks.png", 53, 22, 19, 22, 2, 1, 5, 0),
	SMTREETOP("SMTREETOP", "/application/assets/springtreeSM-top.png", 64, 112, 51, 78, 1, 1, 0, 0),
//	SMTREETRUNK("SMTREETRUNK", "/application/assets/treeSM-bot.png", 21, 17, 1, 1, 0, 0), 
//	LGTREETOP("LGTREETOP", "/application/assets/springtreeLG-top.png", 64, 112, 1, 1, 0, 0),
//	LGTREETRUNK("LGTREETRUNK", "/application/assets/treeLG-bot.png", 21, 17, 1, 1, 0, 0), 
	BLANKHOUSE("BLANKHOUSE", "/application/assets/blankhouse-248x498.png", 248, 498, 248, 498, 1, 1, 0, 0),
	DOOR("DOOR", "/application/assets/doorOPEN.png", 58, 58, 58, 58, 1, 1, 0, 0), 
	WINOPEN("WINOPEN", "/application/assets/winOPEN-38x85.png", 38, 85, 38, 85, 1, 1, 0, 0),
	WINCLOSED("WINCLOSED", "/application/assets/winCLOSED-32x85.png", 32, 85, 32, 85, 1, 1, 0, 0), 
	INDOOR("INDOOR", "/application/assets/insidedoor.png", 98, 16, 98, 16, 1, 1, 0, 0),
	STONEFLOOR("STONEFLOOR", "/application/assets/stonefloor-v2.png", 768, 512, 768, 512, 1, 1, 0, 0), 
	BACKWALL("BACKWALL", "/application/assets/backwall.png", 768, 64, 768, 64, 1, 1, 0, 0),
	LEFTWALL("LEFTWALL", "/application/assets/leftwall.png", 16, 448, 16, 448, 1, 1, 0, 0), 
	RIGHTWALL("RIGHTWALL", "/application/assets/rightwall.png", 16, 448, 16, 448, 1, 1, 0, 0),
	SMCRATE("SMCRATE", "/application/assets/crateSM.png", 32, 37, 37, 37, 1, 1, 0, 0), 
	LGCRATE("LGCRATE", "/application/assets/crateLG.png", 42, 47, 42, 47, 1, 1, 0, 0),
	SIGN("SIGN", "/application/assets/sign.png", 50, 50, 50, 50, 1, 1, 0, 0), 

	PLAYER("PLAYER", "/application/assets/playersheet.png", 1109, 64, 64, 64, 16, 1, 5, 0),
	NUDEMAN("NUDEMAN", "/application/assets/nudemansheet.png", 630, 64, 57, 64, 9, 1, 13, 0),
//	NPCS("NPCS", "/application/assets/walkcyclevarious.png", 768, 474, 12, 1, 0, 0),
	PLAYER_0("PLAYER_0", "/application/assets/player_0.png", 64, 64, 64, 64, 1, 1, 0, 0),
	PLAYER_1("PLAYER_1", "/application/assets/player_1.png", 64, 64, 64, 64, 1, 1, 0, 0), 
	PLAYER_2("PLAYER_2", "/application/assets/player_2.png", 64, 64, 64, 64, 1, 1, 0, 0),
	PLAYER_3("PLAYER_3", "/application/assets/player_3.png", 64, 64, 64, 64, 1, 1, 0, 0), 
	PLAYER_4("PLAYER_4", "/application/assets/player_4.png", 64, 64, 64, 64, 1, 1, 0, 0),
	PLAYER_5("PLAYER_5", "/application/assets/player_5.png", 64, 64, 64, 64, 1, 1, 0, 0), 
	PLAYER_6("PLAYER_6", "/application/assets/player_6.png", 64, 64, 64, 64, 1, 1, 0, 0),
	PLAYER_7("PLAYER_7", "/application/assets/player_7.png", 64, 64, 64, 64, 1, 1, 0, 0), 
	PLAYER_8("PLAYER_8", "/application/assets/player_8.png", 64, 64, 64, 64, 1, 1, 0, 0),
	PLAYER_9("PLAYER_9", "/application/assets/player_9.png", 64, 64, 64, 64, 1, 1, 0, 0), 
	PLAYER_10("PLAYER_10", "/application/assets/player_10.png", 64, 64, 64, 64, 1, 1, 0, 0),
	PLAYER_11("PLAYER_11", "/application/assets/player_11.png", 64, 64, 64, 64, 1, 1, 0, 0), 
	PLAYER_12("PLAYER_12", "/application/assets/player_12.png", 64, 64, 64, 64, 1, 1, 0, 0),
	PLAYER_13("PLAYER_13", "/application/assets/player_13.png", 64, 64, 64, 64, 1, 1, 0, 0), 
	PLAYER_14("PLAYER_14", "/application/assets/player_14.png", 64, 64, 64, 64, 1, 1, 0, 0),
	PLAYER_15("PLAYER_15", "/application/assets/player_15.png", 64, 64, 64, 64, 1, 1, 0, 0);
//	NUDEMAN1("NUDEMAN1", "/application/assets/nuderman1.png", 55, 64, 1, 1, 0, 0),
//	NUDEMAN2("NUDEMAN2", "/application/assets/nuderman2.png", 55, 64, 1, 1, 0, 0), 
//	NUDEMAN3("NUDEMAN3", "/application/assets/nuderman3.png", 55, 64, 1, 1, 0, 0),
//	NUDEMAN4("NUDEMAN4", "/application/assets/nuderman4.png", 55, 64, 1, 1, 0, 0), 
//	NUDEMAN5("NUDEMAN5", "/application/assets/nuderman5.png", 55, 64, 1, 1, 0, 0),
//	NUDEMAN6("NUDEMAN6", "/application/assets/nuderman6.png", 55, 64, 1, 1, 0, 0), 
//	NUDEMAN7("NUDEMAN7", "/application/assets/nuderman7.png", 55, 64, 1, 1, 0, 0),
//	NUDEMAN8("NUDEMAN8", "/application/assets/nuderman8.png", 55, 64, 1, 1, 0, 0), 
//	NUDEMAN9("NUDEMAN9", "/application/assets/nudeman9-death.png", 55, 64, 1, 1, 0, 0);

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
