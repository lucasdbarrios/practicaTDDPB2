package ar.edu.unlam.pb2;

public class Vigilante extends Persona implements PerosnaBuena {
	private Banco banco;

	public Vigilante(Integer dni, String nombre, String apellido, Banco banco) {
		super(dni,nombre,apellido);
		this.banco=banco;
	}

}
	
//
//}
//interface Registrable {
//    void registrar();
//}
//
//interface Buscable {
//    void buscar();
//}
//
//class Vigilancia {
//    private String nombreCompania;
//    private Set<Banco> bancos;
//    private Set<Persona> personas;
//    private Map<Integer, Atraco> atracos;
//
//    public Vigilancia(String nombreCompania) {
//        this.nombreCompania = nombreCompania;
//        this.bancos = new HashSet<>();
//        this.personas = new HashSet<>();
//        this.atracos = new HashMap<>();
//    }
//
//    public boolean agregarBanco(Banco banco) {
//        return bancos.add(banco);
//    }
//
//    public void registrarPersona(Persona persona) throws PersonaDuplicadaException {
//        if (personas.contains(persona)) {
//            throw new PersonaDuplicadaException();
//        }
//        personas.add(persona);
//        if (persona instanceof Registrable) {
//            ((Registrable) persona).registrar();
//        }
//    }
//
//    public int cantidadDePersonasRegistradas() {
//        return personas.size();
//    }
//
//    public void registrarAtraco(int dni, int idBanco) {
//        Persona atracador = buscarPersonaPorDni(dni);
//        Banco banco = buscarBancoPorId(idBanco);
//        Atraco atraco = new Atraco(atracador, banco);
//        atracos.put(atraco.getClaveAtraco(), atraco);
//    }
//
//    public Atraco buscarAtracoPorClave(int claveAtraco) {
//        return atracos.get(claveAtraco);
//    }
//
//    private Persona buscarPersonaPorDni(int dni) {
//        for (Persona persona : personas) {
//            if (persona.getDni() == dni) {
//                return persona;
//            }
//        }
//        return null;
//    }
//
//    private Banco buscarBancoPorId(int idBanco) {
//        for (Banco banco : bancos) {
//            if (banco.getIdBanco() == idBanco) {
//                return banco;
//            }
//        }
//        return null;
//    }
//}
//
//class PersonaDuplicadaException extends Exception {
//    public PersonaDuplicadaException() {
//        super("Persona duplicada");
//    }
//}
//
//class Banco {
//    private int idBanco;
//    private String nombre;
//
//    public Banco(int idBanco, String nombre) {
//        this.idBanco = idBanco;
//        this.nombre = nombre;
//    }
//
//    public int getIdBanco() {
//        return idBanco;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    @Override
//    public int hashCode() {
//        return idBanco;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        Banco banco = (Banco) obj;
//        return idBanco == banco.idBanco;
//    }
//}
//
//class Persona implements Registrable {
//    private int dni;
//    private String nombre;
//    private String apellido;
//
//    public Persona(int dni, String nombre, String apellido) {
//        this.dni = dni;
//        this.nombre = nombre;
//        this.apellido = apellido;
//    }
//
//    public int getDni() {
//        return dni;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public String getApellido() {
//        return apellido;
//    }
//
//    @Override
//    public void registrar() {
//        System.out.println("Registrando persona: " + nombre + " " + apellido);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        Persona persona = (Persona) obj;
//        return dni == persona.dni;
//    }
//}
//
//class Atracador extends Persona {
//    private String apodo;
//    private Banda banda;
//
//    public Atracador(int dni, String nombre, String apellido, String apodo, Banda banda) {
//        super(dni, nombre, apellido);
//        this.apodo = apodo;
//        this.banda = banda;
//    }
//
//    public String getApodo() {
//        return apodo;
//    }
//
//    public Banda getBanda() {
//        return banda;
//    }
//}
//
//class Vigilante extends Persona {
//    private Banco bancoAsignado;
//
//    public Vigilante(int dni, String nombre, String apellido, Banco bancoAsignado) {
//        super(dni, nombre, apellido);
//        this.bancoAsignado = bancoAsignado;
//    }
//
//    public Banco getBancoAsignado() {
//        return bancoAsignado;
//    }
//}
//
//class Banda {
//    private int idBanda;
//    private String nombre;
//
//    public Banda(int idBanda, String nombre) {
//        this.idBanda = idBanda;
//        this.nombre = nombre;
//    }
//
//    public int getIdBanda() {
//        return idBanda;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//}
//
//class Atraco implements Buscable {
//    private static int contadorClaveAtraco = 0;
//
//    private int claveAtraco;
//    private Persona atracador;
//    private Banco banco;
//
//    public Atraco(Persona atracador, Banco banco) {
//        this.claveAtraco = generarClaveAtraco();
//        this.atracador = atracador;
//        this.banco = banco;
//    }
//
//    public int getClaveAtraco() {
//        return claveAtraco;
//    }
//
//    public Persona getAtracador() {
//        return atracador;
//    }
//
//    public Banco getBanco() {
//        return banco;
//    }
//
//    private int generarClaveAtraco() {
//        contadorClaveAtraco++;
//        return contadorClaveAtraco;
//    }
//
//    @Override
//    public void buscar() {
//        System.out.println("Buscando atraco con clave: " + claveAtraco);
//    }
//}