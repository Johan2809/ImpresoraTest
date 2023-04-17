package application;

import controllers.VentanaImpresionController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/views/VentanaImpresionView.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
			VentanaImpresionController ventanaImpresionController = loader.getController();
			ventanaImpresionController.setAplicacion(this);

			Scene scene = new Scene(anchorPane);
			primaryStage.setTitle("Ventana de Impresion");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	// Implementa el m�todo getPrimaryStage() para devolver la referencia a la ventana principal
	public Stage getPrimaryStage() {
		return primaryStage;
	}

}
