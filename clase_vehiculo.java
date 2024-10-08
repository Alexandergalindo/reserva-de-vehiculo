import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Clase base Vehiculo
abstract class Vehiculo {
    protected String idVehiculo;
    protected String marca;
    protected String modelo;
    protected int año;
    protected double costoDiario;
    protected boolean disponibilidad;

    public Vehiculo(String idVehiculo, String marca, String modelo, int año, double costoDiario) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.costoDiario = costoDiario;
        this.disponibilidad = true;  // Disponible por defecto
    }

    public boolean estaDisponible() {
        return disponibilidad;
    }

    public void reservar() {
        this.disponibilidad = false;
    }

    public void liberar() {
        this.disponibilidad = true;
    }

    public double calcularPrecio(int dias, boolean seguro, boolean gps) {
        double precioBase = dias * costoDiario;
        if (seguro) {
            precioBase += precioBase * 0.10;  // 10% adicional por seguro
        }
        if (gps) {
            precioBase += 5 * dias;  // $5 por día por GPS
        }
        return precioBase;
    }
}

// Subclases
class Auto extends Vehiculo {
    private String tipoCombustible;

    public Auto(String idVehiculo, String marca, String modelo, int año, double costoDiario, String tipoCombustible) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.tipoCombustible = tipoCombustible;
    }
}

class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String idVehiculo, String marca, String modelo, int año, double costoDiario, int cilindrada) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.cilindrada = cilindrada;
    }
}

class Camioneta extends Vehiculo {
    private int capacidadCarga;

    public Camioneta(String idVehiculo, String marca, String modelo, int año, double costoDiario, int capacidadCarga) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadCarga = capacidadCarga;
    }
}

class Autobus extends Vehiculo {
    private int capacidadPasajeros;

    public Autobus(String idVehiculo, String marca, String modelo, int año, double costoDiario, int capacidadPasajeros) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadPasajeros = capacidadPasajeros;
    }
}