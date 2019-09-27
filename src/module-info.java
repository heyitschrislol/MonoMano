module MonoMano {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires java.sql;
	requires javafx.base;
	requires java.desktop;
	
	opens application.front to java.fxml;
	exports application.front;
	
	opens application.back.managers;
	exports application.back.managers;
	
	opens application.front.controllers;
	exports application.front.controllers;
	
	opens application.front.sheets;
	exports application.front.sheets;
	
	opens application.assets;
	opens application.resources.fonts;
	

}