package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import layout.LoginController;
import javafx.scene.Parent;
import javafx.scene.Scene;

/*
 * 리스트뷰 예제
 * https://dncjf64.tistory.com/3
 * 리스트뷰 클릭 이벤트 처리
 * http://www.devkuma.com/books/pages/604
 * */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../layout/AZ_main.fxml"));
			Parent root = loader.load();
			
			LoginController loginCon = loader.getController();
			loginCon.setPrimaryStage(primaryStage);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("AZ MALL");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
