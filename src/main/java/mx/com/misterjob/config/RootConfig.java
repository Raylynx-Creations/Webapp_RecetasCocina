package mx.com.misterjob.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages= {"mx.com.misterjob"}, //PAQUETE PRINCIPAL EN DONDE SPRING BUSCARA NUESTRAS CLASES CON ANOTACIONES
excludeFilters={
	@ComponentScan.Filter(type= FilterType.ANNOTATION, value= EnableWebMvc.class) 
})//FILTRO PARA SPRING TOME AQUELLAS CLASES QUE LLEVEN ANOTACIONES O LA ANOTACION @EnableWebMvc
public class RootConfig {}
