import java.time.LocalDate;

public class Donacion {
    private static int idDonacion = 1;
    private int id;
    private Donante donante;
    private LocalDate fecha;
    private double monto;
    private Estado estado;

    public Donacion(Donante donante, LocalDate fecha, double monto) {
        this.id = idDonacion++;
        this.donante = donante;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = Estado.PENDIENTE;
    }

    public void setCobrada() {
        this.estado = Estado.COBRADA;
    }

    public void setRechazada() {
        this.estado = Estado.RECHAZADA;
    }

    public Donante getDonante() {
        return donante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public Estado getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Donacion " + id + "\n- Donante: " + donante + "\n- Fecha: " + fecha + "\n- Estado: " + estado + "\n- Monto: " + monto;
    }
}
