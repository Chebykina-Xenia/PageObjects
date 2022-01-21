package ru.netology.page;

import static com.codeborne.selenide.Selenide.$;

//страница пополнения карты
public class CardReplenishmentPage {

    //пополнение первой карты
    public DashboardPage card1Replenishment(String numberCardsUser, String sum) {
        //вытаскиваем номер карты с которой списываем
        $(".input[data-test-id='amount']").click();
        $(".input[data-test-id='amount'] [class='input__control']").setValue(sum);
        $(".input[data-test-id='from']").click();
        $(".input[data-test-id='from'] [class='input__control']").setValue(numberCardsUser);
        $("[data-test-id='action-transfer']").click();
        return new DashboardPage();
    }


}
