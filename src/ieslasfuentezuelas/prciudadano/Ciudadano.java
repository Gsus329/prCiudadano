package ieslasfuentezuelas.prciudadano;

/**
 * Clase Ciudadano
 * Contiene información de un ciudadano
 * @author JPZ
 * @since 29/10/2023
 */
public class Ciudadano {
 
    /**
     * Sexo por defecto
     */
    private final static char SEXO_DEF = 'H';
 
    /**
     * El peso de la persona esta por debajo del peso ideal
     */
    public static final int INFRAPESO = -1;
 
    /**
     * El peso de la persona esta en su peso ideal
     */
    public static final int PESO_IDEAL = 0;
 
    /**
     * El peso de la persona esta por encima del peso ideal
     */
    public static final int SOBREPESO = 1;
 
    /**
     * Nombre de la persona
     */
    private String nombre;
 
    /**
     * Edad de la persona
     */
    private int edad;
 
    /**
     * DNI de la persona, se genera al construir el objeto
     */
    private String DNI;
 
    /**
     * Sexo de la persona, H hombre M mujer
     */
    private char sexo;
 
    /**
     * Peso de la persona
     */
    private double peso;
 
    /**
     * Altura de la persona
     */
    private double altura;
 
    /**
     * Constructor por defecto
     */
    public Ciudadano() {
        this("", 0, SEXO_DEF, 0, 0);
    }
 
    /**
     * Constructor con 3 parametroe
     *
     * @param nombre de la persona
     * @param edad de la persona
     * @param sexo de la persona
     */
    public Ciudadano(String nombre, int edad, char sexo) {
        this(nombre, edad, sexo, 0, 0);
    }
 
    /**
     * Constructor con 5 parametros
     *
     * @param nombre de la persona
     * @param edad de la persona
     * @param sexo de la persona
     * @param peso de la persona
     * @param altura de la persona
     */
    public Ciudadano(String nombre, int edad, char sexo, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        generarDni();
        this.sexo = sexo;
        comprobarSexo();
    }
    /**
    *Comprueba el sexo
    */
    private void comprobarSexo() {
        //Si el sexo no es una H o una M, por defecto es H
        if (this.sexo == 'M' && this.sexo == 'H') {
            this.sexo = SEXO_DEF;
        }
    }
    /**
     * Genera DNI de manera automática
     */
    private void generarDni() {
        final int divisor = 23;
 
        //Generamos un número de 8 digitos
        int numDNI = ((int) Math.floor(Math.random()*(100000000-10000000)+10000000));
        int res = numDNI - (numDNI / divisor * divisor);
 
        //Calculamos la letra del DNI
        char letraDNI = generaLetraDNI(res);
 
        //Pasamos el DNI a String
        DNI = Integer.toString(numDNI) + letraDNI;
    }
    /**
     * Genera Letra DNI
     * @param res
     * @return Letra
     */
    private char generaLetraDNI(int res) {
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
            'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
 
        return letras[res];
    }
 
    /**
     * Modifica el nombre de la persona
     *
     * @param nombre a cambiar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    /**
     * Modifica la edad de la persona
     *
     * @param edad a cambiar
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
 
    /**
     * Modifica el sexo de la persona, comprueba que es correcto
     *
     * @param sexo a cambiar
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
 
    /**
     * Modifica el peso de la persona
     *
     * @param peso a cambiar
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
 
    /**
     * Modifica la altura de la persona
     *
     * @param altura a cambiar
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }
    /**
     * Devuelve el nombre del ciudadano
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Devuelve la edad del ciudadano
     *
     * @return edad
     */

    public int getEdad() {
        return edad;
    }
    /**
     * Devuelve el sexo del ciudadano
     *
     * @return sexo
     */
    public char getSexo() {
        return sexo;
    }
    /**
     * Devuelve el peso del ciudadano
     *
     * @return peso
     */
    public double getPeso() {
        return peso;
    }
    /**
     * Devuelve la altura del ciudadano
     *
     * @return nombre
     */
    public double getAltura() {
        return altura;
    }
    /**
     * Devuelve el DNI del ciudadano
     *
     * @return DNI
     */
    public String getDNI() {
        return DNI;
    }
    
    /**
     * Calcula el indice de masa corporal
     *
     * @return codigo numerico
     * <ul><li>-1: la persona esta por debajo de su peso ideal</li>
     * <li>0: la persona esta en su peso ideal</li>
     * <li>1: la persona esta por encima de su peso ideal</li></ul>
     */
    public int calcularIMC() {
        //Calculamos el peso de la persona
        double pesoActual = getPeso() / (Math.pow(altura, 2));
        //Segun el peso, devuelve un codigo
        if (pesoActual >= 20 && pesoActual <= 25) {
            return PESO_IDEAL;
        } else if (pesoActual < 20) {
            return INFRAPESO;
        } else {
            return SOBREPESO;
        }
    }
 
    /**
     * Indica si la persona es mayor de edad
     *
     * @return true si es mayor de edad y false es menor de edad
     */
    public boolean esMayorDeEdad() {
        boolean mayor = false;
        if (getEdad() >= 18) {
            mayor = true;
        }
        return mayor;
    }
    /**
     * Método auxiliar para imprimir IMC
     */
    public void imprimirIMC(){
        int imc=calcularIMC();
        switch (imc) {
            case INFRAPESO:
                System.out.println("Estás por debajo de tu peso ideal");
                break;
            case PESO_IDEAL:
                System.out.println("Estás en tu peso ideal");
                break;
            default:
                System.out.println("Estás por encima de tu peso ideal");
                break;
        }
    }
 
    /**
     * Devuelve informacion del objeto
     *
     * @return cadena con toda la informacion
     */
    @Override
    public String toString() {
        String sexo=null;
        if (getSexo()=='H') {
            sexo = "hombre";
        } else {
            sexo = "mujer";
        }
        return "Informacion del Ciudano:\n"
                + "Nombre: " + getNombre() + "\n"
                + "Sexo: " + sexo + "\n"
                + "Edad: " + getEdad() + " años\n"
                + "DNI: " + getDNI() + "\n"
                + "Peso: " + getPeso() + " kg\n"
                + "Altura: " + getAltura() + " metros\n";
    }
}
