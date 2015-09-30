package Ejercicio3;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
            if (args.length != 1){
            System.err.println("El programa necesita la ruta al archivo con los numeros");
            System.exit(-1);
        }

        try {
            double media = Calculadora.media(args[0]);
            System.out.println("La media es = " + media);
        }
        catch (FileParsingException e){
            e.printStackTrace();
        } catch (BigNumberException e) {
            e.printStackTrace();
        }
    }
}
