import java.util.Objects;

public class Donante {
    private static int idDonante = 1;
    private int id;
    private String nombre;
    private String apellido;

    public Donante(String nombre, String apellido, boolean incrementarId) {
        if (incrementarId) {
            this.id = idDonante++;
        }
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    // Este constructor fue el primero que hice pero despues lo cambie por el de arriba, 
    // porque me di cuenta que de esta manera cuando creaba un donante nuevo, el id se incrementaba igual
    // por las de que tenga el mismo nombre y apellido que otro donante
    // entonces tenia que agregar un booleano para que no se incremente el id cuando se crea un donante nuevo
    // salvo que se le pase true como parametro
    // Esto esta en ONG el metodo registrarDonante
    // No se si me explico, pero primero registraba el objeto de Donante y incrementaba el Id, y me parece que no era lo correcto

    // public Donante(String nombre, String apellido) {
    //     this.id = idDonante++;
    //     this.nombre = nombre;
    //     this.apellido = apellido;
    // }

    public int getId() {
        return id;
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
