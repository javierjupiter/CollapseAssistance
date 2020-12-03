
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.HBox;
public class Tabla
{

  private ObservableList<Asistencia> asistenciaObservableList= FXCollections.observableArrayList();
  private JFXTreeTableView<Asistencia> asistenciaJFXTreeTableView;
  public Tabla(JFXTreeTableView<Asistencia> asistenciaTabla)
  {
      this.asistenciaJFXTreeTableView = asistenciaTabla;

      JFXTreeTableColumn<Asistencia, String> claveColumn =new JFXTreeTableColumn<>("Clave");

      claveColumn.setPrefWidth(10);

      claveColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Asistencia,String> param)->{
          if(claveColumn.validateValue(param)) return param.getValue().getValue().claveProperty();
          else return claveColumn.getComputedValue(param);

      });

      final TreeItem<Asistencia> root = new RecursiveTreeItem<Asistencia>(asistenciaObservableList, RecursiveTreeObject::getChildren);

      this.asistenciaJFXTreeTableView.setRoot(root);
      this.asistenciaJFXTreeTableView.setShowRoot(false);
      this.asistenciaJFXTreeTableView.setEditable(false);

      this.asistenciaJFXTreeTableView.getColumns().setAll(claveColumn);

  }

}