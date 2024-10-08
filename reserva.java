class Reserva {
    private String idReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoTotal;

    public Reserva(String idReserva, Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, boolean seguro, boolean gps) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        int dias = (int) java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        this.costoTotal = vehiculo.calcularPrecio(dias, seguro, gps);
    }

    public void confirmarReserva() {
        vehiculo.reservar();
        System.out.println("Reserva confirmada. Costo total: $" + costoTotal);
    }
}