# myTelegramBot
This is test telegram bot as a pet project

- [App home page]()
- [Swagger docs]()
- [App API base path]()
- [App info]()
- [App sources](https://github.com/VaolEr/myTelegramBot)
### App paths for interact with bots
- `/api/v1/telegram-bots`/...

### Telegram bot settings for test app:
1. Using `ngrok` redirect Yours `localhost:your_port` to public `https:\\...`
2. Setup bot's webhook using: 
   * `https://api.telegram.org/bot[bot_token]/setWebhook?url=[ngrok_address]/api/v1/telegram-bots/yookassa-payment-bot`
3. Check bot settings using: 
   * `https://api.telegram.org/bot[bot_token]/getWebhookInfo`

### For correct work You need to create application-botsData.properties file with next fields:
- echoBotToken = Your echo bot telegram token
- echoBotUsername = Your echo bot telegram username
####
- commandTestBotToken = Your command test bot telegram token
- commandTestBotUsername = Your command test bot telegram username
####
- paymentYookassaWebhookBotToken = Your payment Yookassa bot telegram token
- paymentYookassaWebhookBotUsername = Your payment Yookassa bot telegram username
- paymentYookassaWebhookBotPath = webhook path

#### v0.0.2
- Add unit tests for `CommandTesterBot` and it's classes;
- Created `PaymentYookassaWebhookBot` telegram bot:
    - Realised WebHookController with next methods:
        - POST `/yookassa-payment-bot`;
    
#### v0.0.1
- Created `EchoBot` telegram bot;
- Created `CommandTesterBot` telegram bot;