package br.com.ivanfsilva.libraryapi;

import br.com.ivanfsilva.libraryapi.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class LibraryApiApplication {

	@Autowired
	private EmailService emailService;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			List<String> emails = Arrays.asList("42f7c5e873-d62d11@inbox.mailtrap.io");
			emailService.sendMails("Testando serviço de emails.", emails);
			System.out.println("EMAILS ENVIADOS");
		};
	}

//	@Scheduled(cron = "0 31 16 1/1 * ?")
//	public void testeAgendamentoTarefas() {
//		System.out.println(" AGENDAMENTO DE TAREFAS FUNCIONANDO COM SUCESSO ");
//	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApiApplication.class, args);
	}

}
