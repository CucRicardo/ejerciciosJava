package proyecto;

public class ArbolEmpleado {
	
	public NodoEmpleado raiz;
	
	
    public void insertar (int valor, String nombre, Float cantidad) throws Exception {
        raiz  = insertar (raiz, valor, nombre, cantidad);
        
   }

    public  NodoEmpleado insertar(NodoEmpleado raizSub, int nempleado, String nombre, Float salario ) throws Exception{
    	//System.out.println("Insertando datos");
        if (raizSub ==null) {
    raizSub = new NodoEmpleado(nempleado, nombre, salario);
        } else if (nempleado < raizSub.getnempleado()){
            NodoEmpleado iz;
            iz = insertar(raizSub.getIzquierda(), nempleado, nombre, salario);
            raizSub.setIzquierda(iz);
        } else if (nempleado > raizSub.getnempleado()){
            NodoEmpleado dr;
            dr = insertar(raizSub.getDerecha(), nempleado, nombre, salario);
            raizSub.setDerecha(dr);
        } else {
            
            throw new Exception ("NodoEmpleado duplicado");
        }return  raizSub;
        
        }
    
    public boolean existe(int busqueda) {
        return existe(this.raiz, busqueda);
    }

    public boolean existe(NodoEmpleado n, int busqueda) {
        if (n == null) {
        	System.out.println("No existe el registro");

            return false;
        }
        if (n.getnempleado() == busqueda) {
        	n.imprimirDato();
            return true;
        } else if (busqueda < n.getnempleado()) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }
    }
    public boolean eliminar(int d) {
    	NodoEmpleado auxiliar=raiz;
    	NodoEmpleado padre=raiz;
    	boolean izquierda=true;
    	while(auxiliar.getnempleado()!=d) {
    		padre=auxiliar;
    		if(d<auxiliar.getnempleado()) {
    			izquierda=true;
    			auxiliar=auxiliar.getIzquierda();
    		}else {
    			izquierda=false;
    			auxiliar=auxiliar.getDerecha();
    		}
    		if(auxiliar==null) {
    			return false;
    		}
    	}
    	if(auxiliar.getIzquierda()==null && auxiliar.getDerecha()==null) {
    		
    		if(auxiliar==raiz) {
    			raiz=null;
    		}else if(izquierda) {
    			padre.setIzquierda(null);
    		}else {
    			padre.setDerecha(null);
    		}
    		
    		if(auxiliar.getDerecha()==null) {
        		if(auxiliar==raiz) {
        			raiz=auxiliar.getIzquierda();
        		}else if(izquierda) {
        			padre.setIzquierda(auxiliar.getIzquierda());
        		}else {
        			padre.setDerecha(auxiliar.getIzquierda());
        		}
    		}else if(auxiliar.getIzquierda()==null){//
        		if(auxiliar==raiz) {
        			raiz=auxiliar.getDerecha();
        		}else if(izquierda) {
        			padre.setIzquierda(auxiliar.getDerecha());
        		}else {
        			padre.setDerecha(auxiliar.getIzquierda());
        		}
    		}else {
    			NodoEmpleado remplazo=obtenerNodoRemplazo(auxiliar);
    			if(auxiliar==raiz) {
    				raiz=remplazo;
    			}else if(izquierda) {
    				padre.setIzquierda(remplazo);
    			}else {
    				padre.setDerecha(remplazo);
    			}
    			remplazo.setIzquierda(auxiliar.getIzquierda());
    		}
    		
    	}
    	return true;
    }
//
    public NodoEmpleado obtenerNodoRemplazo(NodoEmpleado nodoRemp) {
    	NodoEmpleado remplazarPadre=nodoRemp;
    	NodoEmpleado remplazo=nodoRemp;
    	NodoEmpleado auxiliar=nodoRemp.getIzquierda();
    	while(auxiliar!=null) {
    		remplazarPadre=remplazo;
    		remplazo=auxiliar;
    		auxiliar=auxiliar.getIzquierda();
    	}
    	if(remplazo!=nodoRemp.getDerecha()) {
    		remplazarPadre.setIzquierda(remplazo.getDerecha());
    		remplazo.setDerecha(nodoRemp.getDerecha());
    	}
    	System.out.println("El remplazo es: "+remplazo);
    	return remplazo;
    }
        
    public void preorden(NodoEmpleado n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    public void inorden(NodoEmpleado n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDato();
            inorden(n.getDerecha());
        }
    }

    public void postorden(NodoEmpleado n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            n.imprimirDato();
        }
    }

    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
    }
}
