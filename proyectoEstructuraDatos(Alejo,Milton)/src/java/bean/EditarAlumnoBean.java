/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dbAction.ActualizarAlumnoDbAction;
import dbAction.RegistroAlumnoDbAction;
import java.text.ParseException;
import utils.Mensajes;

/**
 *
 * @author m!lton
 */
class EditarAlumnoBean {



    EditarAlumnoBean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public String regresarMenu(){
        return "regresarMenu";
    }
  
      
          public void consultarAlumno(){

        if(this.getCarnet().equals("")){
            Mensajes.errorMessage("Advertencia", "Debe ingresar el codigo del docente");
        }
        else{
            String carnet = this.getCarnet();
            ActualizarAlumnoDbAction consulta = new ActualizarAlumnoDbAction();
            docente = consulta.consultarDocente(carnet);
            if(docente != null){
                this.setNombre(docente.getNombre());
                this.setApellido(docente.getApellido());
                this.setDpi(docente.getDpi());
                this.setTelefono(docente.getTelefono());
                this.setCorreo(docente.getCorreo());
                this.setDireccion(docente.getDireccion());
                this.setFechaNacimiento(docente.getFechaNacimiento());
                this.setIdStatus(docente.getIdStatus());

            }
            else{
                Mensajes.errorMessage("Error", "Docente no encontrado");
            }
        }
    }

    
    
}
