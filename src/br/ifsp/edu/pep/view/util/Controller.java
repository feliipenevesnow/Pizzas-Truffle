package br.ifsp.edu.pep.view.util;

import br.ifsp.edu.pep.view.component.Menu;
import br.ifsp.edu.pep.view.form.BuyReport;
import br.ifsp.edu.pep.view.form.CashRegister;
import br.ifsp.edu.pep.view.form.CashRegisterReport;
import br.ifsp.edu.pep.view.form.DeliveryReport;
import br.ifsp.edu.pep.view.form.Drink;
import br.ifsp.edu.pep.view.form.Form_Home;
import br.ifsp.edu.pep.view.form.PizzaMaker;
import br.ifsp.edu.pep.view.form.SaleReport;

public class Controller {

    public static CashRegisterReport cashReport;
    public static DeliveryReport deliveryReport;
    public static SaleReport saleReport;
    public static BuyReport buyReport;
    public static Form_Home dashboard;
    public static PizzaMaker pizzaMaker;
    public static Drink drink;
    public static CashRegister cash;
    public static Menu menu;

    public Controller(Form_Home dashboard, PizzaMaker pizzaMaker, Drink drink, CashRegister cash, Menu menu, CashRegisterReport cashReport, DeliveryReport deliveryReport, SaleReport saleReport, BuyReport buyReport) {
        this.cashReport = cashReport;
        this.deliveryReport = deliveryReport;
        this.saleReport = saleReport;
        this.buyReport = buyReport;
        this.dashboard = dashboard;
        this.pizzaMaker = pizzaMaker;
        this.drink = drink;
        this.cash = cash;
        this.menu = menu;
    }
}
