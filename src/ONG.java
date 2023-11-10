import java.time.LocalDate;
import java.util.*;

public class ONG {
    private String nombre;
    private Set<Donante> donantes;
    private List<Donacion> donaciones;

    public ONG(String nombre) {
        this.nombre = nombre;
        this.donantes = new HashSet<>();
        this.donaciones = new ArrayList<>();
    }

    public Donante registrarDonante(String nombre, String apellido) {
        Donante newDonante = new Donante(nombre, apellido);
        if (!donantes.add(newDonante)) {
            for (Donante donante : donantes) {
                if (donante.equals(newDonante)) {
                    return donante;
                }
            }
        }
        return newDonante;
    }

    public Donacion cargarDonacion(Donante donante, LocalDate fecha, double monto) {
        Donacion newDonacion = new Donacion(donante, fecha, monto);
        donaciones.add(newDonacion);
        return newDonacion;
    }

    public void mostrarDonantes() {
        System.out.println("Lista de donantes de: " + nombre);
        for (Donante donante : donantes) {
            System.out.println(donante);
        }
    }

    public void mostrarDonaciones() {
        System.out.println("Lista de donaciones de: " + nombre);
    
        donaciones.sort(new Comparator<Donacion>() {
            @Override
            public int compare(Donacion donacion1, Donacion donacion2) {
                return donacion1.getFecha().compareTo(donacion2.getFecha());
            }
        });
    
        for (Donacion donacion : donaciones) {
            System.out.println(donacion);
        }
    }
    

    public void mostrarResultadoALaFecha(LocalDate fechaLimite) {
        int cobradas = 0, rechazadas = 0, pendientes = 0;
        double totalCobrado = 0, montoMax = 0, montoMin = Double.MAX_VALUE;

        for (Donacion donacion : donaciones) {
            if (donacion.getFecha().isAfter(fechaLimite)) {
                continue;
            }

            switch (donacion.getEstado()) {
                case COBRADA:
                    cobradas++;
                    totalCobrado += donacion.getMonto();
                    if (donacion.getMonto() > montoMax) montoMax = donacion.getMonto();
                    if (donacion.getMonto() < montoMin) montoMin = donacion.getMonto();
                    break;
                case RECHAZADA:
                    rechazadas++;
                    break;
                case PENDIENTE:
                    pendientes++;
                    break;
            }
        }

        System.out.println("Estado de: " + nombre + " al: " + fechaLimite);
        System.out.println("- Cobradas: " + cobradas);
        System.out.println("- Rechazadas: " + rechazadas);
        System.out.println("- Pendientes: " + pendientes);

        if (cobradas > 0) {
            System.out.println("- Monto Total: $ " + totalCobrado);
            System.out.println("- Monto maximo: $ " + montoMax);
            System.out.println("- Monto minimo: $ " + (montoMin == Double.MAX_VALUE ? 0 : montoMin));
            System.out.println("- Monto medio: $ " + (totalCobrado / cobradas));
        }
    }

}
