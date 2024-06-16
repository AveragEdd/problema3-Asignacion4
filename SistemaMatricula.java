// Camaño, Edward 8-1010-515
// Hou, Edwin 8-1021-1916
// Arosemena, Miguel 8-1016-2330

//Problema #3

import java.io.*;

public class SistemaMatricula {
    public static void main(String[] args) throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        char opcion;
        System.out.println("\n¡BIENVENIDO! ELIJA ENTRE LA OPCION QUE DESEA REALIZAR");

        while (true){
            try{
                System.out.println("a. Ingresar nuevo usuario");
                System.out.println("b. Ver nombre de los usuarios creados");
                System.out.println("c. Ver notas y promedio final");
                System.out.println("d. Actualizar contraseña");
                System.out.println("e. Salir del programa ");
                System.out.print("Ingrese su opcion: ");
                opcion = Character.toLowerCase(leer.readLine().charAt(0));

                Estudiantes estudiantes = new Estudiantes("", "", new double[5]);
                /*Crear instancia de la clase Estudiantes con valores iniciales vacios, para que el metodo "CreaUsuario"
                    que llamamos despues sobreescriba en estos*/
                    switch (opcion){
                        //Opcion de Ingresar nuevo usuario
                        case 'a':
                        System.out.println("\nIngrese los datos para el nuevo usuario");
                        estudiantes.crearUsuario(); // Llamada al metodo CrearUsuario
                        break;
                        
                        //Opcion de ver los nombres
                        case 'b':
                        estudiantes.mostrarUsuarios(); // Llamada al metodo MostrarUsuario
                        break;

                        //Opcion de ver notas y promedio final
                        case 'c':
                        System.out.print("Ingrese el nombre del estudiante: ");
                        String nombre = leer.readLine();
                        estudiantes.mostrarPromedioFinal(nombre);
                        break;

                        //Opcion de actualizar contraseña
                        case 'd':
                        System.out.print("Ingrese el nombre del estudiante: ");
                        nombre = leer.readLine();
                        estudiantes.actualizarContraseña(nombre);
                        break;

                        //Opcion de salir
                        case 'e':
                        System.out.println("\n¡HASTA PRONTO!");
                        System.out.println("Cerrando programa.......");
                        System.exit(0); // terminar la ejecucion del programa completo

                        default:
                        System.out.println("\nOpcion no valida!. Porfavor ingresar una de las opciones sugeridas.\n");
                        break;
                    }
                    
            } catch (IOException e) {
                System.out.println("ERROR!. La entrada no es valida, intente nuevamente");
                } 
        }
    
    }

}
