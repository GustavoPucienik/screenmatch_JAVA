package br.com.gus.screenmatch.principal;

import br.com.gus.screenmatch.model.DadosEpisodio;
import br.com.gus.screenmatch.model.DadosSerie;
import br.com.gus.screenmatch.model.DadosTemporada;
import br.com.gus.screenmatch.service.ConsumoApi;
import br.com.gus.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
  private Scanner leitura = new Scanner(System.in);
  private ConsumoApi consumo = new ConsumoApi();
  private ConverteDados conversor = new ConverteDados();
  private final String ENDERECO = "https://omdbapi.com/?t=";
  private final String API_KEY = "&apikey=3bf61f2b";
  public void exibeMenu() {
    System.out.println("Digite o nome da série para pesquisar");
    var nomeserie = leitura.nextLine();
    var json = consumo.obterDados(ENDERECO + nomeserie.replace(" ", "+") + API_KEY);
    DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
    System.out.println(dados);

	List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.TotalTemporadas(); i++) {
			json = consumo.obterDados(ENDERECO + nomeserie.replace(" ", "+") + "&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

//    for (int i = 0; i < dados.TotalTemporadas(); i++) {
//      List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//      System.out.println("Temporada: " + i);
//      for (int j = 0; j < episodiosTemporada.size(); j++) {
//        System.out.println(episodiosTemporada.get(j).titulo());
//      }
//    }

    temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
    temporadas.forEach(System.out::println);

  }
}
