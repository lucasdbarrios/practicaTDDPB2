import java.util.*;

class Vigilancia {
    private String nombreCompania;
    private Set<Persona> personas;
    private Set<Banco> bancos;
    private Map<Integer, Atraco> atracos;
    private int contadorAtraco;

    public Vigilancia(String nombreCompania) {
        this.nombreCompania = nombreCompania;
        this.personas = new HashSet<>();
        this.bancos = new HashSet<>();
        this.atracos = new HashMap<>();
        this.contadorAtraco = 0;
    }

    public boolean agregarBanco(Banco banco) {
        return bancos.add(banco);
    }

    public void registrarPersona(Persona persona) throws PersonaDuplicadaException {
        if (personas.contains(persona)) {
            throw new PersonaDuplicadaException();
        }
        personas.add(persona);
    }

    public int cantidadDePersonasRegistradas() {
        return personas.size();
    }

    public void registrarAtraco(int dni, int idBanco) {
        contadorAtraco++;
        Atraco atraco = new Atraco(contadorAtraco, dni, idBanco);
        atracos.put(contadorAtraco, atraco);
    }

    public Atraco buscarAtracoPorClave(int claveAtraco) {
        return atracos.get(claveAtraco);
    }
}

class Persona {
    private int dni;
    private String nombre;
    private String apellido;

    public Persona(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Persona persona = (Persona) obj;
        return dni == persona.dni;
    }
}

class Banco {
    private int idBanco;
    private String nombre;

    public Banco(int idBanco, String nombre) {
        this.idBanco = idBanco;
        this.nombre = nombre;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBanco);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Banco banco = (Banco) obj;
        return idBanco == banco.idBanco;
    }
}

class Atraco {
    private int claveAtraco;
    private int dni;
    private int idBanco;

    public Atraco(int claveAtraco, int dni, int idBanco) {
        this.claveAtraco = claveAtraco;
        this.dni = dni;
        this.idBanco = idBanco;
    }

   
package ar.edu.unlam.pb2;

public class res {

}
