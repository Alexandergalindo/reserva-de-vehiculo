class Cliente {
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