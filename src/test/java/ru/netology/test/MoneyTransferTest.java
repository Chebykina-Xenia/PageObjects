package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataUser;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {
    @BeforeEach
    public void setUp() {
        //открываем сайт
        open("http://localhost:9999/");
    }

    //заполняем все поля — успешное отправление формы
    @Test
    void shouldFormSentSuccessfully() {
        var loginPage = new LoginPage();
        int sumReplenishment = 5000;
        //переменная для хранения данных для авторизации
        var authoInfo = DataUser.getAuthorizationInfo();
        //логинимся
        var varificationPage = loginPage.validLogin(authoInfo);
        //вытаскиваем код верификации
        var verificationCode = DataUser.getVerificationCode();
        //переходим на страницу дашборд
        var dashboardPage = varificationPage.validVerify(verificationCode);
        //переходим на страницу пополнения 1 карты
        var cardReplenishmentPage = dashboardPage.amountCards(0);
        //вытаскиваем номер карты с которой списываем
        var card2 = DataUser.getFirstCard().getNumber();
        //определяем баланс на 2 карте
        var balance = dashboardPage.getCardBalance(1);
        //если баланс больше или равен сумме пополнения
        if (balance >= sumReplenishment){
        cardReplenishmentPage.card1Replenishment(card2, String.valueOf(sumReplenishment));
        }
    }
}
