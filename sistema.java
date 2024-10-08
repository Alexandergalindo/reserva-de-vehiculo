import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear administrador
        Administrador admin = new Administrador();

        // Añadir vehículos a la flota
        Vehiculo auto1 = new Auto("A1", "Toyota", "Corolla", 2021, 50, "Gasolina");
        Vehiculo moto1 = new Moto("M1", "Yamaha", "YZF", 2020, 30, 600);
        admin.añadirVehiculo(auto1);
        admin.añadirVehiculo(moto1);

        // Crear cliente
        Cliente cliente1 = new Cliente("C1", "Juan Perez");

        // Realizar una reserva
        LocalDate inicio = LocalDate.of(2024, 10, 7);
        LocalDate fin = LocalDate.of(2024, 10, 12);
        cliente1.reservarVehiculo(auto1, inicio, fin, true, true);

        // Listar vehículos disponibles
        for (Vehiculo v : admin.listarVehiculosDisponibles()) {
            System.out.println("Vehículo disponible: " + v.marca + "