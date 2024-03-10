package br.com.gus.screenmatch;

import br.com.gus.screenmatch.model.DadosEpisodio;
import br.com.gus.screenmatch.model.DadosSerie;
import br.com.gus.screenmatch.model.DadosTemporada;
import br.com.gus.screenmatch.principal.Principal;
import br.com.gus.screenmatch.service.ConsumoApi;
import br.com.gus.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
