package com.example.opt3.Controller;

import com.example.opt3.Model.ResourceLoader;
import com.example.opt3.Model.users.Babies;
import com.example.opt3.Model.users.Gastouder;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.utils.others.FunctionalStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import java.io.IOException;

public class OverzichtController {
    @FXML
    private Label bedrijfnaam;
    @FXML
    private Label straatnaam;
    @FXML
    private Label huisnummer;
    @FXML
    private Label postcode;
    @FXML
    private Label aantalkinderen;
    @FXML
    private MFXListView<Babies> allekinderen;
    private ObservableList<Babies> people;


    public void onDIsplayButton(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Gastouder gastouder = (Gastouder) stage.getUserData();

        this.people = FXCollections.observableArrayList();
        this.people.addAll(gastouder.getPeople());

        StringConverter<Babies> converter = FunctionalStringConverter.to(Babies -> (Babies == null) ? "" : Babies.getNaam());

        allekinderen.setItems(people);
        allekinderen.setConverter(converter);

        bedrijfnaam.setText(gastouder.getName());
        straatnaam.setText(gastouder.getAdres().getStraatnaam());
        huisnummer.setText(String.valueOf(gastouder.getAdres().getHuisnummer()));
        postcode.setText(gastouder.getAdres().getPostcode());
        aantalkinderen.setText(String.valueOf(gastouder.getPeople().size()));
    }

    public void onEditButton(ActionEvent event) throws IOException {
        ResourceLoader.changeScene(event,"fxml/UserEdit-view.fxml");
    }
}
