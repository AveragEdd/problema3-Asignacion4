// Camaño, Edward 8-1010-515
// Hou, Edwin 8-1021-1916
// Arosemena, Miguel 8-1016-2330

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estudiantes{
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    String nombre, contraseña;
    double [] calificacion = new double[5];

    // Lista para guardar los objetos de la clase Estudiante
    private static List<Estudiantes>  listaEstudiantes = new ArrayList<>();

    //constructor para inicializar los atributos
    public Estudiantes(String nombre, String contraseña, double[] calificacion) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.calificacion = calificacion;
    }

    //metodo para crear usuario
    public void crearUsuario() throws IOException{
        //If para el validar el limite de 5 usuarios
        if (listaEstudiantes.size() >= 5) {
            System.out.println("Se alcanzo el maximo de 5 usuarios");
            return;
        }
        System.out.print("Nombre del alumno: ");
        nombre = leer.readLine();
        System.out.print("Contraseña: ");
        contraseña = leer.readLine();
        double [] calificacion = new double[5];

        for (int i = 0; i < 5; i++) {
            try{  
                System.out.println("Ingrese la calificacion " + (i + 1) + ":");
                calificacion[i] = Double.parseDouble(leer.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor ingrese una calificacion"); 
                i--; //Va decrementando el contandor para pedir la misma calificacion si no es valida
            }
        }
        Estudiantes infoEstudiante = new Estudiantes(nombre, contraseña, calificacion);
        listaEstudiantes.add(infoEstudiante);
        System.out.println("Usuario creado.\n"); 
    } 

    // Metodo para mostrar los usuarios creados
    public void mostrarUsuarios() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("\nNo se encontraron estudiantes en la lista.");

        } else {
            System.out.println("\nNombres de los Estudiantes: ");
            for (Estudiantes estudiante : listaEstudiantes) {
                System.out.println("\nNombre: "+ estudiante.nombre);
            }
        }
    }

    //Metodo para mostrar calificaciones y promedio final
    public void mostrarPromedioFinal(String nombreEstudiante) {
        for (Estudiantes estudiante : listaEstudiantes) {
            if (estudiante.nombre.equalsIgnoreCase(nombreEstudiante)) {
                System.out.println("\nNombre del estudiante: " + estudiante.nombre);
                System.out.print("Calificaciones: ");
                double sumaCal = 0;
                for (double calificacion : estudiante.calificacion) {
                    System.out.print(calificacion + ", ");
                    sumaCal += calificacion;
                }
                double promedio = sumaCal / estudiante.calificacion.length;
                System.out.println("\nPromedio final: " + promedio);
                System.out.println("");
                return;
            }
        }
        System.out.println("\nEl estudiante no se ha encontrado.\n");
    }

     // Metodo para actualizar contraseña
     public void actualizarContraseña(String nombreEstudiante) throws IOException {
        for (Estudiantes estudiante : listaEstudiantes) {
            if (estudiante.nombre.equalsIgnoreCase(nombreEstudiante)) {
                System.out.print("Ingrese la contraseña actual: ");
                String contraseñaActual = leer.readLine();
                //valida si la contraseña almacenada es igual a la ingresada
                if (estudiante.contraseña.equals(contraseñaActual)) {
                    System.out.print("Ingrese la nueva contraseña: ");
                    String nuevaContraseña = leer.readLine();
                    estudiante.contraseña = nuevaContraseña;
                    System.out.println("\nContraseña actualizada sastifactoriamente\n");
                } else {
                    System.out.println("\nLa contraseña que ha introducido no es la misma\n");
                }
                return;
            }
        }
        System.out.println("\nEl estudiante no se ha encontrado.\n");
    }
} //fin class Estudiante