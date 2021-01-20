import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.temporal.Temporal;
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

    private  String[] Temporal;
    public String[] getTemporal(){return Temporal;}

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
                Municipios municipios = new Municipios(resultadoConsulta.getString(1), resultadoConsulta.getString(3), resultadoConsulta.getString(2));
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
        String sql = "SELECT * FROM cestads ";
        return sql;
    }


    public String consultaMunicipios(int idEdo){
        String sql = "SELECT * FROM cmunics WHERE NIDESTA = " + idEdo;
        return sql;
    }

    public String consultaNombreMunicipio(String nombre){
        String sql = "SELECT NIDMUNI FROM cmunics WHERE CNOMMUN = '" + nombre + "'";
        return sql;
    }

    public Estados[] getEstados() {
        return estados;
    }

    public int getTamanioEstados() {
        return tamanioEstados;
    }

    public boolean consultaJustificantes (Connection conn,String IDJustificante){
        try{
            Temporal = new String[2];
            Statement select = conn.createStatement();
            ResultSet resultado = select.executeQuery(generarQueryJustificantes(IDJustificante));

            Temporal[0] = resultado.getString(1);
            Temporal[1] = resultado.getString(2);
            return true;
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }
    public String generarQueryJustificantes(String IDJustificantes) {
        String sql = ("select cdesjus, cstatus from cjusasi where nidtpju = " + IDJustificantes);
        return sql;}

    public boolean consultaHorario (Connection conn,String IDHorario){
        try{
            Temporal = new String[5];
            Statement select = conn.createStatement();
            ResultSet resultado = select.executeQuery(generarQueryHorarios(IDHorario));

            Temporal[0] = resultado.getString(1);
            Temporal[4] = resultado.getString(2);

            System.out.println("consulta a horarios listo ");
            resultado = select.executeQuery(generarQueryHorariosDetalle(IDHorario));
            Temporal[1] = resultado.getString(1);
            Temporal[2] = resultado.getString(2);
            Temporal[3] = resultado.getString(3);

            System.out.println("consulta a horarios detalle listo ");
            return true;
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }
    public String generarQueryHorarios(String IDHorario) {
        String sql = ("select cdeschr, cstatus from chorars where nidora = " + IDHorario);
        return sql;}


    public String generarQueryHorariosDetalle(String IDHorario) {
        String sql = ("select ndiasem, chorent, chorsal from ddethor where nidora = " + IDHorario);
        return sql;}


    public boolean consultaHorarioClaveE (Connection conn,String ClaveDeEmpleado){
        try{
            Temporal = new String[3];
            Statement select = conn.createStatement();
            ResultSet resultado = select.executeQuery(generarQueryHorarioClaveE(ClaveDeEmpleado));

            Temporal[0] = resultado.getString(1);
            Temporal[1] = resultado.getString(2);

            System.out.println("consulta a horarios listo ");
            resultado = select.executeQuery(generarQueryHorarioClaveEDetalle(ClaveDeEmpleado));
            Temporal[2] = resultado.getString(3);

            System.out.println("consulta a horarios detalle listo ");
            return true;
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }
    public String generarQueryHorarioClaveE(String ClaveDeEmpleado) {
        String sql = ("select cnombre, cape1, cape2 from ddatemp where ccveemp = " + ClaveDeEmpleado);
        return sql;}


    public String generarQueryHorarioClaveEDetalle(String ClaveDeEmpleado) {
        String sql = ("select dfecasi from dhremps where ccveemp = " + ClaveDeEmpleado);
        return sql;}





    public boolean consultaClaveDeEmpleadoAH (Connection conn,String ClaveDeEmpleadoAH){
        try{
            Temporal = new String[6];
            Statement select = conn.createStatement();
            ResultSet resultado = select.executeQuery(generarQueryHorarioClaveDeHorario(ClaveDeEmpleadoAH));

            Temporal[0] = resultado.getString(1);
            Temporal[1] = resultado.getString(2);

            System.out.println("consulta a horarios listo ");

            resultado = select.executeQuery(generarQueryHorarioClaveDeHorarioDetalle1(ClaveDeEmpleadoAH));
            Temporal[2] = resultado.getString(3);
            Temporal[3] = resultado.getString(4);

            resultado = select.executeQuery(generarQueryHorarioClaveDeHorarioDetalle2(ClaveDeEmpleadoAH));
            Temporal[4] = resultado.getString(5);


            resultado = select.executeQuery(generarQueryHorarioClaveDeHorarioDetalle3(ClaveDeEmpleadoAH));
            Temporal[5] = resultado.getString(6);

            System.out.println("consulta a horarios detalle listo ");
            return true;
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }
    public String generarQueryHorarioClaveDeEmpleadoAH(String ClaveDeEmpleadoAH) {
        String sql = ("select cnombre, capeuno, capedos from ddatemp where ccveemp = " + ClaveDeEmpleadoAH);
        return sql;}

    public String generarQueryHorarioClaveDeEmpleadoAHDetalle1(String ClaveDeEmpleadoAH){
        String sql = ("select chorent, chorsal from ddethor where NIDHORA = (select nidhora from dhremps where ccveemp = " + ClaveDeEmpleadoAH);
        return sql;}

    public String generarQueryHorarioClaveDeEmpleadoAHDetalle2(String ClaveDeEmpleadoAH) {
        String sql = ("select cdeschr from chorars where NIDHORA = (select nidhora from dhremps where ccveemp = " + ClaveDeEmpleadoAH);
        return sql;}


    public String generarQueryHorarioClaveDeEmpleadoAHDetalle3(String ClaveDeEmpleadoAH) {
        String sql = ("select dfecasi from dhremps where ccveemp =" + ClaveDeEmpleadoAH);
        return sql;}



    public boolean consultaClaveDeHorario (Connection conn,String ClaveDeHorario){
        try{
            Temporal = new String[6];
            Statement select = conn.createStatement();
            ResultSet resultado = select.executeQuery(generarQueryHorarioClaveDeHorario(ClaveDeHorario));

            Temporal[0] = resultado.getString(1);
            Temporal[1] = resultado.getString(2);

            System.out.println("consulta a horarios listo ");

            resultado = select.executeQuery(generarQueryHorarioClaveDeHorarioDetalle1(ClaveDeHorario));
            Temporal[2] = resultado.getString(3);
            Temporal[3] = resultado.getString(4);

            resultado = select.executeQuery(generarQueryHorarioClaveDeHorarioDetalle2(ClaveDeHorario));
            Temporal[4] = resultado.getString(5);


            resultado = select.executeQuery(generarQueryHorarioClaveDeHorarioDetalle3(ClaveDeHorario));
            Temporal[5] = resultado.getString(6);

            System.out.println("consulta a horarios detalle listo ");
            return true;
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }
    public String generarQueryHorarioClaveDeHorario(String ClaveDeHorario) {
        String sql = ("select cnombre, capeuno, capedos from ddatemp where ccveemp = (select ccveemp from ddatemp where nidhora = " + ClaveDeHorario);
        return sql;}

    public String generarQueryHorarioClaveDeHorarioDetalle1(String ClaveDeHorario){
        String sql = ("select chorent, chorsal from ddethor where NIDHORA = " + ClaveDeHorario);
        return sql;}

    public String generarQueryHorarioClaveDeHorarioDetalle2(String ClaveDeHorario) {
        String sql = ("select cdeschr from chorars where NIDHORA = " + ClaveDeHorario);
        return sql;}


    public String generarQueryHorarioClaveDeHorarioDetalle3(String ClaveDeHorario) {
        String sql = ("select dfecasi from dhremps where ccveemp = (select cceveemp from dhremps where nidhora = " + ClaveDeHorario);
        return sql;}




    private int tamanioDiasNoLaborales;

    private DiaNoLaboral[] diaNoLaboral;

    public DiaNoLaboral[] getDiaNoLaboralListo(){
        return this.diaNoLaboral;
    }


    public int getTamanioDiasNoLaborales() {
        return tamanioDiasNoLaborales;
    }

    public boolean consultaLaboralesStatus (Connection conn, String Status){
        try {
            ArrayList<DiaNoLaboral> listaDiasNoLaborales = new ArrayList<DiaNoLaboral>();
            Statement select = conn.createStatement();
            ResultSet resultado = select.executeQuery(generarQueryDiasNoLaboralesStatus(Status));

            while (resultado.next()){
                listaDiasNoLaborales.add(new DiaNoLaboral(resultado.getString(1), resultado.getString(2), Status));
            }
            return convertirArrayDiasNoLaborales(listaDiasNoLaborales);
        } catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }

    public boolean convertirArrayDiasNoLaborales ( ArrayList<DiaNoLaboral> listaDiasNoLaborales){
        int contador = listaDiasNoLaborales.size();
        this.tamanioDiasNoLaborales = contador;
        this.diaNoLaboral = new DiaNoLaboral[contador];
        for (int i=0; i<contador; i++){
            this.diaNoLaboral[i] = listaDiasNoLaborales.get(i);
        }
        return true;
    }

    public String generarQueryDiasNoLaboralesStatus (String Status){
        String sql = "select dfechnl, cmotivo from mdiasnl where cstatus = '" + Status + "'";
        return sql;
    }



    private int tamanioEmpleadosTabla;

    private Empleado[] Empleado;

    public Empleado[] getEmpleadoListo(){
        return this.Empleado;
    }


    public int getTamanioEmpleadosTablaTabla() {
        return tamanioEmpleadosTabla;
    }

    public boolean consultaHorariosClaveE (Connection conn, String ClaveDeHorario){
        try {
            ArrayList<Empleado> listaEmpleadosTabla = new ArrayList<Empleado>();
            Statement select = conn.createStatement();
            ResultSet resultado = select.executeQuery(generarQueryHorariosTablaClaveE(ClaveDeHorario));

            while (resultado.next()){
                listaEmpleadosTabla.add(new Empleado(resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(1)));
            }
            return convertirEmpleadosHorario(listaEmpleadosTabla);
        } catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }

    public boolean convertirEmpleadosHorario (ArrayList<Empleado> listaEmpleadosTabla){
        int contador = listaEmpleadosTabla.size();
        this.tamanioEmpleadosTabla = contador;
        this.Empleado = new Empleado[contador];
        for (int i=0; i<contador; i++){
            this.Empleado[i] = listaEmpleadosTabla.get(i);
        }
        return true;
    }

    public String generarQueryHorariosTablaClaveE (String ClaveDeHorario){
        String sql = "SELECT CCVEEMP, CNOMBRE, CAPEUNO, CAPEDOS FROM DDATEMP WHERE CCVEEMP = (SELECT CVEEMP FROM DHREMPS WHERE NIDHORA = " + ClaveDeHorario + ")";
        return sql;
    }



    private int tamanioJustificarIncidencias;

    private JIncidencias[] Jincidencias;

    public JIncidencias[] getJincidenciasListo(){
        return this.Jincidencias;
    }


    public int getTamanioJustificarIncidenciasIncidencias() {
        return tamanioJustificarIncidencias;
    }


    public boolean consultaJIncidencias (Connection conn, String IDEmpleado){
        try {
            ArrayList<JIncidencias> listaIncidenciasTabla = new ArrayList<JIncidencias>();
            Statement select = conn.createStatement();
            ResultSet resultado = select.executeQuery(generarQueryIncidenciasTablaJ(IDEmpleado));

            while (resultado.next()){
                listaIncidenciasTabla.add(new JIncidencias(resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(1)));
            }
            return convertirHorariosTabla(listaIncidenciasTabla);
        } catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }

    public boolean convertirHorariosTabla ( ArrayList<JIncidencias> listaIncidenciasTabla){
        int contador = listaIncidenciasTabla.size();
        this.tamanioJustificarIncidencias = contador;
        this.Jincidencias = new JIncidencias[contador];
        for (int i=0; i<contador; i++){
            this.Jincidencias[i] = listaIncidenciasTabla.get(i);
        }
        return true;
    }

    public String generarQueryIncidenciasTablaJ (String IDEmpleado){
        String sql = "SELECT DFECINC, CTIPINC, CSTATUS FROM TINCEMP WHERE CCVEEMP = " + IDEmpleado + ")";
        return sql;
    }

    private Empleado empleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public boolean buscarEmpleadoEntero(Connection connection, String clave){
        try {
            Temporal = new String[14];
            Statement select = connection.createStatement();
            ResultSet resultado = select.executeQuery(generarQueryEmpleadoEntero(clave));

            while (resultado.next()){
                for (int i = 1; i < 15; i++){
                    Temporal[i] = resultado.getString(i);
                }
            }

            return true;
        }catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }

    public String generarQueryEmpleadoEntero(String clave){
        return "SELECT * FROM DDATEMP WHERE CCVEEMP = '" + clave + "'";
    }


}
