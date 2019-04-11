package ui;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import model.Flight;
import model.ScreenFlights;

public class FligthsController {

	private ScreenFlights fligths;
	
    @FXML
    private Button lastPage;

    @FXML
    private Label page;

    @FXML
    private Button nextPage;
	
	@FXML
    private TextField numberOfFlights;

    @FXML
    private Button search;

    @FXML
    private ComboBox<String> searchBy;

    @FXML
    private TextField data;

    @FXML
    private ComboBox<String> searchingKind;

    @FXML
    private ComboBox<String> orderKind;

    @FXML
    private Button date;

    @FXML
    private Button airline;

    @FXML
    private Button flight;

    @FXML
    private Button destiny;

    @FXML
    private Button gate;

    @FXML
    private VBox dates;

    @FXML
    private VBox airlines;

    @FXML
    private VBox flies;

    @FXML
    private VBox destinies;

    @FXML
    private VBox gates;

    @FXML
    void choiceSearch(ActionEvent event) {
    	search.setVisible(true);
    	searchBy.setVisible(true);
    	data.setVisible(true);
    }

    @FXML
    void generate(ActionEvent event) {
        clearData();
    	int num = 0;
    	try {
    		num = Integer.parseInt(numberOfFlights.getText());
    	}catch(NumberFormatException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("PacMan");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Thats not a number, please introude a number");
        	info.show();
    	} 
    	
    	fligths = new ScreenFlights();
    	ArrayList<Flight> fls = fligths.getFlight();
    	for (int i = 0; i < num ; i++) {
    		Flight fl = new Flight(fligths.getRandomDate(), fligths.getRandomAirline(), fligths.getRandomCode(), fligths.getRandomDestiny(), fligths.randomChar());
    		fls.add(fl);
		}   	
    	showTable();
    }

    @FXML
    void orderByAirline(ActionEvent event) {
    	fligths.sortByAirline();
    	clearData();
    	showTable();
    }

    @FXML
    void orderByDate(ActionEvent event) {

    }

    @FXML
    void orderByDestiny(ActionEvent event) {
    	fligths.sortByDestiny();
    	clearData();
    	showTable();
    }

    @FXML
    void orderByFlight(ActionEvent event) {
       try { 
    	   String kindOrder= orderKind.getValue();
    	   if(kindOrder.equals("Incercion")) {	   
    		   fligths.insertionSort(); 
    	   }else if(kindOrder.equals("Burbuja")) {	   
    		   fligths.bubbleSort(); 
    	   }else if(kindOrder.equals("Seleccion")) {	   
    		   fligths.selectionSort(); 
    	   }
    	   clearData();
    	   showTable();
       }catch(NullPointerException npe) {
   		Alert info = new Alert(AlertType.ERROR);
    	info.setTitle("PacMan");
    	info.setHeaderText(null);
    	info.initStyle(StageStyle.UTILITY);
    	info.setContentText("Please first choice a method");
    	info.show();
       }      
    }

    @FXML
    void orderByGate(ActionEvent event) {
    	fligths.sortByGate();
    	clearData();
    	showTable();
    }

    @FXML
    void searchAction(ActionEvent event) {
        
    }
    
    @FXML
    void initialize() {
       setNodes();
       configureComboBox();
    }
    public void setNodes() {
    	date.setDisable(false);
    	airline.setDisable(false);
    	flight.setDisable(false);
    	destiny.setDisable(false);
    	gate.setDisable(false);
    	search.setVisible(false);
    	searchBy.setVisible(false);
    	data.setVisible(false);
    }
    public void configureComboBox() {
    	page.setText("1");
    	searchBy.getItems().add("Date");
    	searchBy.getItems().add("Airline");
    	searchBy.getItems().add("Flight");
    	searchBy.getItems().add("Destiny");
    	searchBy.getItems().add("Gate");
    	searchingKind.getItems().add("Secuencial");
    	searchingKind.getItems().add("Binaria");
    	orderKind.getItems().add("Burbuja");
    	orderKind.getItems().add("Seleccion");
    	orderKind.getItems().add("Incercion");
    }
    
    public void showTable() {
    	ArrayList<Flight> fls = fligths.getFlight();
    	int pages=(fls.size()/14);
    	if(fls.size()%14>0) {
    		pages+=1;
    	}
    	for(int j=0;j<pages;j++){
    		if(j+1==Integer.parseInt(page.getText())){
    	    	for (int i = (14*j); i <14+(14*j) && i<fls.size(); i++) {
    	    		String date =fls.get(i).getDate().toString();
    	    		Label d = new Label("\t"+date.substring(0, 20));
    				Label a = new Label("\t"+fls.get(i).getAirline());
    				Label f = new Label("\t"+fls.get(i).getNumFlight());
    				Label de = new Label("\t"+fls.get(i).getDestiny());
    				Label g = new Label("\t"+fls.get(i).getGate());			
    				
    				dates.getChildren().add(d);
    				airlines.getChildren().add(a);
    				flies.getChildren().add(f);
    				destinies.getChildren().add(de);
    				gates.getChildren().add(g);
    		    }
    	    }

			
		}
    }
    
    public void clearData() {
    	dates.getChildren().clear();
		airlines.getChildren().clear();
		flies.getChildren().clear();
		destinies.getChildren().clear();
		gates.getChildren().clear();
    }
    
    @FXML
    void lastPageGo(ActionEvent event) {
        int newPage= Integer.parseInt(page.getText())-1;
        if(newPage>0) {
        	page.setText(newPage+"");
        	clearData();
        	showTable();
        }
    }

    @FXML
    void nextPageGo(ActionEvent event) {
       	ArrayList<Flight> fls = fligths.getFlight();
    	int newPage= Integer.parseInt(page.getText())+1;
        if(newPage<(fls.size()/14)+2) {
        	page.setText(newPage+"");
        	clearData();
        	showTable();
        }
    }
}
