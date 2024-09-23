package com.example.demo2;
import org.springframework.core.env.Environment;
//import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);

		}
	@Component
	class AppCnfig
	{
		@Value("${spring.application.name}")
		private String name;
		public void printCnfig() {
			System.out.println("App Name: " + name);
		}
		@Autowired
		private Environment env;

		public void printCnfig()
		{
			String name=env.getProperty("spring.application.name");
			System.out.println("App Name: " + name);
		}

	}
	@Component
	class StartupRunner implements CommandLineRunner {

		private final AppCnfig appConfig;

		@Autowired
		public StartupRunner(AppCnfig appConfig) {
			this.appConfig = appConfig;
		}

		@Override
		public void run(String... args) throws Exception {
			appConfig.printCnfig();
		}
	}

}
