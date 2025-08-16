import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();
        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> trucks = new ArrayList<>();
        double averageCarsHorsePower = 0;
        double averageTrucksHorsePower = 0;

        while(!input.equals("End")){
            String[] vehicleInfo = input.split(" ");
            String type = vehicleInfo[0];
            String model = vehicleInfo[1];
            String color = vehicleInfo[2];
            int horsePower = Integer.parseInt(vehicleInfo[3]);

            Vehicle vehicle = new Vehicle(type,model,color,horsePower);
            vehicles.add(vehicle);
            if(vehicle.getType().equals("car")){
                cars.add(vehicle);
            }else{
                trucks.add(vehicle);
            }
            input = scanner.nextLine();
        }

        String model = scanner.nextLine();

        while(!model.equals("Close the Catalogue")){
            for(Vehicle vehicle : vehicles){
                if(vehicle.getModel().equals(model)){
                    System.out.println(vehicle);
                }
            }
            model = scanner.nextLine();
        }

        if(cars.size() == 0){
            averageCarsHorsePower = 0;
        }else {
            for (Vehicle car : cars) {
                averageCarsHorsePower += car.getHorsePower();
            }
            averageCarsHorsePower /= cars.size();
        }

        System.out.printf("Cars have average horsepower of: %.2f.\n",averageCarsHorsePower);

        if(trucks.size() == 0){
            averageTrucksHorsePower = 0;
        }else {
            for (Vehicle truck : trucks) {
                averageTrucksHorsePower += truck.getHorsePower();
            }
            averageTrucksHorsePower /= trucks.size();
        }

        System.out.printf("Trucks have average horsepower of: %.2f.",averageTrucksHorsePower);
    }
}
