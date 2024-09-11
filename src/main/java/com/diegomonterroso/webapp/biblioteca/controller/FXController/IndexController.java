package com.diegomonterroso.webapp.biblioteca.controller.FXController;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegomonterroso.webapp.biblioteca.model.Categoria;
import com.diegomonterroso.webapp.biblioteca.service.CategoriaService;
import com.diegomonterroso.webapp.biblioteca.system.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Setter;

@Component
public class IndexController implements Initializable {

    @Setter
    private Main stage;

    @FXML
    TextField tfId, tfNombre;

    @FXML
    Button btnGuardar, btnEliminar, btnLimpiar;

    @FXML
    TableView tblCategorias;

    @FXML
    TableColumn colId, colNombre;

    @Autowired
    CategoriaService categoriaService;

    // se ejecuta cada vez que inicio
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        cargarDatos();
    }

    // llena el tableView
    public void cargarDatos(){
        tblCategorias.getItems().clear();
        tblCategorias.setItems(listarCategorias());
        colId.setCellValueFactory(new PropertyValueFactory<Categoria, Long>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Categoria, String>("nombreCategoria"));
    }

    public ObservableList<Categoria> listarCategorias(){
        return FXCollections.observableArrayList(categoriaService.listarCategorias());
    }

}
