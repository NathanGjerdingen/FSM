package display;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.*;

public class GUI extends Application implements VehicleDisplay, EventHandler<ActionEvent> {
	private Button carOn;
	private Button carOff;
	private Button parkCar;
	private Button driveCar;
	private Button accelerateCar;
	private Button brakeCar;
	private Text powerStatus = new Text("Car Off");
	private Text MPHValue = new Text("            ");
	private Text gearStatus = new Text("Park");
	private Text movementStatus = new Text("Brake");
	private static VehicleDisplay display;
	private VehicleContext vehicleContext;

	public static VehicleDisplay getInstance() {
		return display;
	}

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		vehicleContext = VehicleContext.instance();
		vehicleContext.setDisplay(this);
		display = this;
		carOn = new Button("On");
		carOff = new Button("Off");
		parkCar = new Button("Park");
		driveCar = new Button("Drive");
		accelerateCar = new Button("Accelerate");
		brakeCar = new Button("Brake");

		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.add(powerStatus, 0, 0);
		pane.add(gearStatus, 1, 0);
		pane.add(MPHValue, 2, 0);
		pane.add(movementStatus, 3, 0);
		pane.add(carOn, 4, 0);
		pane.add(carOff, 5, 0);
		pane.add(parkCar, 6, 0);
		pane.add(driveCar, 7, 0);
		pane.add(accelerateCar, 8, 0);
		pane.add(brakeCar, 9, 0);
		showCarOff();
		showCarParked();
		showMilesPerHour(0);
		showBraking();
		carOn.setOnAction(this);
		carOff.setOnAction(this);
		parkCar.setOnAction(this);
		driveCar.setOnAction(this);
		accelerateCar.setOnAction(this);
		brakeCar.setOnAction(this);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Vehicle State");
		try {
			while (vehicleContext == null) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	/**
	 * Indicate that the car is on
	 */
	@Override
	public void showCarOn() {
		powerStatus.setText("Car On");
	}

	/**
	 * Indicate that the car is off
	 */
	@Override
	public void showCarOff() {
		powerStatus.setText("Car Off");
	}

	/**
	 * Indicate that the car is parked
	 */
	@Override
	public void showCarParked() {
		gearStatus.setText("Car Parked");
	}

	/**
	 * Indicate that the car is in drive
	 */
	@Override
	public void showCarDrive() {
		gearStatus.setText("Car In Drive");
	}

	/**
	 * display the MPH of vehicle
	 * 
	 * @param the MPH
	 */
	@Override
	public void showMilesPerHour(int value) {
		MPHValue.setText(" " + value);
	}

	/**
	 * Indicate that car is accelerating
	 */
	@Override
	public void showAccelerating() {
		movementStatus.setText("Accelerating");
	}

	/**
	 * Indicate that car is braking
	 */
	@Override
	public void showBraking() {
		movementStatus.setText("Braking");
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource().equals(carOn)) {
			vehicleContext.changeState(OnState.instance());
		} else if (event.getSource().equals(carOff)) {
			vehicleContext.turnCarOff();
		} else if (event.getSource().equals(parkCar)) {
			vehicleContext.parkCar();
		} else if (event.getSource().equals(driveCar)) {
			vehicleContext.driveCar();
		} else if (event.getSource().equals(accelerateCar)) {
			vehicleContext.gasPedalPressed();
		} else if (event.getSource().equals(brakeCar)) {
			vehicleContext.changeState(BrakingState.instance());
		}
	}
}