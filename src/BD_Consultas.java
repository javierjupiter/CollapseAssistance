public class BD_Consultas {
    public String consultaEstados(){
        String sql = "SELECT CONCAT(ID_Estado,' ',Nombre_Estado) "
                + "FROM Estados_Pais "
                + "ORDER BY ID_Estado";
        return sql;
    }

    public String consultaMunicipios(int idEdo){
        String sql = "SELECT CONCAT(NIDMUNI,' ',Nombre_Municipio) "
                + " FROM Municipios_Estados "
                + " WHERE ID_Estado = " + idEdo
                + " ORDER BY ID_Municipios";
        return sql;
    }
}
