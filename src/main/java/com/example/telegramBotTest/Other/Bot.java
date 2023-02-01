package com.example.telegramBotTest.Other;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.io.IOException;


public class Bot extends TelegramBot {

    @lombok.Builder
    public Bot(String botToken) {
        super(botToken);
    }
    public void run() {

        this.setUpdatesListener(update -> {
            update.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;

        });


    }
    private void process(Update update) {
        String text = update.message().text();


        if (text == null) throw new NullPointerException();
        try {
            this.serveCommand(text, update.message().chat().id());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serveCommand(String message, Long chatId) throws IOException {
        if (message.equals("start"))
            this.execute(new SendMessage(chatId, "It's Alive!"));
    }
    }




