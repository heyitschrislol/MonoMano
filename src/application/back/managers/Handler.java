package application.back.managers;

import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import application.back.enums.ID;
import application.back.enums.Tag;
import application.front.Base;
import application.front.controllers.Controller;
import application.front.objects.Boundary;
import application.front.objects.EnvironmentObject;
import application.front.objects.GameObject;
import application.front.objects.PlayerObject;
import application.front.sheets.Sheet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Handler {
	public static ObservableList<GameObject> objectlist;
	public static Canvas overlay;
	public static GraphicsContext ogc;
	public static Font regfont;
	public static Font boldfont;
	public static Handler handler = new Handler();
	public static Thread thread = new Thread();
	
	public Handler()  {
		try {
			setFonts();
			setOverlay(new Canvas(768, 512));
			ogc = getOverlay().getGraphicsContext2D();
			ogc.setFont(regfont);
//			thread = new Thread(SoundManager.soundmanager);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	// #########---	M E T H O D S	---#############################################

	public void setFonts() throws FileNotFoundException {
		regfont = Font.loadFont(new FileInputStream(new File("src/application/resources/fonts/AmaticSC-Regular.ttf")), 40);
        boldfont = Font.loadFont(new FileInputStream(new File("src/application/resources/fonts/AmaticSC-Bold.ttf")), 44);
	}
	public static void tick() {
		for (GameObject temp : objectlist) {
			if (temp.getID() != ID.PLAYER) {
				temp.tick();
			}
		}
	}
	public static void render(GraphicsContext gc) {
		for (GameObject temp : objectlist) {
			temp.render(gc);
		}
	}
	public static void changeScene(Controller controller) {
		Sheet sheet = controller.getSheet();
		sheet.getChildren().add(getOverlay());
		sheet.player.render(sheet.gc);			
		
		
//		SoundManager.soundmanager.setId(controller.getMusic());
//		SoundManager sm = new SoundManager("nftsb");
//		thread.
//		thread.start();
		
		Handler.setObjectlist(sheet.getObjectlist());
		Handler.render(sheet.gc);
		Scene scene = controller.getScene();
		scene.setRoot(sheet);
		Base.primaryStage.setScene(scene);
	}
	
	public static ObservableList<Boundary> objectBoundaries() {
		ObservableList<Boundary> bounds = FXCollections.observableArrayList();
		Boundary minx = new Boundary(Base.LOCX, Base.LOCY, 768, 0);
		minx.setTag(Tag.BORDER);
		Boundary miny = new Boundary(Base.LOCX, Base.LOCY, 0, 512);
		miny.setTag(Tag.BORDER);
		Boundary maxx = new Boundary(Base.LOCX, Base.LOCY + 512, 768, 0);
		maxx.setTag(Tag.BORDER);
		Boundary maxy = new Boundary(Base.LOCX + 768, Base.LOCY, 0, 512);
		maxy.setTag(Tag.BORDER);
		for (GameObject temp : objectlist) {
			if (temp.getId() == ID.COLLIDABLE || temp.getId() == ID.ITEM) {
				Boundary b = temp.getBoundary();
				b.setObj(temp);
				b.setId(temp.getId());
				b.setTag(temp.getTag());
				bounds.add(b);
			}
		}
		bounds.add(minx);
		bounds.add(miny);
		bounds.add(maxx);
		bounds.add(maxy);
		return bounds;
	}
	public static void addObject(GameObject temp) {
		Handler.objectlist.add(temp);
	}
	public static void removeObject(GameObject temp) {
		Handler.objectlist.remove(temp);
	}
	public static PlayerObject findPlayer() {
		PlayerObject player;
		for (int i = 0; i < objectlist.size(); i++) {
			if (objectlist.get(i).getId() == ID.PLAYER) {
				return player = (PlayerObject) objectlist.get(i);
			}
		}
		return null;	
	}
	
	
	public static void showPopup(GameObject eo) {
		if (!eo.getObjecttext().isBlank()) {
			ogc.setStroke(Color.BROWN);
			ogc.setLineWidth(4);
			ogc.strokeRoundRect(134, 302, 500, 200, 10, 10);
	        // Draw a filled rounded Rectangle
			ogc.setFill(Color.ANTIQUEWHITE);
	        ogc.fillRoundRect(138, 306, 494, 194, 10, 10);
	        ogc.setFill(Color.BLACK);
	        int index = 0;
	        int linect = 0;
	        int xlet = 150;
	        int ylet = 356;
	        
	        String[] lines = new String[] { "", "", "", "" };
	        String[]words = eo.getObjecttext().split(" ");
	        for (String word : words) {
	        	 linect += word.length();
	        	 if (linect < 35) {
		        	 lines[index] = lines[index].concat(" " + word);
	        	 } else {
	        		 index++;
	        		 linect = 0;
		        	 lines[index] = lines[index].concat(" " + word);
	        	 }
	        }
	        boolean isfirst = true;
	        for (int i = 0; i < lines.length; i++) {
	        	if (!lines[i].isBlank()) {
	        		if (isfirst && !eo.getName().isBlank()) {
	        			ogc.setFont(boldfont);
	        			ogc.fillText(eo.getName() + ":", xlet, ylet);
		        		ylet += 35; 
		        		ogc.setFont(regfont);
	        			ogc.fillText(lines[i], xlet, ylet);
		        		ylet += 35; 
		        		isfirst = false;
	        		} else {
	        			ogc.fillText(lines[i], xlet, ylet);
		        		ylet += 35;
	        		}
	        	}
	        }
		}
	}
	
	public static void clearPopup() {
		ogc.clearRect(0, 0, 768, 512);
	}

	/**
	 * @return the objectlist
	 */
	public static ObservableList<GameObject> getObjectlist() {
		return objectlist;
	}

	/**
	 * @param objectlist the objectlist to set
	 */
	public static void setObjectlist(ObservableList<GameObject> objectlist) {
		Handler.objectlist = objectlist;
	}

	/**
	 * @return the overlay
	 */
	public static Canvas getOverlay() {
		return overlay;
	}

	/**
	 * @param overlay the overlay to set
	 */
	public static void setOverlay(Canvas overlay) {
		Handler.overlay = overlay;
	}

	/**
	 * @return the ogc
	 */
	public static GraphicsContext getOgc() {
		return ogc;
	}

	/**
	 * @param ogc the ogc to set
	 */
	public static void setOgc(GraphicsContext ogc) {
		Handler.ogc = ogc;
	}	
}

