package com.clientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

import javax.swing.JOptionPane;


import com.clases.Clientes;
import com.clases.Producto;

public class Main {

    public static void main(String[] args) {
        String menu =
                        "          1.. Agregar cliente y productos\n" +
                        "          2.. Editar cliente\n" +
                        "          3.. Eliminar cliente\n" +
                        "          4.. Consultar clientes con documento y tipo de documento \n" +
                        "          0.. Salir";
        Scanner in = new Scanner(System.in);

        String cedulaBuscar = "";
        String eleccion = "";
        int posicionLista;
        int ini;
        int confirma;
        String respuesta;
        
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        
        /*Uso ciclo do while() para iniciar menu
        * @Deprecated(since = "1.2", forRemoval = true)
        */
        
        Integer opMenu = new Integer(0);

        do {

        	opMenu = Integer.parseInt(JOptionPane.showInputDialog(menu));
        	
            switch (opMenu) {
                case 1:
                	
                	Clientes datosCliente = new Clientes();
                	
                	datosCliente.setNombre(JOptionPane.showInputDialog("Nombre : "));
                	datosCliente.setCedula(JOptionPane.showInputDialog("Cédula : "));
                	datosCliente.setCelular(JOptionPane.showInputDialog("Número celular : "));
                	datosCliente.setTelefono(JOptionPane.showInputDialog("Número teléfono fijo : "));
                	datosCliente.setDireccion(JOptionPane.showInputDialog("Dirección residencia :"));
                	
                	confirma = JOptionPane.showConfirmDialog(null, "Desea agregar productos ?");
                	
                	if (JOptionPane.OK_OPTION == confirma) {
                		int numProductos = 0;
                        numProductos = Integer.parseInt(JOptionPane.showInputDialog("Cuántos productos va a ingresar : "));
                        
                        if (numProductos > 0) {
                        	int valorIni= 1; 
                        	for (valorIni = 1; valorIni <= numProductos; valorIni++) {
                                Producto listaProductos = new Producto();
                                listaProductos.setIdProducto(JOptionPane.showInputDialog("Id producto : " + valorIni));
                                listaProductos.setNombre(JOptionPane.showInputDialog("Nombre producto : " + valorIni));
                                listaProductos.setCarateristicas(JOptionPane.showInputDialog("Características producto : " + valorIni));
                                listaProductos.setCondiciones(JOptionPane.showInputDialog("Condiciones producto : " + valorIni));
                        	
                                productos.add(listaProductos);
                        	}
                            datosCliente.setProductos(productos);
                         }
                        
                       }
                	
                   
                    listaClientes.add(datosCliente);
                    
                    /*
                    Iterator<Clientes> itrCliente = listaClientes.iterator();
                	while(itrCliente.hasNext()) {
                    	Clientes cliente= itrCliente.next();
                    	JOptionPane.showMessageDialog(null, "Cliente iterator " + cliente.getNombre());
                    }
                    */
                 break;              
                case 2:
                    eleccion = "editar";
              	    posicionLista = devolverPosCliente(listaClientes,eleccion);
              	    
              	    if (posicionLista > listaClientes.size()-1) {
              	    	JOptionPane.showMessageDialog(null,"El cliente no existe ");
              	    }
              	    else {
              	    	Clientes datosClientem = new Clientes();
              	    	
              	    	datosClientem.setNombre(JOptionPane.showInputDialog(null,"Nombre anterior: ", listaClientes.get(posicionLista).getNombre()));
              	    	datosClientem.setCedula(JOptionPane.showInputDialog(null,"Cédula anterior: ", listaClientes.get(posicionLista).getCedula()));
              	    	datosClientem.setCelular(JOptionPane.showInputDialog(null,"Celular anterior: ", listaClientes.get(posicionLista).getCelular()));
              	    	datosClientem.setTelefono(JOptionPane.showInputDialog(null,"Teléfono anterior: ", listaClientes.get(posicionLista).getTelefono()));
              	    	datosClientem.setDireccion(JOptionPane.showInputDialog(null,"Dirección anterior: ", listaClientes.get(posicionLista).getDireccion()));
              	    	listaClientes.set(posicionLista, datosClientem);
              	    	
              	    } 
              	    break;
                case 3:
                	eleccion = "eliminar";
              	    posicionLista = devolverPosCliente(listaClientes,eleccion);
               	    if (posicionLista > listaClientes.size()-1) {
            	    	JOptionPane.showMessageDialog(null,"El cliente no existe ");
            	    }
              	    else {
              	     confirma = JOptionPane.showConfirmDialog(null, "Eliminar el ciente : "
              	                                  + listaClientes.get(posicionLista).getNombre()
              	                                  + " ,con cédula :" 
              	                                  + listaClientes.get(posicionLista).getCedula()+ "?");
                     if (JOptionPane.OK_OPTION == confirma) {
                      listaClientes.remove(posicionLista);
                      JOptionPane.showMessageDialog(null, "Se eliminó el cliente...");
                     }
                     else {
                    	JOptionPane.showMessageDialog(null, "No se eliminó ningún cliente...");
                     }
              	    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                	JOptionPane.showMessageDialog( null,"Muchas gracias por usar nuestra app, hasta luego");
                    break;
                default:
                	JOptionPane.showMessageDialog( null,"El valor ingresado no es una opción válida");
                    break;
            }
        } while (!opMenu.toString().equals("0"));
        in.close();
   
    }
    
    public static Clientes agregarCliente() {
    	
    	Clientes datosCliente = new Clientes();
    	
    	datosCliente.setNombre(JOptionPane.showInputDialog("Nombre : "));
    	datosCliente.setCedula(JOptionPane.showInputDialog("Cédula : "));
    	datosCliente.setCelular(JOptionPane.showInputDialog("Número celular : "));
    	datosCliente.setTelefono(JOptionPane.showInputDialog("Número teléfono fijo : "));
    	datosCliente.setDireccion(JOptionPane.showInputDialog("Dirección residencia :"));

    	return datosCliente;
    }
    
    
    
    public static int devolverPosCliente(ArrayList<Clientes> listaClientes, String eleccion) {
    	
    	String cedulaBuscar = "";    
    	int ini = 0;
    	cedulaBuscar = JOptionPane.showInputDialog("Cédula de cliente a " + eleccion);
    	
    	for (ini = 0; ini < listaClientes.size(); ini++) {
    		if (listaClientes.get(ini).getCedula().equals(cedulaBuscar)){
        		return ini;	
        	}	
    	}
    	return ini;
     }
    }
    
