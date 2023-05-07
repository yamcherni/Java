/**@Author Yam Chernichovsky 327484085
 * @version 26.4.2023
 * used sets to check the matrix.
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import java.util.HashSet;
import java.util.Set;

public class SudokuController {
    final int SIZE = 9;
    private TextField[][] btns;
    Set <TextField> checkedBtns = new HashSet<>();
    Set<String> set = new HashSet<>();
    @FXML
    private GridPane gridid;

    @FXML
    void clearPressed(ActionEvent event) {
        System.out.println("clear pressed");
        checkedBtns.clear();
        initialize();
    }

    @FXML
    void setPressed(ActionEvent event) {
        for (TextField btn :checkedBtns) {
            btn.setEditable(false);
            btn.setStyle("-fx-text-fill: blue;");
        }
    }

    @FXML
    public void initialize() {
        btns = new TextField[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {       //i- row  j-cal
            for (int j = 0; j < SIZE; j++) {
                btns[i][j] = new TextField();
                btns[i][j].setAlignment(Pos.CENTER);
                btns[i][j].setPrefSize(gridid.getPrefWidth() / SIZE, gridid.getPrefHeight() / SIZE);
                gridid.add(btns[i][j], j, i);
                btns[i][j].setOnKeyPressed(
                        (keyEvent) -> handleKeyEvent(keyEvent)
                );
            }
        }
    }

    public void handleKeyEvent(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            String s = findButtonLocation(event);
            int row = Integer.parseInt(String.valueOf(s.charAt(0)));
            int cal = Integer.parseInt(String.valueOf(s.charAt(1)));
            if (validRow(row) && validCal(cal) && validInt(btns[row][cal].getText()) &&validMiniMatrix(row,cal)) {//check all
                System.out.println("valid");
                checkedBtns.add(btns[row][cal]);
            }
            else {
                btns[row][cal].setText("");
            }
            }
        }

    public void alert(String message) {
        Alert a = new Alert(Alert.AlertType.ERROR, message);
        a.showAndWait();
    }

    private String findButtonLocation(KeyEvent event) {
        String t = event.getSource().toString().substring(0, 18);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                String s = btns[i][j].onKeyPressedProperty().toString();
                if (s.contains(t)) {
                    return i + "" + j;
                }
            }
        }
        return "-";
    } //find what is the button of the event

    public boolean validInt(String t) {
        try {
            int intValue = Integer.parseInt(t);
            if (intValue > 0 && intValue <= 9)
                return true;
            else
                alert("only bumbers from 1 to 9 aloud");
        } catch (NumberFormatException e) {
            alert("Only integer values aloud");
            return false;
        }
        return false;
    } //check that it is valid number

    public boolean validRow(int row) {
        for (int i = 0; i < SIZE; i++) {
            String tmp = btns[row][i].getText();
            if (!tmp.equals("")) {
                if (set.contains(tmp)) {
                    set.clear();
                    alert("bad choice, check row");
                    return false;
                } else
                    set.add(btns[row][i].getText());
            }
        }
        set.clear();
        return true;
    } //row check

    public boolean validCal(int cal) {
        for (int i = 0; i < SIZE; i++) {
            String tmp = btns[i][cal].getText();
            if (!tmp.equals("")) {
                if (set.contains(tmp)) {
                    set.clear();
                    alert("bad choice, check column");
                    return false;
                } else
                    set.add(btns[i][cal].getText());
            }
        }
        set.clear();
        return true;
    }//callomn check

    public boolean validMiniMatrix (int row,int col){
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for (int i = startRow;i<startRow+3;i++){
            for(int j =startCol;j<startCol+3;j++)
            {
                String tmp = btns[i][j].getText();
                if (!tmp.equals("")) {
                    if (set.contains(tmp)) {
                        set.clear();
                        alert("bad choice, check inner matrix");
                        return false;
                    } else
                        set.add(btns[i][j].getText());
                }
            }
            }
        set.clear();
        return true;
    } //check the inner matrix

}
