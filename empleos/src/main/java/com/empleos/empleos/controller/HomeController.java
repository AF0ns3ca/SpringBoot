package com.empleos.empleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.empleos.empleos.model.Vacante;




@Controller
public class HomeController {

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = getVacantes();
        model.addAttribute("tabla", lista);
        return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de Comunicaciones");
        vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(1050.0);

        model.addAttribute("vacante", vacante);

        return "detalle";
    }

    //Metodo que pasa una lista para ser visualizada en la vista listado.html
    @GetMapping("/listado")
    public String mostrarListado(Model model){
        List<String> lista = new LinkedList<>();
        lista.add("Ingeniero de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");

        model.addAttribute("empleos", lista);

        return "listado";

    }

    @GetMapping("/")
    public String mostrarHome(Model model) {
        //Forma de añadir atributos al modelo por thymeleaf
        // model.addAttribute("mensaje", "Hola Mundo");
        // model.addAttribute("fecha", new Date());

        String nombre = "Auxiliar de Contabilidad";
        Date fechaPub = new Date();
        double salario = 1100;
        boolean vigente = true;

        model.addAttribute("nombre", nombre);
        model.addAttribute("fechaPub", fechaPub);   
        model.addAttribute("salario", salario);
        model.addAttribute("vigente", vigente);

        return "home";
    }
    
	/**
	 * Método que regresa una lista de objetos de tipo Vacante
	 * @return
	 */
	private List<Vacante> getVacantes() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		try {
			// Creamos la oferta de Trabajo 1.
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil"); // Titulo de la vacante
			vacante1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal.");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(8500.0);
			// vacante1.setDestacado(1);
			// vacante1.setImagen("empresa1.png");
						
			// Creamos la oferta de Trabajo 2.
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico");
			vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia titulado.");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(12000.0);
			// vacante2.setDestacado(0);
			// vacante2.setImagen("empresa2.png");
			
			// Creamos la oferta de Trabajo 3.
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Eléctrico");
			vacante3.setDescripcion("Empresa internacional solicita Ingeniero mecánico para mantenimiento de la instalación eléctrica.");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			// vacante3.setSalario(10500.0);
			// vacante3.setDestacado(0);
			
			// Creamos la oferta de Trabajo 4.
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador Gráfico");
			vacante4.setDescripcion("Solicitamos Diseñador Gráfico titulado para diseñar publicidad de la empresa.");
			vacante4.setFecha(sdf.parse("11-02-2019"));
			vacante4.setSalario(7500.0);
			// vacante4.setDestacado(1);
			// vacante4.setImagen("empresa3.png");
			
			/**
			 * Agregamos los 4 objetos de tipo Vacante a la lista ...
			 */
			lista.add(vacante1);			
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lista;

	}

}
