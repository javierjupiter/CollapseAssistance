import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BD_Consultas {
    private Estados[] estados;
    private int tamanioEstados;

    public boolean hacerConsultasEstados(Connection conn){
        try{
            ArrayList<Estados> listaEstados = new ArrayList<Estados>();
            Statement select = conn.createStatement();
            ResultSet resultadoConsulta = select.executeQuery(consultaEstados());

            while (resultadoConsulta.next()){
                Estados estado = new Estados(resultadoConsulta.getString(1), resultadoConsulta.getString(2));
                listaEstados.add(estado);
            }
            return convertirArray(listaEstados);

        }catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean convertirArray(ArrayList<Estados> arreglo){
        int contador = arreglo.size();
        this.tamanioEstados = contador;
        this.estados = new Estados[contador];
        for(int i=0; i<contador; i++){
            this.getEstados()[i] = arreglo.get(i);

        }
        return true;
    }





    public String consultaEstados(){
        String sql = "SELECT * FROM Estados_Pais ";
        return sql;
    }


    public String consultaMunicipios(int idEdo){
        String sql = "SELECT CONCAT(NIDMUNI,' ',Nombre_Municipio) "
                + " FROM Municipios_Estados "
                + " WHERE ID_Estado = " + idEdo
                + " ORDER BY ID_Municipios";
        return sql;
    }

    public Estados[] getEstados() {
        return estados;
    }

    public int getTamanioEstados() {
        return tamanioEstados;
    }
}
