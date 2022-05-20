package proyecto;


public class NodoEmpleado {
	private int nempleado;
	private String nombre;
	private Float salario;
	private NodoEmpleado izquierda;
	private NodoEmpleado derecha;

	public NodoEmpleado(int nempleado, String nombre, Float salario ) {
		this.nempleado=nempleado;
		this.nombre=nombre;
		this.salario=salario;
		this.izquierda = this.derecha=null;
	}
	public int getnempleado() {return nempleado;}
	public void setnempleado(int nempleado) {this.nempleado=nempleado;}
	public String getnombre() {return nombre;}
	public void setnombre(String nombre) {this.nombre=nombre;}
	public Float getsalario() {return salario;}
	public void setsalario(float salario) {this.salario=salario;}
	
	public NodoEmpleado getIzquierda() {return izquierda;}
	public void setIzquierda(NodoEmpleado izquierda) {this.izquierda = izquierda;}
    public NodoEmpleado getDerecha() {return derecha;}
    public void setDerecha(NodoEmpleado derecha) {this.derecha = derecha;}
    public void imprimirDato() {System.out.println("| "+this.getnempleado()+" | "+this.getnombre()+" | "+this.getsalario()+" |");}
}
