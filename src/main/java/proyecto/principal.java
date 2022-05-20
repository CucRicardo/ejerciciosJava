package proyecto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class principal {
	public static void main (String[] args) throws NumberFormatException, IOException{
		System.out.println("Ricardo Humberto Cuc Salazar");
		System.out.println("0910-14-8526");
		ArbolEmpleado lista = new ArbolEmpleado();
		
		
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\RicardoHumbertoCucSa\\Documents\\NetBeansProjects\\Porgram3Proyecto1\\src\\main\\java\\proyecto\\ListaC.csv")); 
			String line;
			while ((line = br.readLine()) != null) { 
			    // use comma as separator 
			    String[] cols = line.split(";"); 
				try {
					lista.insertar(Integer.parseInt(cols[0]),cols[1], Float.parseFloat(cols[2]));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} 
			br.close();
			System.out.println("\n>>>>>>>>>>>>>>> Pre Orden <<<<<<<<<<<<<<<\n");
			lista.preorden(lista.raiz);
			System.out.println("\n>>>>>>>>>>>>>>> in Orden <<<<<<<<<<<<<<<\n");
			lista.inorden(lista.raiz);
			System.out.println("\n>>>>>>>>>>>>>>> Post Orden <<<<<<<<<<<<<<<\n");
			lista.postorden(lista.raiz);
			System.out.println("\n>>>>>>>>>>>>>>> Buscar <<<<<<<<<<<<<<<\n");
			if(lista.existe(71)==true) {
				System.out.println("Registro Encontrado");	
			} 
			System.out.println("\n>>>>>>>>>>>>>>> Eliminar <<<<<<<<<<<<<<<\n");
			if(lista.eliminar(71)) {
				System.out.println("Registro Eliminado");	
			}
			System.out.println("\n>>>>>>>>>>>>>>> Re imprimiendo datos <<<<<<<<<<<<<<<\n");
						
			System.out.println("\n>>>>>>>>>>>>>>> Pre Orden <<<<<<<<<<<<<<<\n");
			lista.preorden(lista.raiz);
			System.out.println("\n>>>>>>>>>>>>>>> in Orden <<<<<<<<<<<<<<<\n");
			lista.inorden(lista.raiz);
			System.out.println("\n>>>>>>>>>>>>>>> Post Orden <<<<<<<<<<<<<<<\n");
			lista.postorden(lista.raiz);
			
	}	
}
