package Ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Andrea on 30/09/2015.
 */
public class Calculadora {
    public final static double media(String file) throws FileParsingException, BigNumberException {
        double contador = 0d;
        double suma = 0d;

        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\Andrea\\Desktop\\uni\\DSA\\JAVA\\Ejercicio3\\archivo.txt"));
            String linea = null;

            while ((linea = reader.readLine()) != null){
                try {
                    int numero = Integer.parseInt(linea);
                    if (numero > 1000)
                        throw new BigNumberException ("Hay un numero mas grande que 1000 en la linea" + (int) (++contador));
                    suma += numero;
                    contador++;
                }
                catch (NumberFormatException e){
                    throw new FileParsingException (e.getMessage());
                }
            }
        }
        catch (java.io.IOException e){
            throw new FileParsingException(e.getMessage());
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException e){
                System.err.println("Precaución: No se ha podido cerrar el archivo");
            }
        }

        return suma / contador;
    }
}
