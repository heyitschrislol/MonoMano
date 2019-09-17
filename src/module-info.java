module MonoMano {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires java.sql;
	requires javafx.base;
	requires java.desktop;
	
	opens application.front to java.fxml;
	exports application.front;
	
	opens application.back;
	exports application.back;
	
	opens application.assets;
	

}