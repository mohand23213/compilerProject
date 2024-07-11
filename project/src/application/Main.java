package application;
	
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Main extends Application {
	TextArea code;
	TextArea console;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1200,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.setTop(createHeader(primaryStage));
			root.setCenter(body());
			root.setBottom(bottom());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public HBox createHeader(Stage stage) {
        // Create the Run button
        Button runButton = new Button("Run");
        runButton.setOnAction(event -> handleButtonClick());
        runButton.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 24px;-fx-background-radius: 30;");

        // Create the centered text
        Text text = new Text("Compiler");
        text.setFill(Color.WHITE);
        text.setStyle("-fx-font-size: 30px;-fx-text: white;");

        // Create the Load From File button
        Button loadButton = new Button("Load Code File");
        loadButton.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 24px;-fx-background-radius: 30;");
        loadButton.setOnAction(event -> loadFromFile(stage));
        // Create the HBox and set its properties
        HBox hbox = new HBox();
        hbox.setPrefSize(1200, 100);
        hbox.setStyle("-fx-background-color: grey;");
        hbox.setSpacing(10);
        hbox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        // Add elements to the HBox
        hbox.getChildren().addAll(runButton, text, loadButton);

        // Center the text within the HBox
        HBox.setHgrow(text, Priority.ALWAYS);
        hbox.setSpacing(390);
        hbox.setAlignment(Pos.CENTER);

        return hbox;
    }
	public  VBox body() {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setPrefSize(1200, 500);
        // we create the label here and give it some style
        Text labelText = new Text("Enter Your Code Here");
        labelText.setStyle("-fx-font-size: 30px;-fx-text: white;");
        
        //here we create the text area that our code will exist
        HBox hbox = new HBox();
        hbox.setBorder(Border.EMPTY);
        hbox.setPrefWidth(1200);
        code = new TextArea();
        code.setStyle("-fx-border-color: black;-fx-font-size: 24px;");
        code.setPrefWidth(1200);
        code.setPrefHeight(300);
        hbox.getChildren().add(code);
        
        vbox.getChildren().addAll(labelText, hbox);
        
        return vbox;
    }
	public  VBox bottom() {
        VBox vbox = new VBox();
        vbox.setPrefHeight(200);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: lightgrey; -fx-border-radius: 0 30 0 0;");
        Text consoleText = new Text("Console");
        consoleText.setStyle("-fx-font-size: 25px;-fx-text: white;");
        borderPane.setLeft(consoleText);
        borderPane.setMaxWidth(200); //
        
        console = new TextArea();
        console.setEditable(false); // Make text area non-editable
        console.setPrefHeight(200);
        console.setStyle("-fx-font-size: 25px;-fx-text-fill: red;");
        vbox.getChildren().addAll(borderPane, console);
        
        return vbox;
    }
	private void handleButtonClick() {
        if(code.getText().isEmpty()) {
        	console.setText("error Empty Text!");
        }
        else {
        	String x=new CheckSyntax().CheckSyntaxMethod(code.getText());
        	if(x.contains("you code has no syntax errors!")) {
        		console.setStyle("-fx-font-size: 25px;-fx-text-fill: green;");
        	}
        	else {
        		console.setStyle("-fx-font-size: 25px;-fx-text-fill: red;");
        	}
            console.setText(x);
        }
    }
	private void loadFromFile(Stage primaryStage) {
		//read code from File
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Text File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            try {
                // Read text from the selected file
                String content = new String(Files.readAllBytes(selectedFile.toPath()));
                code.setText(content);
            } catch (IOException e) {
                // Handle file reading error
                showErrorAlert("Error Reading File", "An error occurred while reading the file: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
	private void showErrorAlert(String title, String content) {
		//show alert when error accured while reading the file
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
	public static void main(String[] args) {
		launch(args);
	}
}
