import java.util.Objects;

public class Donante {
    private static int idDonante = 1;
    private int id;
    private String nombre;
    private String apellido;

    public Donante(String nombre, String apellido) {
        this.id = idDonante++;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donante donante = (Donante) o;
        return nombre.equalsIgnoreCase(donante.nombre) && apellido.equalsIgnoreCase(donante.apellido);
    }

    // Hice esto para que tambien reconozca a los donantes que tienen el mismo nombre y apellido pero con mayusuculas y minusculas
    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }
    
    @Override
    public String toString() {
        return "(" + id + ") " + apellido + ", " + nombre;
    }
}
