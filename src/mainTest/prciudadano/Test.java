package mainTest.prciudadano;
import ieslasfuentezuelas.prciudadano.Ciudadano;
public class Test {

	public static void main(String[] args) {
		 Ciudadano c1 = new Ciudadano();
	        Ciudadano c2 = new Ciudadano("Jesus", 38, 'H');
	        Ciudadano c3 = new Ciudadano("Maria", 30, 'F', 60, 1.80);
	       
	        System.out.println(c1.toString());
	        System.out.println(c2.toString());
	        System.out.println(c3.toString());
	        
	        //codigo añadido
	        c1.setNombre("Alvaro");
	        c1.setEdad(23);
	        c1.setAltura(1.75);
	        c1.setPeso(77.3);
	        
	        c2.setAltura(1.83);
	        c2.setPeso(80);
	        
	        System.out.println(c1.toString());
	        System.out.println(c2.toString());
	        System.out.println(c3.toString());
	        
	        System.out.println(c1.getNombre()+": ");
	        c1.imprimirIMC();
	        System.out.println(c2.getNombre()+": ");
	        c2.imprimirIMC();
	        System.out.println(c3.getNombre()+": ");
	        c3.imprimirIMC();

	}

}
