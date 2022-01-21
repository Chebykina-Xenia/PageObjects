package ru.netology.page;

import ru.netology.data.DataUser;

import static com.codeborne.selenide.Selenide.$;

//страница пополнения карты
public class CardReplenishmentPage {

    //перевод с первой карты на вторую
    public DashboardPage card1Replenishment(String numberCardsUser, String sum){
        $(".input[data-test-id='amount']").click();
        $(".input[data-test-id='amount'] [class='input__control']").setValue(sum);
        $(".input[data-test-id='from']").click();
        $(".input[data-test-id='from'] [class='input__control']").setValue(numberCardsUser);
        $("[data-test-id='action-transfer']").click();
        return new DashboardPage();
    }

}
