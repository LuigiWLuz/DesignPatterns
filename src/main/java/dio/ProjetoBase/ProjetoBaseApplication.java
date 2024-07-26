package dio.ProjetoBase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class ProjetoBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBaseApplication.class, args);
	}

}
