package com.kcj.randomjokes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class RandomJokesApplication {
	private static final Logger log = LoggerFactory.getLogger(RandomJokesApplication.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Scheduled(fixedRate = 3000)
	public void runEveryThreeSeconds() {
		RestTemplate restTemplate = new RestTemplate();
		Joke joke = restTemplate.getForObject("https://api.chucknorris.io/jokes/random", Joke.class);
		log.info("The time is now {}", dateFormat.format(new Date()));
		log.info(joke.toString());
	}


	@Bean
	public CommandLineRunner run() throws Exception{
		return args -> runEveryThreeSeconds();
	}
	public static void main(String[] args) {
		SpringApplication.run(RandomJokesApplication.class, args);
	}

}
