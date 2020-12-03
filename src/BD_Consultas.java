import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BD_Consultas {
    private Estados[] estados;
    private int tamanioEstados;

    public Municipios[] getMunicipios() {
        return municipios;
    }
    public int getTamnnioMunicipios() {
        return tamnnioMunicipios;
    }

    private Municipios[] municipios;
    private int tamnnioMunicipios;

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

    public boolean convertirArrayM(ArrayList<Municipios> arreglo){
        int contador = arreglo.size();
        this.tamnnioMunicipios = contador;
        this.municipios = new Municipios[contador];
        for (int i = 0; i < contador; i++){
            this.getMunicipios()[i] = arreglo.get(i);
        }
        return true;
    }

    public boolean hacerConsultasMunicipios(Connection conn, int idEstado){
        try{
            ArrayList<Municipios> listaMunicipios = new ArrayList<Municipios>();
            Statement select = conn.createStatement();
            ResultSet resultadoConsulta = select.executeQuery(consultaMunicipios(idEstado));

            while (resultadoConsulta.next()){
                Municipios municipios = new Municipios(resultadoConsulta.getString(1), resultadoConsulta.getString(2), resultadoConsulta.getString(3));
                listaMunicipios.add(municipios);
            }
            return convertirArrayM(listaMunicipios);

        }catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public String hacerConsultasMunicipiosID(Connection conn, String nombre){
        try{
            String id = "";
            Statement select = conn.createStatement();
            ResultSet resultadoConsulta = select.executeQuery(consultaNombreMunicipio(nombre));

            while (resultadoConsulta.next()){
                id = resultadoConsulta.getString(1);
            }
            return id;

        }catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }



    public String consultaEstados(){
        String sql = "SELECT * FROM Estados_Pais ";
        return sql;
    }


    public String consultaMunicipios(int idEdo){
        String sql = "SELECT * FROM municipios_estados WHERE id_estado = " + idEdo;
        return sql;
    }

    public String consultaNombreMunicipio(String nombre){
        String sql = "SELECT ID_Municipios FROM municipios_estados WHERE Nombre_municipio = '" + nombre + "'";
        return sql;
    }

    public Estados[] getEstados() {
        return estados;
    }

    public int getTamanioEstados() {
        return tamanioEstados;
    }
}
