package com.example.q2mmn14;


import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.HashMap;

public class RemController {
    private HashMap<Date, String> hashMap;

    @FXML
    private VBox vboxid;

    @FXML
    private ComboBox<String> dayid;

    @FXML
    private ComboBox<String> monthid;

    @FXML
    private ComboBox<String> yearid;

    @FXML
    private TextArea textArea;

    @FXML
    void getNotePressed(ActionEvent event) {
        textArea.setText(hashMap.get(getThisDate()));
    }

    @FXML
    void saveNotePressed(ActionEvent event) {
        hashMap.put(getThisDate(),textArea.getText());
        addClosingEvent();
    }

    private Date getThisDate(){
        int day = Integer.parseInt(dayid.getValue());
        int month =Integer.parseInt(monthid.getValue());
        int year = Integer.parseInt(yearid.getValue());
        Date date = new Date(day,month,year);
        return date;
    }

    public void initialize(){
    setComobox();
    hashMap=new HashMap<Date,String>();
    loadFile();

    }

    public void setComobox(){
        final int DAYS =31, MONTH = 12, START_YEAR = 2000 ,END_YEAR=2025;
        for(int i =1; i<=DAYS;i++) {
            dayid.getItems().add(i + "");
            dayid.setValue(DAYS + "");
        }
        for(int i =1; i<=MONTH;i++) {
            monthid.getItems().add(i + "");
            monthid.setValue(MONTH + "");
        }
        for(int i =START_YEAR; i<=END_YEAR;i++) {
            yearid.getItems().add(i + "");
            yearid.setValue(START_YEAR+"");
        }
    }


    public void loadFile(){
    File file =getFile();
    try{
        FileInputStream fi =new FileInputStream(file);
        ObjectInputStream ois =new ObjectInputStream(fi);
        hashMap = (HashMap<Date, String>)ois.readObject();
        ois.close();
        fi.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e){
        e.printStackTrace();
    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }
    }

    public void saveFile(){
        File file = getFile();
        FileOutputStream fo;
        try {
            fo = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fo);
            out.writeObject(hashMap);
            out.close();
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addClosingEvent(){
        Stage stage = (Stage)((Node)vboxid).getScene().getWindow();
        stage.getScene().getWindow().addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST,event1 ->
            {
            saveFile();
            });
    }

    public File getFile(){
        FileChooser file = new FileChooser();
        file.setTitle("Select file");
        file.setInitialDirectory(new File("."));
        return file.showOpenDialog(null);
    }
}