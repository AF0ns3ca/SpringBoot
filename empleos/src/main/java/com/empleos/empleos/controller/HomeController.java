package com.empleos.empleos.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

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

}
