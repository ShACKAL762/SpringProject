package com.example.telegramBotTest;

import com.example.telegramBotTest.Other.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelegramBotTestApplication {
	private static final String BOT_TOKEN = "5643384053:AAEHHtVvom_72MU5wnX_KUqzW9HlvNDmrCE";

	public static void main(String[] args) {
		SpringApplication.run(TelegramBotTestApplication.class, args);


		Bot application = Bot.builder()
				.botToken(BOT_TOKEN)
				.build();

		application.run();


	}
}
