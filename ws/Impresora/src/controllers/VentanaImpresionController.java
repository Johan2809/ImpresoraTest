package controllers;

import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;

import javax.swing.JOptionPane;

public class VentanaImpresionController {

	@FXML
	// Bot�n de impresi�n
	private Button btnImprimir;

	@FXML
	// Bot�n de b�squeda de archivo
	private Button btnBuscar;

	// Aplicaci�n principal
	private Aplicacion aplicacion;

	@FXML
	// Label para mostrar el archivo seleccionado
	private Label lblArchivoSeleccionado;

	@FXML
	// Vista previa de la imagen seleccionada
	private ImageView imageView;

	@FXML
	// Contenedor para la imagen seleccionada
	private ImageView contenedorImageView;

	@FXML
	// M�todo de manejo de eventos para el bot�n de b�squeda de archivos
	void BuscarArchivo(ActionEvent event) {
		// Crea un FileChooser para mostrar el cuadro de di�logo de selecci�n de
		// archivo
		FileChooser fileChooser = new FileChooser();
		// Muestra el cuadro de di�logo y obtiene el archivo seleccionado
		File archivoSeleccionado = fileChooser.showOpenDialog(aplicacion.getPrimaryStage());
		// Verifica si se seleccion� un archivo
		if (archivoSeleccionado != null) {
			// Actualiza la etiqueta con la ruta del archivo seleccionado
			lblArchivoSeleccionado.setText("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
			// Crea una imagen a partir del archivo seleccionado
			Image imagen = new Image(archivoSeleccionado.toURI().toString());
			// Crea una vista previa de la imagen
			ImageView imageView = new ImageView(imagen);
			try {
				// Actualiza la imagen en la vista previa
				if (imagen != null)
					imageView.setImage(imagen);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	// M�todo de manejo de eventos para el bot�n de vista previa
	void mostrarVistaPrevia(ActionEvent event) {
		// Obtiene la ruta del archivo seleccionado
		File archivoSeleccionado = new File(lblArchivoSeleccionado.getText().replace("Archivo seleccionado: ", ""));
		// Verifica si el archivo existe
		if (archivoSeleccionado.exists()) {
			// Crea una imagen a partir del archivo seleccionado
			Image imagen = new Image(archivoSeleccionado.toURI().toString());
			// Crea una vista previa de la imagen
			ImageView imageView = new ImageView(imagen);
			// Crea un contenedor para la vista previa de la imagen
			VBox vbox = new VBox(imageView);
			// Crea una escena con el contenedor de la vista previa
			javafx.scene.Scene scene = new javafx.scene.Scene(vbox);
			// Crea una nueva ventana
			javafx.stage.Stage stage = new javafx.stage.Stage();
			// Establece el ancho de la imagen en la vista previa
			imageView.setFitWidth(500);
			// Establece la altura de la imagen en la vista previa
			imageView.setFitHeight(500);
			// Conserva la relaci�n de aspecto de la imagen
			imageView.setPreserveRatio(true);
			// Establece el t�tulo de la ventana
			stage.setTitle("Vista previa de imagen");
			stage.setScene(scene);
			// Muestra la ventana de vista previa de la imagen
			stage.show();
		} else {
			// Muestra un mensaje de error si no se ha seleccionado ning�n
			// archivo
			JOptionPane.showMessageDialog(null, "No se ha seleccionado ning�n archivo.");
		}
	}

	@FXML
	// M�todo que maneja los eventos del bot�n de impresi�n
	void ImprimirArchivo(ActionEvent event) {
		// Obtiene la ruta del archivo seleccionado de la etiqueta
		String archivoSeleccionado = lblArchivoSeleccionado.getText().replace("Archivo seleccionado: ", "");
		// Verifica si existe
		if (!archivoSeleccionado.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Imprimiendo");
		} else {
			JOptionPane.showMessageDialog(null, "No se ha insertado archivo a imprimir");
		}
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
}
