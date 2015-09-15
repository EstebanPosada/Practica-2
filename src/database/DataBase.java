/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.Scanner;

public class DataBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner keyb = new Scanner (System.in);
        String user="root";//"estebanlib"
        String pass="xion88ss";
        String url="jdbc:mysql://localhost/libreria";
        String user2="estebanlib";
        String pass2="123456";
        String url2="jdbc:mysql://db4free.net/libreriaudea2015";
        String nombre;
        String name,autor,ypub,area=null,act,autax,cc;
        int cantidad,ok=0,oka=0,a,menu,check=0,presta=0,hay=0,lp,np=0,dp,err;
        
        try{
        //Prueba conexión
            System.out.println("Conectando a la base de datos...");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url2,user2,pass2);
        System.out.println("Conexión exitosa...");
        
        Statement estado = con.createStatement();
        ResultSet resultado;
        
        
         System.out.println("       Editorial los libros     ");
        
        
        do{
             
            /*System.out.println("Digite nombre de libro a actualizar/buscar");
                act=keyb.next();
                resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `name` LIKE '"+act+"'");
                
                        while (resultado.next()){
                            System.out.println(resultado.getString("autor"));
                        System.out.println(resultado.getString("id")+"\t"+resultado.getString("name")
                            +"\t"+resultado.getString("autor")+"\t"+resultado.getString("Ano_publicacion")
                            +"\t"+resultado.getString("Cantidad")+"\t"+resultado.getString("Area"));
                         }*/
            
        System.out.println("*********Menú********");
        System.out.println("*1-Ingresar libro   *");
        System.out.println("*2-Actualizar libro *");
        System.out.println("*3-Eliminar libro   *");
        System.out.println("*4-Buscar libro     *");
        System.out.println("*5-Prestar          *");
        System.out.println("*6-Devolver         *");
        System.out.println("*7-Libros prestados *");
        System.out.println("*8-Inventario       *");
        System.out.println("*9-Salir            *");
        menu=keyb.nextInt();
        keyb.nextLine();
        
        
        switch(menu){
            case 1:
            //Insertar un contacto
                System.out.println("Nombre: ");
                name=keyb.nextLine();
                System.out.println("Autor: ");
                autor=keyb.nextLine();
                System.out.println("Año de publicación: ");
                ypub=keyb.nextLine();
                System.out.println("Cantidad: ");
                cantidad=keyb.nextInt();
                keyb.nextLine();
                do{
                System.out.println("Área: \n(1)Química\t(2)Física\t(3)Tecnología\t(4)Cálculo\t(5)Programación");
                a=keyb.nextInt();

                switch(a){
                    case 1:
                        System.out.println("Química");
                        area="Quimica";
                        oka=1;
                        break;
                    case 2:
                        System.out.println("Física");
                        area="Fisica";
                        oka=1;
                        break;
                    case 3:
                        System.out.println("Tecnología");
                        area="Tecnologia";
                        oka=1;
                        break;
                    case 4:
                        System.out.println("Cálculo");
                        area="Calculo";
                        oka=1;
                        break;
                    case 5:
                        System.out.println("Programación");
                        area="Programacion";
                        oka=1;
                        break;
                    default :
                        System.out.println("Incorrecto");
                        break;
                            }
                    }while(oka!=1);
                oka=0;
                estado.executeUpdate("INSERT INTO `libro` VALUES (NULL, '"+name+"', '"+autor+"', '"+ypub+"', '"+cantidad+"', '"+area+"')");
            break;
            case 2:
                //Modificar
                System.out.println("Digite nombre de libro a actualizar");
                act=keyb.next();
                //Modificar autor
                resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `name` LIKE '"+act+"'");
                if (resultado.next()){
                    resultado.beforeFirst();
                        while (resultado.next()){
                        System.out.println("Autor: "+resultado.getString("autor")+", Digite '1' para modificar ó cualquier tecla para continuar");
                        }
                check=keyb.nextInt();
                keyb.nextLine();
                if (check==1){
                    System.out.println("Digite autor: ");
                    autor=keyb.nextLine();
                    estado.executeUpdate("UPDATE `libreria`.`libro` SET `autor` = '"+autor+"' WHERE `libro`.`name` LIKE '"+act+"'");
                    check=0;
                              }
                //Modificar Año de publicación
                resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `name` LIKE '"+act+"'");
                        while (resultado.next()){
                                System.out.println("Año de publicación: "+resultado.getString("Ano_publicacion")+", Digite '1' para modificar ó cualquier tecla para continuar");
                                 }
                    check=keyb.nextInt();
                    keyb.nextLine();
                if (check==1){
                    System.out.println("Digite Año de publicación : ");
                    ypub=keyb.nextLine();
                    estado.executeUpdate("UPDATE `libreria`.`libro` SET `Ano_publicacion` = '"+ypub+"' WHERE `libro`.`name` LIKE '"+act+"'");
                    check=0;
                              }
                //Modificar cantidad
                resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `name` LIKE '"+act+"'");
                        while (resultado.next()){
                                System.out.println("Cantidad: "+resultado.getString("Cantidad")+", Digite '1' para modificar ó cualquier tecla para continuar");
                                 }
                    check=keyb.nextInt();
                    keyb.nextLine();
                if (check==1){
                    System.out.println("Cantidad : ");
                    cantidad=keyb.nextInt();
                    estado.executeUpdate("UPDATE `libreria`.`libro` SET `Cantidad` = '"+cantidad+"' WHERE `libro`.`name` LIKE '"+act+"'");
                    check=0;
                              }
                //Modificar Área
                resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `name` LIKE '"+act+"'");
                        while (resultado.next()){
                                System.out.println("Área: "+resultado.getString("Area")+", Digite '1' para modificar ó cualquier tecla para continuar");
                                 }
                    check=keyb.nextInt();
                    keyb.nextLine();
                if (check==1){
                    do{
                    System.out.println("Área: \n(1)Química\t(2)Física\t(3)Tecnología\t(4)Cálculo\t(5)Programación");
                    a=keyb.nextInt();

                switch(a){
                    case 1:
                        System.out.println("Química");
                        area="Quimica";
                        oka=1;
                        break;
                    case 2:
                        System.out.println("Física");
                        area="Fisica";
                        oka=1;
                        break;
                    case 3:
                        System.out.println("Tecnología");
                        area="Tecnologia";
                        oka=1;
                        break;
                    case 4:
                        System.out.println("Cálculo");
                        area="Calculo";
                        oka=1;
                        break;
                    case 5:
                        System.out.println("Programación");
                        area="Programacion";
                        oka=1;
                        break;
                    default :
                        System.out.println("Incorrecto");
                        break;
                }
                }while(oka!=1);
                oka=0;
                estado.executeUpdate("UPDATE `libreria`.`libro` SET `Area` = '"+area+"' WHERE `libro`.`name` LIKE '"+act+"'");
                check=0;
                            }
                } else {
                                 System.out.println("Libro no existe");
                                 }
            break;
            case 3:
                //Delete o eliminar dato
                System.out.println("Digite nombre");
                nombre=keyb.nextLine();
                resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `name` LIKE '"+nombre+"'");
                if (resultado.next()){
                    resultado.beforeFirst();
                    //while (resultado.next()){
                        estado.executeUpdate("DELETE FROM `libro` WHERE `name` LIKE '"+nombre+"'");
                } else{
                    System.out.println("Libro no existe");
                }
                
                //resultado=estado.executeQuery("SELECT * FROM `libro`");
                /*while (resultado.next()){
                    System.out.println(resultado.getString("id")+"\t"+resultado.getString("name")
                            +"\t"+resultado.getString("autor")+"\t"+resultado.getString("Ano_publicacion")
                            +"\t"+resultado.getInt("Cantidad")+"\t"+resultado.getString("Area"));
                                        }*/
                break;
            case 4:
                //Buscar por nombre
                System.out.println("Digite nombre");
                nombre=keyb.nextLine();
                resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `name` LIKE '"+nombre+"'");
                if (resultado.next()){
                    resultado.beforeFirst();
                    while (resultado.next()){
                        System.out.println(resultado.getString("id")+"\t"+resultado.getString("name")
                                +"\t"+resultado.getString("autor")+"\t"+resultado.getString("Ano_publicacion")
                                +"\t"+resultado.getString("Cantidad")+"\t"+resultado.getString("Area"));
                                            }
                } else{
                    System.out.println("Libro no disponible");
                }
                break;
            case 5:
                //Buscar por nombre para prestamo
                System.out.println("Digite nombre de libro a prestar");
                nombre=keyb.nextLine();
                resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `name` LIKE '"+nombre+"'");
                if (resultado.next()){
                    resultado.beforeFirst();
                    while (resultado.next()){
                        hay=resultado.getInt("Cantidad");
                                            }
                if(hay<=0)
                    System.out.println("Libro no disponible");
                else {
                    System.out.println("Digite número de cédula: ");
                    cc=keyb.nextLine();
                    System.out.println("Digite número libros a prestar: ");
                    lp=keyb.nextInt();
                    if((hay-lp)<0) 
                        System.out.println("No hay la cantidad requerida");
                    else {
                        np=hay-lp;
                        estado.executeUpdate("INSERT INTO `presta` VALUES ('"+cc+"', '"+lp+"', '"+nombre+"')");
                        resultado=estado.executeQuery("SELECT * FROM `presta` WHERE `cedula` LIKE '"+cc+"'");
                        while (resultado.next()){
                            presta=resultado.getInt("Cantidad");
                                        }
                        System.out.println("Prestados: "+presta);
                        estado.executeUpdate("UPDATE `libreria`.`libro` SET `Cantidad` = '"+np+"' WHERE `libro`.`name` LIKE '"+nombre+"'");
                    }
                }
                } else {
                    System.out.println("Libro no disponible");
                }
                    
                break;
            case 6:
                //Buscar por nombre para devolución
                System.out.println("Digite cédula");
                cc=keyb.nextLine();
                System.out.println("Digite nombre de libro a devolver");
                nombre=keyb.nextLine();
                resultado=estado.executeQuery("SELECT * FROM `presta` WHERE `cedula` LIKE '"+cc+"' AND `nombre` LIKE '"+nombre+"'");
                if (resultado.next()){
                    resultado.beforeFirst();
                        while (resultado.next()){
                            presta=resultado.getInt("Cantidad");
                            System.out.println("Cantidad de libros prestados: "+presta);
                                                }
                System.out.println("Digite cantidad de libros a devolver: ");
                dp=keyb.nextInt();
                if (dp>presta) System.out.println("Cantidad de libros prestados excedida");
                else    {
                    if((presta-dp)==0) estado.executeUpdate("DELETE FROM `presta` WHERE `nombre` LIKE '"+nombre+"' AND `presta`.`cedula` LIKE '"+cc+"'");
                    else
                    estado.executeUpdate("UPDATE `libreria`.`presta` SET `Cantidad` = '"+(presta-dp)+"' WHERE `presta`.`nombre` LIKE '"+nombre+"' AND `presta`.`cedula` LIKE '"+cc+"'");
                    
                    resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `name` LIKE '"+nombre+"'");
                    while (resultado.next()){
                        hay=resultado.getInt("Cantidad");
                                            }
                    estado.executeUpdate("UPDATE `libreria`.`libro` SET `Cantidad` = '"+(hay+dp)+"' WHERE `libro`.`name` LIKE '"+nombre+"'");
                    System.out.println("Libro devuelto");
                        }
                } else {
                    System.out.println("Error");
                }
                break;
            case 7:
                //Cargar lista completa prestamos
                resultado=estado.executeQuery("SELECT * FROM `presta`");
                if (resultado.next()){
                    resultado.beforeFirst();
                    while (resultado.next()){
                        System.out.println(resultado.getString("cedula")+"\t"+resultado.getString("Cantidad")
                                +"\t"+resultado.getString("nombre"));
                                            }
                }else{
                    System.out.println("No hay libros prestados");
                }
                break;
            case 8:
                //Cargar lista completa libros
                resultado=estado.executeQuery("SELECT * FROM `libro`");
                while (resultado.next()){
                    System.out.println(resultado.getString("id")+"\t"+resultado.getString("name")
                            +"\t"+resultado.getString("autor")+"\t"+resultado.getString("Ano_publicacion")
                            +"\t"+resultado.getInt("Cantidad")+"\t"+resultado.getString("Area"));
                                        }
            break;
            case 9:
                ok=1;
                break;
            default:
                    System.out.println("Opción incorrecta");
                    break;
        }
        
        }while(ok!=1);
        
        
        
         /*   
        //Insertar un contacto
        System.out.println("Nombre: ");
        name=keyb.nextLine();
        System.out.println("Autor: ");
        autor=keyb.nextLine();
        System.out.println("Año de publicación: ");
        ypub=keyb.nextLine();
        System.out.println("Cantidad: ");
        cantidad=keyb.nextInt();
        keyb.nextLine();
        System.out.println("Area: ");
        area=keyb.nextLine();
        estado.executeUpdate("INSERT INTO `libro` VALUES (NULL, '"+name+"', '"+autor+"', '"+ypub+"', '"+cantidad+"', '"+area+"')");
        
        //estado.executeUpdate("INSERT INTO `libro` VALUES (NULL, '"+name+"', '"+autor+"', '"+ypub+"', '', '')");
        
        resultado=estado.executeQuery("SELECT * FROM `libro`");
        while (resultado.next()){
            System.out.println(resultado.getString("id")+"\t"+resultado.getString("name")
                    +"\t"+resultado.getString("autor")+"\t"+resultado.getString("Ano_publicacion")
                    +"\t"+resultado.getString("Cantidad")+"\t"+resultado.getString("Area"));
        }
        */
        }catch(SQLException ex){
            System.out.println("Error de mysql");
        }catch (Exception e){
            System.out.println("Se ha encontrado un error de tipo: "+e.getMessage());
        }
    }  
}
