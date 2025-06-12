package com.mohith;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TelegramBot extends TelegramLongPollingBot {

    public Set<Long> set = new HashSet<>();

    List<String> list = new ArrayList<>(
            List.of(
                    "Anvi's birthday is on 11-JAN 🎂",
                    "Nimmi's birthday is on 15-JAN 🎂",
                    "Inim's birthday is on 17-JAN 🎂",
                    "Sasi's birthday is on 01-FEB 🎂",
                    "Mohith's birthday is on 14-FEB 🎂",
                    "Deeru's birthday is on 23-MAR 🎂",
                    "Girisha's birthday is on 21-MAY 🎂",
                    "Nagesh's birthday is on 01-JUN 🎂",
                    "Manju's birthday is on 02-JUN 🎂",
                    "BabuRao's birthday is on 10-JUN 🎂",
                    "Chinni's birthday is on 26-JUN 🎂",
                    "Y.V.Ramana's birthday is on 01-JUL 🎂",
                    "SanyasiRao's birthday is on 01-JUL 🎂",
                    "Deepu's birthday is on 11-JUL 🎂",
                    "Shashank's birthday is on 02-JUL 🎂",
                    "Sowjanya's birthday is on 11-AUG 🎂",
                    "Eswarrao's birthday is on 03-AUG 🎂",
                    "Phani's birthday is on 15-AUG 🎂",
                    "Kusuma's birthday is on 31-AUG 🎂",
                    "Reyansh Anagh's birthday is on 03-SEP 🎂",
                    "Sasi Kala's birthday is on 11-SEP 🎂",
                    "Sai's birthday is on 21-SEP 🎂",
                    "Chandana's birthday is on 30-SEP 🎂",
                    "Bharathi's birthday is on 16-OCT 🎂",
                    "Geetha's birthday is on 18-OCT 🎂",
                    "Vara's birthday is on 17-NOV 🎂",
                    "Chaitu's birthday is on 20-NOV 🎂",
                    "Karthik's birthday is on 27-NOV 🎂"
            )
    );

    String dates = "1.Anvi\n2.Nimmi\n3.Innu\n4.Sasi\n5.Mohith\n6.Deeru\n7.Girisha\n8.Nagesh\n9.Manju\n10.BabuRao\n11.Chinni\n12.Y.V.Ramana\n13.SanyasiRao\n14.Deepu\n15.Shashank\n16.Sowjanya\n17.Eswarrao\n18.Phani\n19.Kusuma\n20.Reyansh Anagh\n21.Sasi Kala\n22.Sai\n23.Chandana\n24.Bharathi\n25.Geetha\n26.Vara\n27.Chaitu\n28.Karthik\nEnter the number corresponding to the name to know that persons birth-day!";

    @Override
    public String getBotUsername() {
        return "Birth_Day_Remainder_bot";
    }

    @Override
    public String getBotToken() {
        return "8192923123:AAEG2vtqb11PPqUhZxh1eORnJJCL0fftUdo";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = update.getMessage().getChatId();
        Message message = update.getMessage();
        String text = message.getText();
        if(!set.contains(chatId)) {
            sendText(chatId, dates);
            set.add(chatId);
            return;
        }
        int num;
        try{
            num = Integer.parseInt(text);
        } catch(NumberFormatException e){
            sendText(chatId,"Please enter a valid number");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException E) {
                throw new RuntimeException(E);
            }
            sendText(chatId,dates);
            return;
        }
        if(num > list.size()) {
            sendText(chatId,"Please enter a number in the range : 1-"+list.size());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sendText(chatId,dates);
        } else {
            sendText(chatId,list.get(num-1));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sendText(chatId,dates);
//            System.out.println(chatId);
        }
    }

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}