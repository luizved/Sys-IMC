package org.sysimc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.sysimc.model.Pessoa;

import java.text.DecimalFormat;

public class MainController {
    @FXML
    public TextField txtNome;

    @FXML
    public TextField txtAltura;

    @FXML
    public TextField txtPeso;

    @FXML
    public Label lbIMC;

    @FXML
    public Label lbClassificacao;

    Pessoa pessoa = new Pessoa();

    @FXML
    protected void onCalcularIMCClick() {
        DecimalFormat df = new DecimalFormat();
        this.pessoa.setNome(this.txtNome.getText());
        this.pessoa.setAltura(Float.parseFloat(this.txtAltura.getText()) );
        this.pessoa.setPeso(Float.parseFloat(this.txtPeso.getText()) );

        double imc = this.pessoa.getPeso() / (this.pessoa.getAltura() * this.pessoa.getAltura());
        df.applyPattern("#,##0.00");
        this.lbIMC.setText(df.format(imc).replace('.', ','));

        this.lbClassificacao.setText(this.pessoa.Classificacaoimc());

        this.pessoa.setImc((float) imc);
        this.lbClassificacao.setText(this.pessoa.Classificacaoimc());
    }
}