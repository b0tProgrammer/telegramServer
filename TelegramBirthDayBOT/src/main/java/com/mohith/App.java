package com.mohith;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            TelegramBot tb = new TelegramBot();
            botsApi.registerBot(tb);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}