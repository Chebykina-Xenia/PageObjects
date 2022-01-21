package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataUser;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id='dashboard']");
    private SelenideElement headingAccount = $("[data-test-id='action-transfer']");

    private ElementsCollection cards = $$(".list__item");
    //кнопка пополнить (на странице при выборе карт)
    private ElementsCollection topAccount = $$("[data-test-id='action-deposit']");

    private final String balanceStart = ", баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage(){
        heading.shouldBe(visible);
    }

    public int getCardBalance(int index) {
        val text = cards.get(index).getText();
        int cardBalance = extractBalance(text);
        return cardBalance;
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    //переходим на страницу пополнения (смотрим по индексу 0-первая карта, 2-вторая карта)
     public CardReplenishmentPage amountCards(int index){
       topAccount.get(index).click();
       return new CardReplenishmentPage();
     }

}