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
	LAKE("LAKE", "/application/assets/sprites/lakescene.png", 768, 512, 768, 512, 1, 1, 0, 0),
	WATER1("WATER1", "/application/assets/sprites/water2.png", 768, 297, 768, 297, 1, 1, 0, 0),
	WATER2("WATER2", "/application/assets/sprites/water3.png", 768, 297, 768, 297, 1, 1, 0, 0),
	WATER3("WATER3", "/application/assets/sprites/water3.png", 768, 297, 768, 297, 1, 1, 0, 0),
	GRASS("GRASS", "/application/assets/sprites/grassyfield.png", 768, 512, 768, 512, 1, 1, 0, 0),
//	LGBUSH("LGBUSH", "/application/assets/sprites/bushLG-50x43.png", 50, 43, 50, 43, 1, 1, 0, 0),
//	SMBUSH("SMBUSH", "/application/assets/sprites/bushSM-27x21.png", 27, 21, 27, 21, 1, 1, 0, 0),
	
	SHACK("SHACK", "/application/assets/sprites/shack.png", 258, 240, 258, 240, 1, 1, 0, 0),
	WINDOW("WINDOW", "/application/assets/sprites/window.png", 42, 36, 42, 36, 1, 1, 0, 0),
	DOOR("DOOR", "/application/assets/sprites/door.png", 54, 69, 54, 69, 1, 1, 0, 0),
	FARM("FARM", "/application/assets/sprites/pokefarm.png", 490, 280, 490, 280, 1, 1, 0, 0),
	TRUNK("TRUNK", "/application/assets/sprites/poketreetrunk.png", 87, 54, 87, 54, 1, 1, 0, 0),
	TREETOP("TREETOP", "/application/assets/sprites/poketreetrunk.png", 173, 155, 173, 155, 1, 1, 0, 0),
	SIGN("SIGN", "/application/assets/sprites/sign.png", 68, 50, 68, 50, 1, 1, 0, 0), 

	
	
//	BLANKHOUSE("BLANKHOUSE", "/application/assets/sprites/blankhouse-248x498.png", 248, 498, 248, 498, 1, 1, 0, 0),
//	WINOPEN("WINOPEN", "/application/assets/sprites/winOPEN-38x85.png", 38, 85, 38, 85, 1, 1, 0, 0),
//	WINCLOSED("WINCLOSED", "/application/assets/sprites/winCLOSED-32x85.png", 32, 85, 32, 85, 1, 1, 0, 0), 
	INDOOR("INDOOR", "/application/assets/sprites/insidedoor.png", 98, 16, 98, 16, 1, 1, 0, 0),
	STONEFLOOR("STONEFLOOR", "/application/assets/sprites/stonefloor-v2.png", 768, 512, 768, 512, 1, 1, 0, 0), 
	BACKWALL("BACKWALL", "/application/assets/sprites/backwall.png", 768, 64, 768, 64, 1, 1, 0, 0),
	LEFTWALL("LEFTWALL", "/application/assets/sprites/leftwall.png", 16, 448, 16, 448, 1, 1, 0, 0), 
	RIGHTWALL("RIGHTWALL", "/application/assets/sprites/rightwall.png", 16, 448, 16, 448, 1, 1, 0, 0),
	SMCRATE("SMCRATE", "/application/assets/sprites/crateSM.png", 32, 37, 37, 37, 1, 1, 0, 0), 
	LGCRATE("LGCRATE", "/application/assets/sprites/crateLG.png", 42, 47, 42, 47, 1, 1, 0, 0),

	
/*
 * ********		S P R I T E 	S H E E T S 	*****
 */
//	LGTREES("LGTREES", "/application/assets/sprites/treeLGsheet.png", 212, 111, 64, 101, 3, 1, 5, 5),
//	SMTREES("SMTREES", "/application/assets/sprites/treeSMsheet.png", 173, 88, 51, 78, 3, 1, 5, 5),
//	TREETRUNKS("TREETRUNKS", "/application/assets/sprites/treeTrunks.png", 53, 22, 19, 22, 2, 1, 5, 0),
//	PLAYER("PLAYER", "/application/assets/sprites/playersheet.png", 1109, 64, 64, 64, 16, 1, 5, 0),

	CHRIS("CHRIS", "application/assets/sprites/adultchrissheet.png", 1045, 95, 65, 93, 19, 1, 0, 3),
	JORDAN("JORDAN", "/application/assets/sprites/jordansheet.png", 720, 100, 60, 100, 12, 1, 0, 0),
	RYAN("RYAN", "/application/assets/sprites/ryansheet.png", 512, 180, 64, 55, 8, 3, 4, 10),
	NUDEMAN("NUDEMAN", "/application/assets/sprites/nudemansheet.png", 630, 64, 57, 64, 9, 1, 13, 0),
	HURTMAN("HURTMAN", "/application/assets/sprites/hurtmansheet.png", 630, 140, 70, 70, 9, 2, 0, 0);


//	public static final Image[] playersprites = spriteFrames("PLAYER");
	public static final Image[] chrissprites = spriteFrames("CHRIS");

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
		
		return new Image(asset.url);
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
	public static Image[] characterFrames(String name, int rowindex) {
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
			int y = offsety + 0 + ((sliceheight + offsety) * rowindex) ;
//			if (rowindex == 0) {
//				y = 0 + offsety;
//			} else {
//				y = 0 + (rowindex * (sliceheight + offsety));
//			}
			
			PixelReader reader = wholeimage.getPixelReader();
			WritableImage wimage;
			for (int i = 0; i < count; i++) {
				wimage = new WritableImage(reader, x, y, slicewidth, sliceheight);
				sprites[i] = wimage;
				x += slicewidth;
			}
			
			return sprites;
		}
		return null;
		
	}
	
	
	

	/*
	 * OLD METHODS THAT NEED TO BE REPLACED
	 */
	public static Image[] returnDown() {
//		playersprites = spriteFrames("PLAYER");
		Image[] movedown = new Image[2];
		movedown[0] = chrissprites[1];
		movedown[1] = chrissprites[2];
//
		return movedown;
	}
	public static Image[] returnDown(String name) {
		Image[] sprites = spriteFrames(name);
		Image[] movedown = new Image[2];
		movedown[0] = sprites[1];
		movedown[1] = sprites[2];
//
		return movedown;
	}
	public static Image[] returnUp() {
//		Image[] playersprites = spriteFrames("PLAYER");
		Image[] moveup = new Image[2];
		moveup[0] = chrissprites[4];
		moveup[1] = chrissprites[5];

		return moveup;
	}
	public static Image[] returnUp(String name) {
		Image[] sprites = spriteFrames(name);
		Image[] moveup = new Image[2];
		moveup[0] = sprites[1];
		moveup[1] = sprites[2];
//
		return moveup;
	}

	public static Image[] returnLeft() {
//		Image[] playersprites = spriteFrames("PLAYER");
		Image[] moveleft = new Image[4];
		moveleft[0] = chrissprites[7];
		moveleft[1] = chrissprites[8];
		moveleft[2] = chrissprites[9];
		moveleft[3] = chrissprites[10];

		return moveleft;
	}
	public static Image[] returnLeft(String name) {
		Image[] sprites = spriteFrames(name);
		Image[] moveleft = new Image[4];
		moveleft[0] = sprites[1];
		moveleft[1] = sprites[2];
		moveleft[2] = sprites[9];
		moveleft[3] = sprites[10];
//
		return moveleft;
	}

	public static Image[] returnRight() {
//		Image[] playersprites = spriteFrames("PLAYER");
		Image[] moveright = new Image[4];
		moveright[0] = chrissprites[12];
		moveright[1] = chrissprites[13];
		moveright[2] = chrissprites[14];
		moveright[3] = chrissprites[15];

		return moveright;
	}
	public static Image[] returnRight(String name) {
		Image[] sprites = spriteFrames(name);
		Image[] moveright = new Image[4];
		moveright[0] = sprites[1];
		moveright[1] = sprites[2];
		moveright[2] = sprites[14];
		moveright[3] = sprites[15];

		return moveright;
	}

	public static Image[] returnIdles() {
		Image[] idles = new Image[4];
		idles[0] = chrissprites[0];
		idles[1] = chrissprites[3];
		idles[2] = chrissprites[6];
		idles[3] = chrissprites[11];

		return idles;
	}

	public static Image findIdle(String direction) {
		Image idle;
		if (direction.equals("DOWN")) {
			return idle = chrissprites[1];
		} else if (direction.equals("UP")) {
			return idle = chrissprites[3];
		} else if (direction.equals("LEFT")) {
			return idle = chrissprites[6];
		} else if (direction.equals("RIGHT")) {
			return idle = chrissprites[11];
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
