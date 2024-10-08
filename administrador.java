[9:11 PM, 10/7/2024] Alex: class Cliente {
    private String idCliente;
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public void reservarVehiculo(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, boolean seguro, boolean gps) {
        if (vehiculo.estaDisponible()) {
            Reserva reserva = new Reserva("R-" + (reservas.size() + 1), this, vehiculo, fechaInicio, fechaFin, seguro, gps);
            reserva.confirmarReserva();
            reservas.add(reserva);
        } else {
            System.out.println("El vehículo no está disponible.");
        }
    }
}
[9:12 PM, 10/7/2024] Alex: Clase administrador
[9:12 PM, 10/7/2024] Alex: class Administrador {
    private List<Vehiculo> flota;

    public Administrador() {
        this.flota = new ArrayList<>();
    }

    public void añadirVehiculo(Vehiculo vehiculo) {
        flota.add(vehiculo);
        System.out.println("Vehículo añadido a la flota.");
    }

    public boolean verificarDisponibilidad(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        return vehiculo.estaDisponible();
    }

    public List<Vehiculo> listarVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.estaDisponible()) {
                disponibles.add(vehiculo);
            }
        }
        return disponibles;
    }
}