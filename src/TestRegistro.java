    public class TestRegistro {
        public static void main(String[] args) {
            ONG organizacion = new ONG("Test registro");
    
            Donante donante1 = organizacion.registrarDonante("Roberto", "Carlos");
            Donante donante2 = organizacion.registrarDonante("Roberto", "Carlos");
            Donante donante3 = organizacion.registrarDonante("Carlos", "Gardel"); 

            //Testeo de que no se registren donantes con el mismo nombre y apellido por mas de que tengan mayusculas y minusculas
            Donante donante4 = organizacion.registrarDonante("roberto", "carlos");

            System.out.println("Donante 1: " + donante1);
            System.out.println("Donante 2: " + donante2);
            System.out.println("Donante 3: " + donante3); 
            System.out.println("Donante 4: " + donante4);
    
            organizacion.mostrarDonantes();
        }
    }
