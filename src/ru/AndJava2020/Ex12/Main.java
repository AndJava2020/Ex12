package ru.AndJava2020.Ex12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



enum Planet{
    VENUS(4.8,6052),EARTH(6,6371),MARS(0.64,3390),JUPITER(1898,69910);
    private final double mass;
    private final double radius;
    Planet(double mass, double radius){
        this.mass = mass;
        this.radius = radius;
    }
    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }
}

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();
        Scene scene = new Scene(group,1000,500);

        MenuBar menu= new MenuBar();
        Menu planets=new Menu("select planet");
        MenuItem itemsOfMenu[]=new MenuItem[]{
                new MenuItem(Planet.VENUS.toString()),
                new MenuItem(Planet.EARTH.toString()),
                new MenuItem(Planet.MARS.toString()),
                new MenuItem(Planet.JUPITER.toString())
        };

        Text txt=new Text("");
        txt.setLayoutY(50);

        for (MenuItem t: itemsOfMenu
        ) {
            planets.getItems().add(t);
            t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Planet g=Planet.valueOf(t.getText());
                    txt.setText("Planet: " + g.toString() + " radius: " + g.getRadius() +" mass: " + g.getMass()+"g: "+(6.675*10000000*g.getMass()/(g.getRadius()*g.getRadius())));

                }
            });
        }
        menu.getMenus().add(planets);
        BorderPane menuPane=new BorderPane();
        menuPane.setTop(menu);

        group.getChildren().addAll(menuPane,txt);
        primaryStage.setTitle("Enum");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
