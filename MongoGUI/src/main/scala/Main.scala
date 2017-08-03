import scalafx.application.JFXApp
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.text.Font
import scalafx.scene.control.{Button, Label, TextField}


object MpgTool extends JFXApp {
  //val app = new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "MPG Tool"
      scene = new Scene(400,400) {

        val label = new Label("MPG Calculator")
        label.layoutX = 130
        label.layoutY = 20
        label.setFont(Font.font("Arial", 20))

        val label2 = new Label("AVG: ")
        label2.layoutX = 30
        label2.layoutY = 65

        val label3 = new Label("xxx")
        label3.layoutX = 70
        label3.layoutY = 65

        val label4 = new Label("MAX: ")
        label4.layoutX = 140
        label4.layoutY = 65

        val label5 = new Label("xxx")
        label5.layoutX = 180
        label5.layoutY = 65

        val label6 = new Label("MIN: ")
        label6.layoutX = 220
        label6.layoutY = 65

        val label7 = new Label("xxx")
        label7.layoutX = 250
        label7.layoutY = 65

        val text1 = new TextField
        text1.layoutX = 30
        text1.layoutY = 150
        text1.promptText = "Enter Miles"

        val text2 = new TextField
        text2.layoutX = 210
        text2.layoutY = 150
        text2.promptText = "Litres Fuel"

        val button = new Button("Save")
        button.layoutX = 150
        button.layoutY = 250

        val button2 = new Button("Update")
        button2.layoutX = 150
        button2.layoutY = 320

        content = List(label, label2, label3, label4, label5, label6, label7, button, button2, text1, text2)

        button.onAction = (e: ActionEvent) => {
              val record = MilesPG(getMiles(), getFuel())
              Insert.saveMPG(record)

        }
        button2.onAction = (e: ActionEvent) => {
          Insert.getMPG
        }

        def getMiles(): Double = {
          return text1.getText.toDouble
        }
        def getFuel(): Double = {
          return text2.getText.toDouble
        }
     // }
    }
  }

}