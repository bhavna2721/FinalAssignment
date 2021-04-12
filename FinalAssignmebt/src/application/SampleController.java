package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;

public class SampleController 
{
	//for Airline Labels
	ObservableList<String> airlineOptions = FXCollections.observableArrayList("Air Canada", "Air India");
	ObservableList<String> airlineNumberOptions = FXCollections.observableArrayList("AC 102", "AC 104","AC 107","AC 113","AI 011");
	ObservableList<String> departureAirportOptions = FXCollections.observableArrayList("YVR", "YVZ");
	ObservableList<String> arrivalAirportOptions = FXCollections.observableArrayList("YVR", "YVZ","NRT");
	
	ObservableList<String> defaultitems = FXCollections.observableArrayList("Airline" ,"AirlineNo","Departure","Arrival");

	
	@FXML
	private ComboBox AirlineCombo;
	
	@FXML
	private ComboBox AirlineNumberCombo;
	
	@FXML
	private ComboBox DepartureAirportCombo;
	
	@FXML
	private ComboBox ArrivalAirportCombo;
	
	@FXML
	private ListView<String> DisplayListView;
	
	@FXML
	private Button closeButton;
	
	@FXML
	private Button searchDataButton;
	
	
	@FXML
	private ToggleGroup radioButtonChoices;
	
	@FXML
	private RadioButton rbAirline;
	
	@FXML
	private RadioButton rbAirlineNumber;
	
	@FXML
	private RadioButton rbDepartureAirport;
	
	@FXML
	private RadioButton rbArrivalAirport;
	
		@FXML
		public void initialize() {
			
			//populating the combo boxes
		
			AirlineCombo.getItems().addAll(airlineOptions);
			AirlineNumberCombo.getItems().addAll(airlineNumberOptions);
			DepartureAirportCombo.getItems().addAll(departureAirportOptions);
			ArrivalAirportCombo.getItems().addAll(arrivalAirportOptions);
			
			
		
			//close button event
			closeButton.setOnAction((ActionEvent event) -> {
	        Platform.exit();
	        });
			
			
			
			//FILE READING FOR AIRLINE PURPOSE
			//double clicking search button is showing the results.
			//Filereading for radio Button = "Airline" and combo box value = "Air Canada".
			File file = new File("C:/Users/User/Desktop/Flight.txt");
			 BufferedReader br = null;
			try 
			{
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			  String st;
			  ObservableList<String> fileItemsCanada = FXCollections.observableArrayList();
			  try {
				while ((st = br.readLine()) != null)
				  {
					if(st.contains("Air Canada"))
					{	
					
					fileItemsCanada.add(st);
					if(rbAirline.isSelected() && AirlineCombo.getValue().equals("Air Canada"))
					{
				searchDataButton.setOnAction((ActionEvent event) -> {
					DisplayListView.getItems().setAll(fileItemsCanada);
				   	DisplayListView.setOrientation(Orientation.VERTICAL);
						
		        });
					
					}
					}	else if(st.contains("Air India")) {
						ObservableList<String> fileItemsIndia = FXCollections.observableArrayList(st);
						if(rbAirline.isSelected() && AirlineCombo.getValue().equals("Air India"))
						{
					searchDataButton.setOnAction((ActionEvent event) -> {
						DisplayListView.getItems().setAll(fileItemsIndia);
					   	DisplayListView.setOrientation(Orientation.VERTICAL);
							
			        });
						}
						}
					else
						DisplayListView.getItems().setAll(defaultitems);
					
				  }
					  
				}catch (IOException e) {
				
				e.printStackTrace();
			}
			  

		//FILE READING FOR AIRLINE NUMBER PURPOSE
	
				  File fileSecondRead = new File("C:/Users/User/Desktop/Flight.txt");
					BufferedReader br2 = null;
					try 
					{
						br2 = new BufferedReader(new FileReader(fileSecondRead));
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					}
				 	  
				  String st2;
					  try {
						while ((st2 = br2.readLine()) != null)
						  {
			
							//if statement
							if(st2.contains("AC102"))
							{	
							ObservableList<String> fileItemsAirlineNumber102 = FXCollections.observableArrayList(st2);

							if(rbAirlineNumber.isSelected() && AirlineNumberCombo.getValue().equals("AC 102"))
							{
						searchDataButton.setOnAction((ActionEvent event) -> {
							DisplayListView.getItems().setAll(fileItemsAirlineNumber102);
						   	DisplayListView.setOrientation(Orientation.VERTICAL);
								
				        });
							}
							}
							else if(st2.contains("AC104"))
							{
								ObservableList<String> fileItemsAirlineNumber104 = FXCollections.observableArrayList(st2);

								if(rbAirlineNumber.isSelected() && AirlineNumberCombo.getValue().equals("AC 104"))
								{
							searchDataButton.setOnAction((ActionEvent event) -> {
								DisplayListView.getItems().setAll(fileItemsAirlineNumber104);
							   	DisplayListView.setOrientation(Orientation.VERTICAL);
									
					        });
								}
							}
							else if(st2.contains("AC107"))
							{	
							ObservableList<String> fileItemsAirlineNumber107 = FXCollections.observableArrayList(st2);
			
							if(rbAirlineNumber.isSelected() && AirlineNumberCombo.getValue().equals("AC 107"))
							{
						searchDataButton.setOnAction((ActionEvent event) -> {
							DisplayListView.getItems().setAll(fileItemsAirlineNumber107);
						   	DisplayListView.setOrientation(Orientation.VERTICAL);
								
				        });
							}
							}
							else if(st2.contains("AC113"))
							{
								ObservableList<String> fileItemsAirlineNumber113 = FXCollections.observableArrayList(st2);
								if(rbAirlineNumber.isSelected() && AirlineNumberCombo.getValue().equals("AC 113"))
								{
							searchDataButton.setOnAction((ActionEvent event) -> {
								DisplayListView.getItems().setAll(fileItemsAirlineNumber113);
							   	DisplayListView.setOrientation(Orientation.VERTICAL);
									
					        });
								}
							}
							else if(st2.contains("AI011"))
							{
								ObservableList<String> fileItemsAirlineNumber011 = FXCollections.observableArrayList(st2);
								if(rbAirlineNumber.isSelected() && AirlineNumberCombo.getValue().equals("AI 011"))
								{
							searchDataButton.setOnAction((ActionEvent event) -> {
								DisplayListView.getItems().setAll(fileItemsAirlineNumber011);
							   	DisplayListView.setOrientation(Orientation.VERTICAL);
									
					        });
								
							}
							}
							
						  }
							
					} catch (IOException e) {
						
						e.printStackTrace();
					}
		
		
		//FILE READING FOR DEPARTURE AIRPORT PURPOSE
		File fileThirdRead = new File("C:/Users/User/Desktop/Flight.txt");
		 BufferedReader br3 = null;
		try 
		{
			br3 = new BufferedReader(new FileReader(fileThirdRead));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		  String st3;
		  ObservableList<String> departureAirportYVR = FXCollections.observableArrayList();
		  ObservableList<String> departureAirportYVZ = FXCollections.observableArrayList();
		  try {
			while ((st3 = br3.readLine()) != null)
			  {
			if(st3.contains("YVR") && st3.endsWith("YVR")==false)
			{
				departureAirportYVR.add(st3);
				if(rbDepartureAirport.isSelected() && DepartureAirportCombo.getValue().equals("YVR"))
				{
			searchDataButton.setOnAction((ActionEvent event) -> {
				DisplayListView.getItems().setAll(departureAirportYVR);
			   	DisplayListView.setOrientation(Orientation.VERTICAL);
					
	        });
				}
				
				}	else if(st3.contains("YVZ") && st3.endsWith("YVR")) 
				{
					departureAirportYVZ.add(st3);
					if(rbDepartureAirport.isSelected() && DepartureAirportCombo.getValue().equals("YVZ"))
					{
				searchDataButton.setOnAction((ActionEvent event) -> {
					DisplayListView.getItems().setAll(departureAirportYVZ);
				   	DisplayListView.setOrientation(Orientation.VERTICAL);
						
		        });
					}
					}
				
			  }	
			}catch (IOException e) {
			
			e.printStackTrace();
		}
		  
		  //FILE READING FOR ARRIVAL AIRPORT
		
			File filefourthRead = new File("C:/Users/User/Desktop/Flight.txt");
			 BufferedReader br4 = null;
			try 
			{
				br4 = new BufferedReader(new FileReader(filefourthRead));
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			  String st4;
			  ObservableList<String> ArrivalAirportYVR = FXCollections.observableArrayList();
			  ObservableList<String> ArrivalAirportYVZ = FXCollections.observableArrayList();
			  ObservableList<String> ArrivalAirportNRT = FXCollections.observableArrayList();
			  try {
				while ((st4 = br4.readLine()) != null)
				  {
		
					if(st4.endsWith("YVR"))
					{	
					ArrivalAirportYVR.add(st4);
					if(rbArrivalAirport.isSelected() && ArrivalAirportCombo.getValue().equals("YVR"))
					{
				searchDataButton.setOnAction((ActionEvent event) -> {
					DisplayListView.getItems().setAll(ArrivalAirportYVR);
				   	DisplayListView.setOrientation(Orientation.VERTICAL);
						
		        });
					
					}
					}	else if(st4.endsWith("YVZ")) {
						ArrivalAirportYVZ.add(st4);
						if(rbArrivalAirport.isSelected() && ArrivalAirportCombo.getValue().equals("YVZ"))
						{
					searchDataButton.setOnAction((ActionEvent event) -> {
						DisplayListView.getItems().setAll(ArrivalAirportYVZ);
					   	DisplayListView.setOrientation(Orientation.VERTICAL);
							
			        });
						}
						}
					else if(st4.endsWith("NRT")) {
						ArrivalAirportNRT.add(st4);
						if(rbArrivalAirport.isSelected() && ArrivalAirportCombo.getValue().equals("NRT"))
						{
					searchDataButton.setOnAction((ActionEvent event) -> {
						DisplayListView.getItems().setAll(ArrivalAirportNRT);
					   	DisplayListView.setOrientation(Orientation.VERTICAL);
							
			        });
						}
						}
					
					
				  }	
				}catch (IOException e) {
				
				e.printStackTrace();
			}
		}  
		
		

		@FXML
		public void onChecked()
		{
			//if radio button Airline is selected, then combo box of Airline is enabled and others are disabled.
			if(rbAirline.isSelected()==true)
			{
				AirlineNumberCombo.setDisable(true);
				DepartureAirportCombo.setDisable(true);
				ArrivalAirportCombo.setDisable(true);
			}
			//if Airline Number is selected, then combo box of Airline Number is enabled.
			else if (rbAirlineNumber.isSelected()==true)
			{
				AirlineNumberCombo.setDisable(false);
				AirlineCombo.setDisable(true);
				DepartureAirportCombo.setDisable(true);
				ArrivalAirportCombo.setDisable(true);
			}
			//if Departure Airport is selected, then combo box of Departure Airport is enabled.
			else if (rbDepartureAirport.isSelected()==true)
			{
				DepartureAirportCombo.setDisable(false);
				ArrivalAirportCombo.setDisable(true);
				AirlineNumberCombo.setDisable(true);
				AirlineCombo.setDisable(true);
			}
			//if Arrival Airport is selected, then combo box of Arrival Airport is enabled.
			else if(rbArrivalAirport.isSelected()==true)
			{
				ArrivalAirportCombo.setDisable(false);
				AirlineCombo.setDisable(true);
				AirlineNumberCombo.setDisable(true);
				DepartureAirportCombo.setDisable(true);
			}
			
		}
	
}
